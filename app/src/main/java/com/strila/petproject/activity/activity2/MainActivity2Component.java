package com.strila.petproject.activity.activity2;

import com.strila.petproject.activity.activity1.MainActivityRouter;
import com.strila.petproject.di.base.activity.ActivityComponent;
import com.strila.petproject.di.base.activity.ActivityComponentBuilder;
import com.strila.petproject.di.base.activity.ActivityModule;
import com.strila.petproject.di.base.activity.ActivityScope;

import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;

/**
 * Created by Serhii Strila on 1/11/17
 */

@ActivityScope
@Subcomponent(
        modules = {
                MainActivity2Component.MainActivity2Module.class,
                MainActivity2BindingModule.class
        }
)
public interface MainActivity2Component extends ActivityComponent<MainActivity2> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<MainActivity2Module, MainActivity2Component> {

    }

    @Module
    final class MainActivity2Module extends ActivityModule<MainActivity2> {

        MainActivity2Module(MainActivity2 activity) {
            super(activity);
        }

        @ActivityScope
        @Provides
        static MainActivityRouter provideRouter(MainActivity2 activity) {
            return new MainActivity2RouterImpl(activity);
        }
    }
}
