package com.strila.petproject.ui.flow1.screen2;

import com.strila.petproject.di.base.fragment.FragmentComponent;
import com.strila.petproject.di.base.fragment.FragmentComponentBuilder;
import com.strila.petproject.di.base.fragment.FragmentModule;
import com.strila.petproject.di.base.fragment.FragmentScope;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;

/**
 * Created by Serhii Strila on 1/11/17
 */

@FragmentScope
@Subcomponent(
        modules = Fragment2Component.Fragment2Module.class
)
public interface Fragment2Component extends FragmentComponent<Fragment2> {

    @Subcomponent.Builder
    interface Builder extends FragmentComponentBuilder<Fragment2, Fragment2Component> {

    }

    @Module
    abstract class Fragment2Module extends FragmentModule<Fragment2> {

        @FragmentScope
        @Binds
        abstract Fragment2Contract.View bindView(Fragment2 fragment);

        @FragmentScope
        @Binds
        abstract Fragment2Contract.Presenter bindPresenter(Fragment2Presenter presenter);

    }
}
