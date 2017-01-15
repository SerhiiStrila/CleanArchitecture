package com.strila.petproject.di.base.fragment;

import android.app.Fragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Serhii Strila on 1/11/17
 */

@Module
public abstract class FragmentModule<T extends Fragment> {

    protected final T fragment;

    public FragmentModule(T fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public T provideFragment() {
        return fragment;
    }
}
