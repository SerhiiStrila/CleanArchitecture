package com.strila.petproject.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;

import com.strila.petproject.di.base.fragment.HasFragmentSubComponentBuilders;


/**
 * Created by Serhii Strila on 1/11/17
 */

public abstract class BaseFragment<T extends BasePresenterDelegate> extends Fragment {

    @CallSuper
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupFragmentComponent((HasFragmentSubComponentBuilders) getActivity());
    }

    @CallSuper
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getPresenter().detach();
    }

    protected abstract void setupFragmentComponent(HasFragmentSubComponentBuilders builders);

    protected abstract T getPresenter();

}
