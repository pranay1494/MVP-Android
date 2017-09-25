package com.example.pranaybansal.androidmvp.ui.presenters;

import com.example.pranaybansal.androidmvp.ui.activities.MainActivity;
import com.example.pranaybansal.androidmvp.ui.screen_contracts.MainActivityPresenterContract;

import javax.inject.Inject;

import io.reactivex.annotations.Nullable;

/**
 * Created by Pranay Bansal on 9/25/2017.
 */

public class MainActivityPresenter implements MainActivityPresenterContract {

    @Nullable
    MainActivity view;

    @Inject
    public MainActivityPresenter() {
    }

    public void setView(MainActivity view){
        this.view = view;
    }
    @Override
    public void btClicked() {
        if (view != null){
            view.showPosts();
        }
    }
}
