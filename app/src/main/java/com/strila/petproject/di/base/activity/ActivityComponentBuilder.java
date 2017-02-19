package com.strila.petproject.di.base.activity;

import com.strila.petproject.ui.base.BaseActivity;

import dagger.BindsInstance;

/**
 * Created by Serhii Strila on 1/11/17
 */

public interface ActivityComponentBuilder<A extends BaseActivity, C extends ActivityComponent> {

    @BindsInstance
    ActivityComponentBuilder<A, C> activity(A activity);

    C build();
}