package com.example.pranaybansal.androidmvp.dagger.component;

import com.example.pranaybansal.androidmvp.dagger.modules.ApiModule;
import com.example.pranaybansal.androidmvp.dagger.modules.ContextMdule;
import com.example.pranaybansal.androidmvp.dagger.modules.ImageLoaderModule;
import com.example.pranaybansal.androidmvp.dagger.modules.NetworkModules;
import com.example.pranaybansal.androidmvp.dagger.scope.ActivityScope;
import com.example.pranaybansal.androidmvp.ui.activities.MainActivity;
import com.example.pranaybansal.androidmvp.ui.activities.PostsActivity;

import dagger.Component;

/**
 * Created by Pranay Bansal on 9/25/2017.
 */
@Component(modules = {ApiModule.class,NetworkModules.class, ContextMdule.class, ImageLoaderModule.class})
@ActivityScope
public interface ActivityComponent {
    void inject(PostsActivity postsActivity);
    void inject(MainActivity mainActivity);
}
