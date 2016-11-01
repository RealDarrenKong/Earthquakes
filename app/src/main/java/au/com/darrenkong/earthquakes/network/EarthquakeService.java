/**
 * (C) 2016. Darren Kong [All rights reserved]. This product and related documentation are protected by
 * copyright restricting its use, copying, distribution, and decompilation. No part of this product or related
 * documentation may be reproduced in any form by any means without prior written authorization of Darren Kong
 * . Unless otherwise arranged, third parties may not have access to this product or related documents.
 */

package au.com.darrenkong.earthquakes.network;

import au.com.darrenkong.earthquakes.model.Earthquakes;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dkong on 1/11/2016.
 */
public interface EarthquakeService {

    @GET("/api/eqs")
    Call<Earthquakes> getEarthquakes();

    @GET("/api/eqs")
    Call<Earthquakes> getEarthquakesWithParameters(@Query("min_magnitude") int minMagnitude, @Query("limit") int max);

    // TODO: 1/11/2016 add more api support for GET /eqs/:year, GET /eqs/:year/:month and GET /totals
}
