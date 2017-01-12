package com.strila.petproject.di.base.fragment;

/**
 * Created by Serhii Strila on 1/11/17
 */

public interface FragmentComponentBuilder<M extends FragmentModule, C extends FragmentComponent> {

    FragmentComponentBuilder<M, C> module(M fragmentModule);

    C build();
}