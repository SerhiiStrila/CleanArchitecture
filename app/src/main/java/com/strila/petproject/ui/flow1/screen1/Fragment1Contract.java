package com.strila.petproject.ui.flow1.screen1;

import com.strila.petproject.ui.base.BasePresenterDelegate;
import com.strila.petproject.ui.base.BaseViewDelegate;

/**
 * Created by Serhii Strila on 1/11/17
 */

public interface Fragment1Contract {

    interface View extends BaseViewDelegate {

    }

    interface Presenter extends BasePresenterDelegate {

        void next();
    }
}
