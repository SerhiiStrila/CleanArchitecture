package com.strila.petproject.fragment.fragment1;

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
        modules = {
                Fragment1Component.Fragment1Module.class,
                Fragment1Component.Fragment1ModuleBinds.class
        }
)
public interface Fragment1Component extends FragmentComponent<Fragment1> {

    @Subcomponent.Builder
    interface Builder extends FragmentComponentBuilder<Fragment1Module, Fragment1Component> {

    }

    @Module
    class Fragment1Module extends FragmentModule<Fragment1> {

        Fragment1Module(Fragment1 fragment) {
            super(fragment);
        }

    }

    @Module
    abstract class Fragment1ModuleBinds {

        @FragmentScope
        @Binds
        abstract Fragment1Contract.View bindView(Fragment1 fragment1);

        @FragmentScope
        @Binds
        abstract Fragment1Contract.Presenter bindPresenter(Fragment1Presenter presenter);
    }
}
