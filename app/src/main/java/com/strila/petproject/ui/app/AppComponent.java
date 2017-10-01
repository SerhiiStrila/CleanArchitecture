package com.strila.petproject.ui.app;

import android.content.Context;

import com.strila.petproject.di.module.LocalDataModule;
import com.strila.petproject.di.module.NetworkModule;
import com.strila.petproject.di.module.RepoModule;
import com.strila.petproject.di.scope.ApplicationScope;
import com.strila.petproject.ui.flow1.MainActivityComponent;
import com.strila.petproject.ui.flow2.MainActivity2Component;

import dagger.Component;
import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjector;

/**
 * Created by Serhii Strila on 1/11/17
 */

@ApplicationScope
@Component(
        modules = {
                AppComponent.AppModule.class,
                RepoModule.class,
                NetworkModule.class,
                LocalDataModule.class,
                MainActivityComponent.MainActivityModule.class,
                MainActivity2Component.MainActivity2Module.class
        }
)
interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {
        abstract Builder appModule(AppModule appModule);
    }

    @Module
    class AppModule {

        private App app;

        AppModule(App app) {
            this.app = app;
        }

        @ApplicationScope
        @Provides
        Context provideContext() {
            return app;
        }
    }
}