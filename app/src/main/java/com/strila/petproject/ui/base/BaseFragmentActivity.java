package com.strila.petproject.ui.base;

import android.app.Fragment;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;

/**
 * Created by Serhii Strila on 1/11/17
 */

public abstract class BaseFragmentActivity extends BaseActivity implements HasFragmentInjector {

    @Inject DispatchingAndroidInjector<Fragment> mFragmentInjector;

    @Override
    public DispatchingAndroidInjector<Fragment> fragmentInjector() {
        return mFragmentInjector;
    }

}