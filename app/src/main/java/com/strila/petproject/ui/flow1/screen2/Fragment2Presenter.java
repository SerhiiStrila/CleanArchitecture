package com.strila.petproject.ui.flow1.screen2;

import android.support.annotation.NonNull;

import com.strila.petproject.di.base.fragment.FragmentScope;
import com.strila.petproject.ui.base.BasePresenter;
import com.strila.petproject.ui.flow1.MainActivityRouter;

import javax.inject.Inject;

/**
 * Created by Serhii Strila on 1/11/17
 */

@FragmentScope
public final class Fragment2Presenter extends BasePresenter<Fragment2Contract.View, MainActivityRouter>
        implements Fragment2Contract.Presenter {

    @Inject
    Fragment2Presenter(@NonNull Fragment2Contract.View view, @NonNull MainActivityRouter router) {
        super(view, router);
    }

    @Override
    public void next() {
        router.goNext();
    }
}
