package com.strila.petproject.ui.flow1.screen1;

import android.app.Fragment;

import com.strila.petproject.di.scope.FragmentScope;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.FragmentKey;
import dagger.multibindings.IntoMap;

/**
 * Created by Serhii Strila on 1/11/17
 */

@FragmentScope
@Subcomponent
public interface Fragment1Component extends AndroidInjector<Fragment1> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<Fragment1> {

    }

    @Module(subcomponents = Fragment1Component.class)
    abstract class Fragment1Module {

        @FragmentScope
        @Binds
        public abstract Fragment1Contract.View bindView(Screen1ViewModel viewModel);

        @FragmentScope
        @Binds
        public abstract Fragment1Contract.Presenter bindPresenter(Fragment1Presenter presenter);

        @Binds
        @IntoMap
        @FragmentKey(Fragment1.class)
        abstract AndroidInjector.Factory<? extends Fragment>
        bindFragment1InjectorFactory(Fragment1Component.Builder builder);

    }
}
