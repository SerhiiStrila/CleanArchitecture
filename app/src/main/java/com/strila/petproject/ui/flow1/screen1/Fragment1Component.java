package com.strila.petproject.ui.flow1.screen1;

import com.strila.petproject.di.base.fragment.FragmentComponent;
import com.strila.petproject.di.base.fragment.FragmentComponentBuilder;
import com.strila.petproject.di.base.fragment.FragmentModule;
import com.strila.petproject.di.base.fragment.FragmentScope;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;

import static com.strila.petproject.ui.flow1.screen1.Fragment1Component.Fragment1Module;

/**
 * Created by Serhii Strila on 1/11/17
 */

@FragmentScope
@Subcomponent(
        modules = {
                Fragment1Module.class,
        }
)
public interface Fragment1Component extends FragmentComponent<Fragment1> {

    @Subcomponent.Builder
    interface Builder extends FragmentComponentBuilder<Fragment1, Fragment1Component> {

    }

    @Module
    abstract class Fragment1Module extends FragmentModule<Fragment1> {

        @FragmentScope
        @Binds
        public abstract Fragment1Contract.View bindView(Screen1ViewModel viewModel);

        @FragmentScope
        @Binds
        public abstract Fragment1Contract.Presenter bindPresenter(Fragment1Presenter presenter);

    }
}
