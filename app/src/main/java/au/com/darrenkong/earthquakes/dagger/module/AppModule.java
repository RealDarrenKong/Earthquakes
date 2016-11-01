/**
 * (C) 2016. Darren Kong [All rights reserved]. This product and related documentation are protected by
 * copyright restricting its use, copying, distribution, and decompilation. No part of this product or related
 * documentation may be reproduced in any form by any means without prior written authorization of Darren Kong
 * . Unless otherwise arranged, third parties may not have access to this product or related documents.
 */

package au.com.darrenkong.earthquakes.dagger.module;

import android.app.Application;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import au.com.darrenkong.earthquakes.EarthquakesApplication;
import au.com.darrenkong.earthquakes.network.EarthquakeService;
import au.com.darrenkong.earthquakes.network.NetworkLogger;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dkong on 1/11/2016.
 */
@Module
public class AppModule {

    Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    Cache provideOkHttpCache(Application application) {
        Cache cache = new Cache(application.getCacheDir(), EarthquakesApplication.CACHE_SIZE);
        return cache;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache) {
        OkHttpClient client = new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(
                        new HttpLoggingInterceptor(new NetworkLogger()).setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        return client;
    }

    @Provides
    @Singleton
    EarthquakeService provideEarthquakeService(Gson gson, OkHttpClient okHttpClient) {
        EarthquakeService earthquakeService = new Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(EarthquakesApplication.BASE_URL)
                .client(okHttpClient)
                .build().create(EarthquakeService.class);
        return earthquakeService;
    }
}
