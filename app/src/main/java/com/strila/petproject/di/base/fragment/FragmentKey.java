package com.strila.petproject.di.base.fragment;

import android.app.Fragment;

import dagger.MapKey;

/**
 * Created by Serhii Strila on 1/11/17
 */

@MapKey
public @interface FragmentKey {
    Class<? extends Fragment> value();
}
