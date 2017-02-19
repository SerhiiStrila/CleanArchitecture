package com.strila.petproject.ui.flow2;

import android.app.Fragment;

import com.strila.petproject.di.base.activity.ActivityComponent;
import com.strila.petproject.di.base.activity.ActivityComponentBuilder;
import com.strila.petproject.di.base.activity.ActivityModule;
import com.strila.petproject.di.base.activity.ActivityScope;
import com.strila.petproject.di.base.fragment.FragmentComponentBuilder;

import java.util.Collections;
import java.util.Map;

import javax.inject.Provider;

import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;

/**
 * Created by Serhii Strila on 1/11/17
 */

@ActivityScope
@Subcomponent(
        modules = {
                MainActivity2Component.MainActivity2Module.class
        }
)
public interface MainActivity2Component extends ActivityComponent<MainActivity2> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<MainActivity2, MainActivity2Component> {

    }

    @Module
    abstract class MainActivity2Module extends ActivityModule<MainActivity2> {

        @ActivityScope
        @Provides
        static Map<Class<? extends Fragment>, Provider<FragmentComponentBuilder>> provideMap() {
            return Collections.emptyMap();
        }
    }
}
