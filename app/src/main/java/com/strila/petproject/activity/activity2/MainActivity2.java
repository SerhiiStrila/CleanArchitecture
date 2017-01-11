package com.strila.petproject.activity.activity2;

import android.os.Bundle;

import com.strila.petproject.R;
import com.strila.petproject.activity.activity1.MainActivityRouter;
import com.strila.petproject.base.BaseActivity;
import com.strila.petproject.di.activity.HasActivitySubComponentBuilders;

import javax.inject.Inject;

/**
 * Created by Serhii Strila on 1/11/17
 */

public class MainActivity2 extends BaseActivity {

    @Inject MainActivityRouter router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void setupActivityComponent(HasActivitySubComponentBuilders builders) {
        ((MainActivity2Component.Builder)builders.getActivityComponentBuilder(MainActivity2.class))
                .activityModule(new MainActivity2Component.MainActivity2Module(this))
                .build()
                .inject(this);
    }
}
