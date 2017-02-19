package com.strila.petproject.di.base.fragment;

import com.strila.petproject.ui.base.BaseFragment;

import dagger.BindsInstance;

/**
 * Created by Serhii Strila on 1/11/17
 */

public interface FragmentComponentBuilder<F extends BaseFragment, C extends FragmentComponent> {

    @BindsInstance
    FragmentComponentBuilder<F, C> fragment(F fragment);

    C build();
}