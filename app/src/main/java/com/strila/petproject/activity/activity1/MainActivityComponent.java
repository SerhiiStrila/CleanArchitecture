package com.strila.petproject.activity.activity1;

import com.strila.petproject.di.activity.ActivityComponent;
import com.strila.petproject.di.activity.ActivityComponentBuilder;
import com.strila.petproject.di.activity.ActivityModule;
import com.strila.petproject.di.activity.ActivityScope;
import com.strila.petproject.fragment.fragment1.MainActivityBindingModule;

import dagger.Module;
import dagger.Provides;
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
    interface Builder extends ActivityComponentBuilder<MainActivityModule, MainActivityComponent> {

    }

    @Module
    class MainActivityModule extends ActivityModule<MainActivity> {

        MainActivityModule(MainActivity activity) {
            super(activity);
        }

        @ActivityScope
        @Provides
        MainActivityRouter provideRouter(MainActivity activity) {
            return new MainActivityRouterImpl(activity);
        }
    }
}
