package com.strila.petproject.fragment.fragment1;

import android.support.annotation.NonNull;

import com.strila.petproject.activity.activity1.MainActivityRouter;
import com.strila.petproject.base.BasePresenter;
import com.strila.petproject.di.fragment.FragmentScope;

import javax.inject.Inject;

/**
 * Created by Serhii Strila on 1/11/17
 */

@FragmentScope
public final class Fragment1Presenter extends BasePresenter<Fragment1Contract.View, MainActivityRouter>
        implements Fragment1Contract.Presenter {

    @Inject
    Fragment1Presenter(@NonNull Fragment1Contract.View view,
            @NonNull MainActivityRouter router) {
        super(view, router);
    }

    @Override
    public void next() {
        router.goNext();
    }
}
