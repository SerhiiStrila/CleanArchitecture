package com.strila.petproject.di;

import com.strila.petproject.App;
import com.strila.petproject.di.activity.ActivityBindingModule;

import dagger.Component;

/**
 * Created by Serhii Strila on 1/11/17
 */

@AppScope
@Component(
        modules = {
                ApplicationModule.class,
                ActivityBindingModule.class
        }
)
public interface ApplicationComponent {

    void inject(App app);
}
