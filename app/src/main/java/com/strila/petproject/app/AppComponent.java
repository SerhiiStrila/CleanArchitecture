package com.strila.petproject.app;

import com.strila.petproject.di.base.app.ApplicationComponent;
import com.strila.petproject.di.base.app.ApplicationModule;
import com.strila.petproject.di.base.app.ApplicationScope;

import dagger.Component;
import dagger.Module;

/**
 * Created by Serhii Strila on 1/11/17
 */

@ApplicationScope
@Component(
        modules = {
                AppComponent.AppModule.class,
                ActivityBindingModule.class
        }
)
interface AppComponent extends ApplicationComponent<App> {

    @Module
    class AppModule extends ApplicationModule<App> {

        public AppModule(App application) {
            super(application);
        }
    }
}