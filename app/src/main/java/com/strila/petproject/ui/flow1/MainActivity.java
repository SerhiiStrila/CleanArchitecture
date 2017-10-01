package com.strila.petproject.ui.flow1;

import android.os.Bundle;

import com.strila.petproject.R;
import com.strila.petproject.ui.base.BaseFragmentActivity;

import javax.inject.Inject;

/**
 * Created by Serhii Strila on 1/11/17
 */

public class MainActivity extends BaseFragmentActivity {

    @Inject MainActivityRouter router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) router.init();
    }

}