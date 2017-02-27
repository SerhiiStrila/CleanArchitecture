package com.strila.petproject.ui.flow1;

import com.strila.petproject.di.base.activity.ActivityScope;
import com.strila.petproject.ui.flow1.screen1.Fragment1;
import com.strila.petproject.ui.flow1.screen2.Fragment2;
import com.strila.petproject.utils.ActivityUtils;

import javax.inject.Inject;

/**
 * Created by Serhii Strila on 1/12/17
 */

@ActivityScope
final class MainActivityRouterImpl implements MainActivityRouter {

    private MainActivity mActivity;

    @Inject
    MainActivityRouterImpl(MainActivity activity) {
        mActivity = activity;
        baseInit();
    }


    @Override
    public void goNext() {
        ActivityUtils.replaceFragmentInActivity(mActivity.getFragmentManager(), Fragment2.newInstance(), true);
    }

    private void baseInit() {
        ActivityUtils.replaceFragmentInActivity(mActivity.getFragmentManager(), Fragment1.newInstance(), false);
    }
}
