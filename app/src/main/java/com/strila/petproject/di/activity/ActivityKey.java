package com.strila.petproject.di.activity;

import android.app.Activity;

import dagger.MapKey;

/**
 * Created by Serhii Strila on 1/11/17
 */

@MapKey
public @interface ActivityKey {
    Class<? extends Activity> value();
}
