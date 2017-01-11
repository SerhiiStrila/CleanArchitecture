package com.strila.petproject.fragment.fragment1;

import com.strila.petproject.base.BasePresenterDelegate;
import com.strila.petproject.base.BaseViewDelegate;

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
