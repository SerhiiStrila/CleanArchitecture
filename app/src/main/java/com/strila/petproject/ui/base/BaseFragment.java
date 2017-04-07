package com.strila.petproject.ui.base;

import android.app.Fragment;
import android.content.Context;
import android.support.annotation.CallSuper;

import dagger.android.AndroidInjection;


/**
 * Created by Serhii Strila on 1/11/17
 */

public abstract class BaseFragment<T extends BasePresenterDelegate> extends Fragment {

    @CallSuper
    @Override
    public void onAttach(Context context) {
        AndroidInjection.inject(this);
        super.onAttach(context);
    }

    @CallSuper
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getPresenter().detach();
    }

    protected abstract T getPresenter();

}