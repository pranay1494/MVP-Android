package com.example.pranaybansal.androidmvp.ui.presenters;

import com.example.pranaybansal.androidmvp.model.ApiCalls;
import com.example.pranaybansal.androidmvp.model.pojo.Posts;
import com.example.pranaybansal.androidmvp.ui.activities.PostsActivity;
import com.example.pranaybansal.androidmvp.ui.screen_contracts.PostsPresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Pranay Bansal on 9/25/2017.
 */

public class PostsPresenterImpl implements PostsPresenter{

    ApiCalls hitApi;

    @Nullable
    private PostsActivity view;

    @Inject
    public PostsPresenterImpl(ApiCalls hitApi) {
        this.hitApi = hitApi;
    }

    public void setView(PostsActivity view){
        this.view = view;
    }
    @Override
    public void fetchPosts() {
        view.showDialog();
        hitApi.getPosts()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Posts>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Posts postses) {
                        if (view!=null) {
                            view.dismissDialog();
                            view.postsFetched(false, postses);
                        }
                    }
                    @Override
                    public void onError(@NonNull Throwable e) {
                        if (view!=null) {
                            view.dismissDialog();
                            view.postsFetched(true, null);
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
