package com.strila.petproject.di.base.app;

import android.app.Application;

/**
 * Created by Serhii Strila on 1/11/17
 */

public interface ApplicationComponent<A extends Application> {

    void inject(A application);
}
