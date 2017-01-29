package com.strila.petproject.ui.flow1.screen2;

import com.strila.petproject.ui.base.BasePresenterDelegate;
import com.strila.petproject.ui.base.BaseViewDelegate;

/**
 * Created by Serhii Strila on 1/11/17
 */

public interface Fragment2Contract {

    interface View extends BaseViewDelegate {

    }

    interface Presenter extends BasePresenterDelegate {

        void next();
    }
}
