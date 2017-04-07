package com.strila.petproject.ui.flow1.screen2;

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
public interface Fragment2Component extends AndroidInjector<Fragment2> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<Fragment2> {

    }

    @Module(subcomponents = Fragment2Component.class)
    abstract class Fragment2Module {

        @Binds
        @IntoMap
        @FragmentKey(Fragment2.class)
        abstract AndroidInjector.Factory<? extends Fragment>
        bindFragment2InjectorFactory(Fragment2Component.Builder builder);

        @FragmentScope
        @Binds
        abstract Fragment2Contract.View bindView(Fragment2 fragment);

        @FragmentScope
        @Binds
        abstract Fragment2Contract.Presenter bindPresenter(Fragment2Presenter presenter);

    }
}
