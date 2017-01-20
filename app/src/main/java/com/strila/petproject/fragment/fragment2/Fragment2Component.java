package com.strila.petproject.fragment.fragment2;

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
    interface Builder extends FragmentComponentBuilder<Fragment2Module, Fragment2Component> {

    }

    @Module(includes = Fragment2Module.Fragment2Declarations.class)
    final class Fragment2Module extends FragmentModule<Fragment2> {

        @Module
        public interface Fragment2Declarations {

            @FragmentScope
            @Binds
            Fragment2Contract.View bindView(Fragment2 fragment);

            @FragmentScope
            @Binds
            Fragment2Contract.Presenter bindPresenter(Fragment2Presenter presenter);
        }

        Fragment2Module(Fragment2 fragment) {
            super(fragment);
        }
    }
}
