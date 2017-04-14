package com.example.bartlomiej.bitcraftapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bartlomiej.bitcraftapp.R;
import com.example.bartlomiej.bitcraftapp.model.Post;
import com.example.bartlomiej.bitcraftapp.view_holders.RecyclerViewsHolder;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewsHolder> {

    private List<Post> posts;

    public RecyclerViewAdapter(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public RecyclerViewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_item, null);
        RecyclerViewsHolder recyclerViewViewsHolder = new RecyclerViewsHolder(view);
        return recyclerViewViewsHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewsHolder holder, int position) {
        if (posts != null) {
            Post post = posts.get(position);

            holder.getIdTextView().setText(post.getId());
            holder.getUserIdTextView().setText(post.getUserId());
            holder.getTitleTextView().setText(post.getTitle());
            holder.getBodyTextView().setText(post.getBody());
        }
    }

    @Override
    public int getItemCount() {
        return (posts != null ? posts.size() : 0);
    }
}
