/**
 * (C) 2016. Darren Kong [All rights reserved]. This product and related documentation are protected by
 * copyright restricting its use, copying, distribution, and decompilation. No part of this product or related
 * documentation may be reproduced in any form by any means without prior written authorization of Darren Kong
 * . Unless otherwise arranged, third parties may not have access to this product or related documents.
 */

package au.com.darrenkong.earthquakes.dagger.component;

import au.com.darrenkong.earthquakes.activities.EarthquakesActivity;
import au.com.darrenkong.earthquakes.dagger.module.EarthquakesModule;
import au.com.darrenkong.earthquakes.dagger.scope.PerActivity;
import dagger.Component;

/**
 * Created by dkong on 31/10/2016.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = EarthquakesModule.class)
public interface EarthquakesComponent {
    void inject(EarthquakesActivity activity);
}
