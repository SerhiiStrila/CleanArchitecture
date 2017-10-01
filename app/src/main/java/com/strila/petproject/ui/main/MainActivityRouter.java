package com.strila.petproject.ui.main;

import android.view.View;

import com.strila.petproject.ui.base.Router;

/**
 * Created by Serhii Strila on 1/12/17
 */

public interface MainActivityRouter extends Router {

    void init();

    void goToPreview(View view, String imageUrl);

    void goToShare(String imageUrl);
}
