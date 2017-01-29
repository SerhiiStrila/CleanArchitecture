package com.strila.petproject.ui.app;

import com.strila.petproject.di.base.activity.ActivityComponentBuilder;
import com.strila.petproject.di.base.activity.ActivityKey;
import com.strila.petproject.ui.flow1.MainActivity;
import com.strila.petproject.ui.flow1.MainActivityComponent;
import com.strila.petproject.ui.flow2.MainActivity2;
import com.strila.petproject.ui.flow2.MainActivity2Component;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by Serhii Strila on 1/11/17
 */

@Module(
        subcomponents = {
                MainActivityComponent.class,
                MainActivity2Component.class
        })
abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract ActivityComponentBuilder mainActivityComponentBuilder(MainActivityComponent.Builder impl);

    @Binds
    @IntoMap
    @ActivityKey(MainActivity2.class)
    abstract ActivityComponentBuilder main2ActivityComponentBuilder(MainActivity2Component.Builder impl);
}