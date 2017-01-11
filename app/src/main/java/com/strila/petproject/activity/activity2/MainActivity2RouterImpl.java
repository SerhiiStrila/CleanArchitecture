package com.strila.petproject.activity.activity2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;

import com.strila.petproject.R;
import com.strila.petproject.activity.activity1.MainActivity;
import com.strila.petproject.activity.activity1.MainActivityRouter;
import com.strila.petproject.fragment.fragment2.Fragment2;

/**
 * Created by Serhii Strila on 1/12/17
 */

public final class MainActivity2RouterImpl implements MainActivityRouter {

    private MainActivity2 mActivity;

    public MainActivity2RouterImpl(MainActivity2 activity) {
        mActivity = activity;
        baseInit();
    }

    @Override
    public void goNext() {
        mActivity.startActivity(new Intent(mActivity, MainActivity.class));
    }

    private void baseInit() {
        FragmentManager fm = mActivity.getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.addToBackStack(Fragment2.class.getName());
        ft.replace(R.id.container, Fragment2.newInstance(), Fragment2.class.getName());
        ft.commit();
    }
}
