package com.strila.petproject.ui.flow1.screen1;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.strila.petproject.databinding.FragmentFragment1Binding;
import com.strila.petproject.ui.base.BaseFragment;

import javax.inject.Inject;

/**
 * Created by Serhii Strila on 1/11/17
 */

public final class Fragment1 extends BaseFragment<Fragment1Contract.Presenter> implements Fragment1Contract.Listener {

    @Inject Fragment1Contract.Presenter presenter;
    @Inject Screen1ViewModel mViewModel;

    public static Fragment1 newInstance() {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        FragmentFragment1Binding binding = FragmentFragment1Binding.inflate(inflater, container, false);
        binding.setViewModel(mViewModel);
        binding.setListener(this);
        return binding.getRoot();
    }

    @Override
    public void onNextScreenClick() {
        presenter.next();
    }

    @Override
    public void onButtonClick() {
        presenter.doSomething();
    }

    @Override
    protected Fragment1Contract.Presenter getPresenter() {
        return presenter;
    }
}
