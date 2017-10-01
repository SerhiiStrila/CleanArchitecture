package com.strila.petproject.ui.main.preview;

import com.squareup.picasso.RequestCreator;
import com.strila.petproject.ui.base.BasePresenterDelegate;
import com.strila.petproject.ui.base.BaseViewDelegate;

import javax.annotation.Nonnull;

/**
 * Created by Serhii Strila on 1/11/17
 */

public interface PreviewContract {

    interface View extends BaseViewDelegate {

        void showImage(RequestCreator image);
    }

    interface Presenter extends BasePresenterDelegate {

        void updateImage(@Nonnull String url);

        void openUrl(@Nonnull String imageUrl);
    }

}
