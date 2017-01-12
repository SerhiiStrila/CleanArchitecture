package com.strila.petproject.app;

import com.strila.petproject.activity.activity1.MainActivity;
import com.strila.petproject.activity.activity1.MainActivityComponent;
import com.strila.petproject.activity.activity2.MainActivity2;
import com.strila.petproject.activity.activity2.MainActivity2Component;
import com.strila.petproject.di.base.activity.ActivityComponentBuilder;
import com.strila.petproject.di.base.activity.ActivityKey;

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
public abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    public abstract ActivityComponentBuilder mainActivityComponentBuilder(MainActivityComponent.Builder impl);

    @Binds
    @IntoMap
    @ActivityKey(MainActivity2.class)
    public abstract ActivityComponentBuilder main2ActivityComponentBuilder(MainActivity2Component.Builder impl);
}