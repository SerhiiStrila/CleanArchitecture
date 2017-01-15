package com.strila.petproject.di.base.app;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Serhii Strila on 1/12/17
 */

@Module
public abstract class ApplicationModule<T extends Application> {

    protected final T app;

    public ApplicationModule(T application) {
        this.app = application;
    }

    @Provides
    @ApplicationScope
    public T provideApp() {
        return app;
    }
}
