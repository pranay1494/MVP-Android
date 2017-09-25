package com.example.pranaybansal.androidmvp.dagger.modules;

import android.util.Log;

import com.example.pranaybansal.androidmvp.dagger.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Pranay Bansal on 7/8/2017.
 */
@Module
public class NetworkModules {
    @Provides
    @ActivityScope
    public HttpLoggingInterceptor loggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("dagger2", "log: "+message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    @ActivityScope
    public OkHttpClient okHttpClient(HttpLoggingInterceptor interceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
    }
}
