/**
 * (C) 2016. Darren Kong [All rights reserved]. This product and related documentation are protected by
 * copyright restricting its use, copying, distribution, and decompilation. No part of this product or related
 * documentation may be reproduced in any form by any means without prior written authorization of Darren Kong
 * . Unless otherwise arranged, third parties may not have access to this product or related documents.
 */

package au.com.darrenkong.earthquakes.presenters;

import android.content.Context;
import android.os.Bundle;

import javax.inject.Inject;

import au.com.darrenkong.earthquakes.activities.BaseUi;
import au.com.darrenkong.earthquakes.adapter.EarthquakesAdapter;
import au.com.darrenkong.earthquakes.model.Earthquakes;
import au.com.darrenkong.earthquakes.model.Earthquakes.Earthquake;
import au.com.darrenkong.earthquakes.network.EarthquakeService;
import au.com.darrenkong.earthquakes.presenters.EarthquakesPresenter.EarthquakesUi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by dkong on 31/10/2016.
 */
public class EarthquakesPresenter
        extends BasePresenter<EarthquakesUi> {

    @Inject
    EarthquakeService mEarthquakeService;

    @Inject
    EarthquakesUi mUi;

    @Inject
    EarthquakesPresenter() {}

    @Override
    public void onCreate(Bundle args) {
        super.onCreate(args);

        //make an api call to get the list of earthquakes
        makeEarthquakeListRequest();
    }

    private void makeEarthquakeListRequest() {

        // TODO: 1/11/2016 implement a progress dialog  
        getUi().showLoadingState();

        // Hardcoded api parameters for this example. The values should be optained from a use input via a ui filter
        // input son screen
        Call<Earthquakes> earthquakes = mEarthquakeService.getEarthquakesWithParameters(3, 100);
        earthquakes.enqueue(new Callback<Earthquakes>() {
            @Override
            public void onResponse(Call<Earthquakes> call, Response<Earthquakes> response) {
                Earthquakes earthquakes = response.body();
                getUi().showItems(earthquakes.earthquakes);

                // TODO: 1/11/2016 hide progress dialog
                getUi().hideLoadingState();
            }

            @Override
            public void onFailure(Call<Earthquakes> call, Throwable t) {
                Timber.e("Error retrieving data");

                // TODO: 1/11/2016 hide progress dialog
                getUi().hideLoadingState();

                // TODO: 1/11/2016 show an error dialog or snackbar to notify user of failure and show an empty list
                // state in the recyclerview
                getUi().showError();
            }
        });
    }

    // TODO: 1/11/2016 implement an empty list view when there are no items to display
    public EarthquakesAdapter getAdapter(Context context) {
        return new EarthquakesAdapter(context);
    }

    public interface EarthquakesUi
            extends BaseUi {

        void showItems(Earthquake[] items);
    }
}
