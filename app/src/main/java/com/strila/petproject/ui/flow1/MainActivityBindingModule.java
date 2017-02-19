package com.strila.petproject.ui.flow1;

import com.strila.petproject.di.base.fragment.FragmentComponentBuilder;
import com.strila.petproject.di.base.fragment.FragmentKey;
import com.strila.petproject.ui.flow1.screen1.Fragment1;
import com.strila.petproject.ui.flow1.screen1.Fragment1Component;
import com.strila.petproject.ui.flow1.screen2.Fragment2;
import com.strila.petproject.ui.flow1.screen2.Fragment2Component;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by Serhii Strila on 1/11/17
 */

@Module(
        subcomponents = {
                Fragment1Component.class,
                Fragment2Component.class
        })
abstract class MainActivityBindingModule {

    @Binds
    @IntoMap
    @FragmentKey(Fragment1.class)
    abstract FragmentComponentBuilder fragment1ComponentBuilder(Fragment1Component.Builder impl);

    @Binds
    @IntoMap
    @FragmentKey(Fragment2.class)
    abstract FragmentComponentBuilder fragment2ComponentBuilder(Fragment2Component.Builder impl);
}