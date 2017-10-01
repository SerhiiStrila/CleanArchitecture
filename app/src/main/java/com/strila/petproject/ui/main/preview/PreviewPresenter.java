package com.strila.petproject.ui.main.preview;

import android.content.Context;
import android.support.annotation.NonNull;

import com.squareup.picasso.Picasso;
import com.strila.petproject.R;
import com.strila.petproject.di.scope.FragmentScope;
import com.strila.petproject.ui.base.BasePresenter;
import com.strila.petproject.ui.main.MainActivityRouter;

import javax.annotation.Nonnull;
import javax.inject.Inject;

/**
 * Created by Serhii Strila on 1/11/17
 */

@FragmentScope
public final class PreviewPresenter extends BasePresenter<PreviewContract.View, MainActivityRouter>
        implements PreviewContract.Presenter {

    @Inject Context context;

    @Inject
    PreviewPresenter(@NonNull PreviewContract.View view,
                     @NonNull MainActivityRouter router) {
        super(view, router);
    }

    @Override
    public void updateImage(@Nonnull String url) {
        view.showImage(Picasso.with(context)
                .load(url)
                .placeholder(R.drawable.ic_filter_hdr_white_24dp));
    }

    @Override
    public void openUrl(@Nonnull String imageUrl) {
        router.goToShare(imageUrl);
    }
}
