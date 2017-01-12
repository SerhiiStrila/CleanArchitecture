package com.strila.petproject.fragment.fragment2;

import com.strila.petproject.di.base.fragment.FragmentComponent;
import com.strila.petproject.di.base.fragment.FragmentComponentBuilder;
import com.strila.petproject.di.base.fragment.FragmentModule;
import com.strila.petproject.di.base.fragment.FragmentScope;

import dagger.Module;
import dagger.Provides;
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
    interface Builder extends FragmentComponentBuilder<Fragment2Module, Fragment2Component> {

    }

    @Module
    class Fragment2Module extends FragmentModule<Fragment2> {

        Fragment2Module(Fragment2 fragment) {
            super(fragment);
        }

        @FragmentScope
        @Provides
        Fragment2Contract.View provideView(Fragment2 fragment) {
            return fragment;
        }
    }
}
