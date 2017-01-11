package com.strila.petproject.di.fragment;

import android.app.Fragment;

/**
 * Created by Serhii Strila on 1/11/17
 */

public interface HasFragmentSubComponentBuilders {

    FragmentComponentBuilder getFragmentComponentBuilder(Class<? extends Fragment> fragmentClass);
}
