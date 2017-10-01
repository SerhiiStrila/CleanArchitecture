package com.strila.petproject.ui.base;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;

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
        getPresenter().attach();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            getPresenter().restoreState(savedInstanceState);
        }
    }

    @CallSuper
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getPresenter().detach();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getPresenter().saveState(outState);
    }

    protected abstract T getPresenter();

}