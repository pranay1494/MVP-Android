package com.example.pranaybansal.androidmvp.ui.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.pranaybansal.androidmvp.R;
import com.example.pranaybansal.androidmvp.dagger.component.ActivityComponent;
import com.example.pranaybansal.androidmvp.dagger.component.DaggerActivityComponent;
import com.example.pranaybansal.androidmvp.dagger.modules.ApiModule;
import com.example.pranaybansal.androidmvp.dagger.modules.ContextMdule;
import com.example.pranaybansal.androidmvp.model.pojo.Posts;
import com.example.pranaybansal.androidmvp.ui.adapters.PostsAdapter;
import com.example.pranaybansal.androidmvp.ui.presenters.PostsPresenterImpl;
import com.example.pranaybansal.androidmvp.ui.screen_contracts.PostsView;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Pranay Bansal on 9/25/2017.
 */

public class PostsActivity extends AppCompatActivity implements PostsView{
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @Inject
    PostsPresenterImpl presenter;

    @BindView(R.id.rv_posts)
    RecyclerView rvPosts;

    private PostsAdapter postsAdapter;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        dialog = new ProgressDialog(this);

        ActivityComponent component = DaggerActivityComponent.builder()
                .contextMdule(new ContextMdule(this))
                .apiModule(new ApiModule(BASE_URL))
                .build();
        component.inject(this);
        presenter.setView(this);
        ButterKnife.bind(this);

        setupRecyclerView();
        //get data
        presenter.fetchPosts();
    }

    private void setupRecyclerView() {
        rvPosts.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        postsAdapter = new PostsAdapter(this,new ArrayList<Posts>());
        rvPosts.setAdapter(postsAdapter);
    }

    @Override
    public void postsFetched(boolean isErrorFound, Posts posts) {
        if (!isErrorFound && posts!=null){
            ArrayList<Posts> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add(posts);
            }
            postsAdapter = new PostsAdapter(this,list);
            rvPosts.setAdapter(postsAdapter);
            postsAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void dismissDialog() {
        dialog.dismiss();
    }

    @Override
    public void showDialog() {
        dialog.setMessage("Loading Please Wait..");
        dialog.show();
    }
}
