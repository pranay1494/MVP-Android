package com.example.pranaybansal.androidmvp.ui.screen_contracts;

import com.example.pranaybansal.androidmvp.model.pojo.Posts;

import java.util.List;

/**
 * Created by Pranay Bansal on 9/25/2017.
 */

public interface PostsView {
    void postsFetched(boolean isErrorFound, Posts posts);
    void dismissDialog();
    void showDialog();
}
