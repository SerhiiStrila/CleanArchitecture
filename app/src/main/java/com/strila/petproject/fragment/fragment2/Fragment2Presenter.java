package com.strila.petproject.fragment.fragment2;

import android.support.annotation.NonNull;

import com.strila.petproject.activity.activity1.MainActivityRouter;
import com.strila.petproject.base.BasePresenter;
import com.strila.petproject.di.fragment.FragmentScope;

import javax.inject.Inject;

/**
 * Created by Serhii Strila on 1/11/17
 */

@FragmentScope
public final class Fragment2Presenter extends BasePresenter<Fragment2Contract.View, MainActivityRouter>
        implements Fragment2Contract.Presenter {

    @Inject
    Fragment2Presenter(@NonNull Fragment2Contract.View view,
            @NonNull MainActivityRouter router) {
        super(view, router);
    }

    @Override
    public void next() {
        router.goNext();
    }
}
