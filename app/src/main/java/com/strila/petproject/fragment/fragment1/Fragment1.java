package com.strila.petproject.fragment.fragment1;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.strila.petproject.R;
import com.strila.petproject.base.BaseFragment;
import com.strila.petproject.di.fragment.HasFragmentSubComponentBuilders;

import javax.inject.Inject;

/**
 * Created by Serhii Strila on 1/11/17
 */

public class Fragment1 extends BaseFragment<Fragment1Contract.Presenter> implements Fragment1Contract.View {

    @Inject Fragment1Presenter presenter;

    public static Fragment1 newInstance() {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.next();
            }
        });
        return view;
    }

    @Override
    protected void setupFragmentComponent(HasFragmentSubComponentBuilders builders) {
        ((Fragment1Component.Builder)builders.getFragmentComponentBuilder(Fragment1.class))
                .module(new Fragment1Component.Fragment1Module(this))
                .build()
                .inject(this);
    }

    @Override
    protected Fragment1Contract.Presenter getPresenter() {
        return presenter;
    }
}
