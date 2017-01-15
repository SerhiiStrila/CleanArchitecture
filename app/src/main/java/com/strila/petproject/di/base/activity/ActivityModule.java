package com.strila.petproject.di.base.activity;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Serhii Strila on 1/11/17
 */

@Module
public abstract class ActivityModule<T extends Activity> {

    protected final T activity;

    public ActivityModule(T activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    public T provideActivity() {
        return activity;
    }
}
