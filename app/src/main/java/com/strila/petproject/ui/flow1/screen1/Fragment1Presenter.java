package com.strila.petproject.ui.flow1.screen1;

import android.support.annotation.NonNull;

import com.strila.petproject.di.scope.FragmentScope;
import com.strila.petproject.ui.app.App;
import com.strila.petproject.ui.base.BasePresenter;
import com.strila.petproject.ui.flow1.MainActivityRouter;

import javax.inject.Inject;

/**
 * Created by Serhii Strila on 1/11/17
 */

@FragmentScope
public final class Fragment1Presenter extends BasePresenter<Fragment1Contract.View, MainActivityRouter>
        implements Fragment1Contract.Presenter {

    @Inject App mApp;

    @Inject
    Fragment1Presenter(@NonNull Fragment1Contract.View view,
            @NonNull MainActivityRouter router) {
        super(view, router);
    }

    @Override
    public void next() {
        router.goNext();
    }

    @Override
    public void doSomething() {
        view.showText();
    }
}
