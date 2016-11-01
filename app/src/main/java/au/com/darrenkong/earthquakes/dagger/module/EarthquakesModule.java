/**
 * (C) 2016. Darren Kong [All rights reserved]. This product and related documentation are protected by
 * copyright restricting its use, copying, distribution, and decompilation. No part of this product or related
 * documentation may be reproduced in any form by any means without prior written authorization of Darren Kong
 * . Unless otherwise arranged, third parties may not have access to this product or related documents.
 */

package au.com.darrenkong.earthquakes.dagger.module;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import au.com.darrenkong.earthquakes.presenters.EarthquakesPresenter.EarthquakesUi;
import dagger.Module;
import dagger.Provides;

/**
 * Created by dkong on 31/10/2016.
 */
@Module
public class EarthquakesModule {

    private Context mContext;
    private EarthquakesUi mEarthquakesUi;

    public EarthquakesModule(EarthquakesUi earthquakesUi, Context context) {
        mEarthquakesUi = earthquakesUi;
        mContext = context;
    }

    @Provides
    public EarthquakesUi provideEarthquakesUi() {
        return mEarthquakesUi;
    }

    @Provides
    public RecyclerView.LayoutManager provideLayoutManager() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        return layoutManager;
    }
}
