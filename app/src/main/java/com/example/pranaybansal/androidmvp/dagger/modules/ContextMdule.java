package com.example.pranaybansal.androidmvp.dagger.modules;

import android.app.Activity;
import android.content.Context;


import com.example.pranaybansal.androidmvp.dagger.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Pranay Bansal on 7/9/2017.
 */
@Module
public class ContextMdule {
    Context context;

    public ContextMdule(Activity activity) {
        context = activity;
    }

    @Provides
    @ActivityScope
    public Context activityContext() {
        return context;
    }
}
