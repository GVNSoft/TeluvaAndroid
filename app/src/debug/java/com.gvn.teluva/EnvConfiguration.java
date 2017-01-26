package com.gvn.teluva;

import android.app.Application;
/**
 * Created by kj060 on 2017-01-27.
 */
import android.os.StrictMode;

import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;


public class EnvConfiguration {
    public static void initialize(Application application) {
        if (LeakCanary.isInAnalyzerProcess(application)) {
            return;
        }
        LeakCanary.install(application);

        Stetho.initializeWithDefaults(application);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build();
        StrictMode.setThreadPolicy(policy);
    }
}
