package com.strila.petproject.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;

import dagger.android.AndroidInjection;

/**
 * Created by Serhii Strila on 1/11/17
 */

public abstract class BaseActivity extends Activity {

    @CallSuper
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

}