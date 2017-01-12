package com.strila.petproject.fragment.fragment2;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.strila.petproject.R;
import com.strila.petproject.base.BaseFragment;
import com.strila.petproject.di.base.fragment.HasFragmentSubComponentBuilders;

import javax.inject.Inject;

/**
 * Created by Serhii Strila on 1/11/17
 */

public class Fragment2 extends BaseFragment<Fragment2Contract.Presenter> implements Fragment2Contract.View {

    @Inject Fragment2Presenter presenter;

    public static Fragment2 newInstance() {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
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
        ((Fragment2Component.Builder)builders.getFragmentComponentBuilder(Fragment2.class))
                .module(new Fragment2Component.Fragment2Module(this))
                .build()
                .inject(this);
    }

    @Override
    protected Fragment2Contract.Presenter getPresenter() {
        return presenter;
    }
}
