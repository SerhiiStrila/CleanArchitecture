package com.strila.petproject.di.base.fragment;

import android.app.Fragment;

/**
 * Created by Serhii Strila on 1/11/17
 */

public interface FragmentComponent<F extends Fragment> {

    void inject(F fragment);
}
