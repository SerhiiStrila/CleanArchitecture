package com.strila.petproject.ui.flow2;

import android.app.Activity;

import com.strila.petproject.di.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by Serhii Strila on 1/11/17
 */

@ActivityScope
@Subcomponent
public interface MainActivity2Component extends AndroidInjector<MainActivity2> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity2> {

    }

    @Module(subcomponents = MainActivity2Component.class)
    abstract class MainActivity2Module {

        @Binds
        @IntoMap
        @ActivityKey(MainActivity2.class)
        abstract AndroidInjector.Factory<? extends Activity>
        bindMainActivity2InjectorFactory(MainActivity2Component.Builder builder);

    }
}
