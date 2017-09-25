package com.example.pranaybansal.androidmvp.model;

import com.example.pranaybansal.androidmvp.model.pojo.Posts;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Pranay Bansal on 6/29/2017.
 */

public interface ApiCalls {
    @GET("posts/1")
    Observable<Posts> getPosts();
}
