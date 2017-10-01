package com.strila.petproject.data.interactor;

import com.strila.petproject.data.models.local.Pagination;
import com.strila.petproject.data.models.local.Post;
import com.strila.petproject.data.source.repo.DataRepo;
import com.strila.petproject.ui.base.Interactor;

import java.util.List;

import javax.annotation.Nonnull;
import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Serhii Strila on 10/1/17
 */

public final class PostInteractor extends Interactor {

    private static final int PAGINATION_LIMIT = 10;

    @Inject DataRepo repo;

    @Inject
    PostInteractor() {

    }

    public Single<List<Post>> getTop() {
        return repo.getTop().compose(applySchedulersToSingle());
    }

    public Single<List<Post>> reloadTop(@Nonnull Pagination pagination) {
        return repo.reloadTop(pagination, PAGINATION_LIMIT)
                .compose(applySchedulersToSingle());
    }

    public Single<List<Post>> updateTop(@Nonnull Pagination pagination) {
        return repo.updateTop(pagination, PAGINATION_LIMIT)
                .compose(applySchedulersToSingle());
    }
}
