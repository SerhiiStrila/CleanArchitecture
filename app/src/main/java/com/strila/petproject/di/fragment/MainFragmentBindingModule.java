package com.strila.petproject.di.fragment;

import com.strila.petproject.activity.activity2.MainActivity2Component;
import com.strila.petproject.activity.activity1.MainActivityComponent;

import dagger.Module;

/**
 * Created by Serhii Strila on 1/11/17
 */

@Module(
        subcomponents = {
                MainActivityComponent.class,
                MainActivity2Component.class
        })
public abstract class MainFragmentBindingModule {

}
