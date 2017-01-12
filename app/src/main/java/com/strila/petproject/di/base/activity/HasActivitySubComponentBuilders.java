package com.strila.petproject.di.base.activity;

import android.app.Activity;

/**
 * Created by Serhii Strila on 1/11/17
 */

public interface HasActivitySubComponentBuilders {

    ActivityComponentBuilder getActivityComponentBuilder(Class<? extends Activity> activityClass);
}