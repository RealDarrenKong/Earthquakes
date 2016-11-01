/**
 * (C) 2016. Darren Kong [All rights reserved]. This product and related documentation are protected by
 * copyright restricting its use, copying, distribution, and decompilation. No part of this product or related
 * documentation may be reproduced in any form by any means without prior written authorization of Darren Kong
 * . Unless otherwise arranged, third parties may not have access to this product or related documents.
 */

package au.com.darrenkong.earthquakes;

import android.app.Application;

import au.com.darrenkong.earthquakes.dagger.component.AppComponent;
import au.com.darrenkong.earthquakes.dagger.component.DaggerAppComponent;
import au.com.darrenkong.earthquakes.dagger.module.AppModule;
import timber.log.Timber;

/**
 * Created by dkong on 1/11/2016.
 */
public class EarthquakesApplication
        extends Application {

    public static final int CACHE_SIZE = (int) (Runtime.getRuntime().maxMemory() / 10);
    public static String BASE_URL = "http://www.seismi.org/";
    public static boolean DEBUG = true; //This would be moved to a debug variant or a config file in production
    protected static EarthquakesApplication sInstance;

    private AppComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;

        inject();

        if (DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    private void inject() {
        mApplicationComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
        mApplicationComponent.inject(this);
    }

    public static EarthquakesApplication getInstance() {
        return sInstance;
    }

    public AppComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
