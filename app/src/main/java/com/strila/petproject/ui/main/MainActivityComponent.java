package com.strila.petproject.ui.main;

import android.app.Activity;

import com.strila.petproject.di.scope.ActivityScope;
import com.strila.petproject.ui.main.posts.PostListComponent;
import com.strila.petproject.ui.main.preview.PreviewComponent;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by Serhii Strila on 1/11/17
 */

@ActivityScope
@Subcomponent(
        modules = {
                PreviewComponent.PreviewModule.class,
                PostListComponent.PostListModule.class
        })
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {

    }

    @Module(subcomponents = MainActivityComponent.class)
    abstract class MainActivityModule {

        @Binds
        @IntoMap
        @ActivityKey(MainActivity.class)
        abstract AndroidInjector.Factory<? extends Activity>
        bindMainActivityInjectorFactory(MainActivityComponent.Builder builder);

        @ActivityScope
        @Binds
        abstract MainActivityRouter provideRouter(MainActivityRouterImpl router);

    }
}
