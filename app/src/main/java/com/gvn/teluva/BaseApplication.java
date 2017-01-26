package com.gvn.teluva;

import android.app.Application;

/**
 * Created by kj060 on 2017-01-27.
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        EnvConfiguration.initialize(this);
    }
}
