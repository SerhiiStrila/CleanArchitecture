package com.strila.petproject.ui.app;

import android.app.Activity;
import android.app.Application;

import com.strila.petproject.di.base.activity.ActivityComponentBuilder;
import com.strila.petproject.di.base.activity.HasActivitySubComponentBuilders;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by Serhii Strila on 1/11/17
 */

public class App extends Application implements HasActivitySubComponentBuilders {

    @Inject Map<Class<? extends Activity>, Provider<ActivityComponentBuilder>> mActivityComponentBuilders;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder()
                .appModule(new AppComponent.AppModule(this))
                .build()
                .inject(this);
    }

    @Override
    public ActivityComponentBuilder getActivityComponentBuilder(Class<? extends Activity> activityClass) {
        return mActivityComponentBuilders.get(activityClass).get();
    }
}
