/**
 * (C) 2016. Darren Kong [All rights reserved]. This product and related documentation are protected by
 * copyright restricting its use, copying, distribution, and decompilation. No part of this product or related
 * documentation may be reproduced in any form by any means without prior written authorization of Darren Kong
 * . Unless otherwise arranged, third parties may not have access to this product or related documents.
 */

package au.com.darrenkong.earthquakes.dagger.component;

import android.app.Application;

import javax.inject.Singleton;

import au.com.darrenkong.earthquakes.dagger.module.AppModule;
import au.com.darrenkong.earthquakes.network.EarthquakeService;
import dagger.Component;

/**
 * Created by dkong on 1/11/2016.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(Application application);

    EarthquakeService getEarthquakeService();
}
