package com.strila.petproject.ui.base;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;

import com.strila.petproject.di.base.activity.HasActivitySubComponentBuilders;
import com.strila.petproject.di.base.fragment.FragmentComponentBuilder;
import com.strila.petproject.di.base.fragment.HasFragmentSubComponentBuilders;
import com.strila.petproject.ui.app.App;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by Serhii Strila on 1/11/17
 */

public abstract class BaseActivity extends Activity implements HasFragmentSubComponentBuilders {

    @Inject Map<Class<? extends Fragment>, Provider<FragmentComponentBuilder>> mFragmentComponentBuilders;

    @Override
    public FragmentComponentBuilder getFragmentComponentBuilder(Class<? extends Fragment> fragmentClass) {
        if (mFragmentComponentBuilders == null) {
            setupActivityComponent((App) getApplicationContext());
        }
        return mFragmentComponentBuilders.get(fragmentClass).get();
    }

    @CallSuper
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent((App) getApplicationContext());
    }

    protected abstract void setupActivityComponent(HasActivitySubComponentBuilders builders);
}
