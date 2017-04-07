package com.strila.petproject.ui.app;

import com.strila.petproject.di.scope.ApplicationScope;
import com.strila.petproject.ui.flow1.MainActivityComponent;
import com.strila.petproject.ui.flow2.MainActivity2Component;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Created by Serhii Strila on 1/11/17
 */

@ApplicationScope
@Component(
        modules = {
                MainActivityComponent.MainActivityModule.class,
                MainActivity2Component.MainActivity2Module.class
        }
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(App app);

        AppComponent build();
    }

    void inject(App app);
}