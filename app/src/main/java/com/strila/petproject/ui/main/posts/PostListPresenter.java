package com.strila.petproject.ui.main.posts;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.strila.petproject.data.interactor.PostInteractor;
import com.strila.petproject.data.models.local.Pagination;
import com.strila.petproject.di.scope.FragmentScope;
import com.strila.petproject.ui.base.BasePresenter;
import com.strila.petproject.ui.main.MainActivityRouter;

import javax.inject.Inject;

/**
 * Created by Serhii Strila on 1/11/17
 */

@FragmentScope
public final class PostListPresenter extends BasePresenter<PostListContract.View, MainActivityRouter>
        implements PostListContract.Presenter {

    private static final String PAGINATION_KEY = "AFTER";

    @Inject PostInteractor postInteractor;

    private Pagination pagination;

    @Inject
    PostListPresenter(@NonNull PostListContract.View view, @NonNull MainActivityRouter router) {
        super(view, router);
        pagination = new Pagination();
    }

    @Override
    public void loadMore() {
        disposables.add(postInteractor.updateTop(pagination)
                .subscribe(posts -> view.addPosts(posts), Throwable::printStackTrace));
    }

    @Override
    public void reload() {
        pagination.setAfter(null);
        disposables.add(postInteractor.reloadTop(pagination)
                .subscribe(posts -> view.setPosts(posts), Throwable::printStackTrace));
    }

    @Override
    public void showImage(View view, String imageUrl) {
        router.goToPreview(view, imageUrl);
    }

    @Override
    public void attach() {
        super.attach();
        disposables.add(postInteractor.getTop()
                .subscribe(posts -> view.addPosts(posts), Throwable::printStackTrace));
    }

    @Override
    public void saveState(Bundle savedInstanceState) {
        super.saveState(savedInstanceState);
        savedInstanceState.putParcelable(PAGINATION_KEY, pagination);
    }

    @Override
    public void restoreState(Bundle savedInstanceState) {
        super.restoreState(savedInstanceState);
        pagination = savedInstanceState.getParcelable(PAGINATION_KEY);
    }
}
