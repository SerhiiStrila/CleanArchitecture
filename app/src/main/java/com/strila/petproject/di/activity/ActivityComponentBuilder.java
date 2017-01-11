package com.strila.petproject.di.activity;

/**
 * Created by Serhii Strila on 1/11/17
 */

public interface ActivityComponentBuilder<M extends ActivityModule, C extends ActivityComponent> {

    ActivityComponentBuilder<M, C> activityModule(M activityModule);

    C build();
}