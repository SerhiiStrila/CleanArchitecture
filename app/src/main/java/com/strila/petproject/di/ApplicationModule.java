package com.strila.petproject.di;

import com.strila.petproject.App;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Serhii Strila on 1/11/17
 */

@Module
public class ApplicationModule {

    private App mApp;

    public ApplicationModule(App app) {
        mApp = app;
    }

    @Provides
    @AppScope
    App provideApplication() {
        return mApp;
    }

}
