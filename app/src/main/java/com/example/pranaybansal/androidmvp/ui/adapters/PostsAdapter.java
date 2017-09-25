package com.example.pranaybansal.androidmvp.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pranaybansal.androidmvp.R;
import com.example.pranaybansal.androidmvp.model.pojo.Posts;

import java.util.ArrayList;

/**
 * Created by Pranay Bansal on 9/25/2017.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsVH> {

    private Context context;
    private ArrayList<Posts> posts;
    public PostsAdapter(Context context, ArrayList<Posts> posts) {
        this.context = context;
        this.posts = posts;
    }

    @Override
    public PostsVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PostsVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_posts,parent,false));
    }

    @Override
    public void onBindViewHolder(PostsVH holder, int position) {
        String title = posts.get(position).getTitle();
        String body = posts.get(position).getTitle();
        holder.tvPost.setText(TextUtils.isEmpty(title)?"":title);
        holder.tvPostBody.setText(TextUtils.isEmpty(body)?"":body);
    }

    @Override
    public int getItemCount() {
        return (posts!=null)?posts.size():0;
    }

    public class PostsVH extends RecyclerView.ViewHolder{
        TextView tvPost;
        TextView tvPostBody;
        public PostsVH(View itemView) {
            super(itemView);
            tvPost = (TextView) itemView.findViewById(R.id.tvPost);
            tvPostBody = (TextView) itemView.findViewById(R.id.tvPostBody);
        }
    }
}
