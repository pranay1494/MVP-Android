package com.example.pranaybansal.androidmvp.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.pranaybansal.androidmvp.R;
import com.example.pranaybansal.androidmvp.dagger.component.DaggerActivityComponent;
import com.example.pranaybansal.androidmvp.dagger.component.ActivityComponent;
import com.example.pranaybansal.androidmvp.dagger.modules.ApiModule;
import com.example.pranaybansal.androidmvp.dagger.modules.ContextMdule;
import com.example.pranaybansal.androidmvp.ui.presenters.MainActivityPresenter;
import com.example.pranaybansal.androidmvp.ui.screen_contracts.MainActivityViewContract;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainActivityViewContract{

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    @Inject
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityComponent component = DaggerActivityComponent.builder()
                .contextMdule(new ContextMdule(this))
                .apiModule(new ApiModule(BASE_URL))
                .build();
        component.inject(this);

        ButterKnife.bind(this);
        presenter.setView(this);
    }

    @OnClick(R.id.btn_click)
    public void btnClicked(){
        Toast.makeText(this, "btn Clicked", Toast.LENGTH_SHORT).show();
        presenter.btClicked();
    }

    @Override
    public void showPosts() {
        Intent intent = new Intent(this,PostsActivity.class);
        startActivity(intent);
    }
}
