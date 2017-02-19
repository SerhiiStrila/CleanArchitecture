package com.strila.petproject.ui.flow1;

import com.strila.petproject.di.base.activity.ActivityComponent;
import com.strila.petproject.di.base.activity.ActivityComponentBuilder;
import com.strila.petproject.di.base.activity.ActivityModule;
import com.strila.petproject.di.base.activity.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;

/**
 * Created by Serhii Strila on 1/11/17
 */

@ActivityScope
@Subcomponent(
        modules = {
                MainActivityComponent.MainActivityModule.class,
                MainActivityBindingModule.class
        }
)
public interface MainActivityComponent extends ActivityComponent<MainActivity> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<MainActivity, MainActivityComponent> {

    }

    @Module
    abstract class MainActivityModule extends ActivityModule<MainActivity> {

        @ActivityScope
        @Binds
        abstract MainActivityRouter provideRouter(MainActivityRouterImpl router);

    }
}
