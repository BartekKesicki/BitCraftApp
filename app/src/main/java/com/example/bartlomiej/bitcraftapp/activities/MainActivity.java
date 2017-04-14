package com.example.bartlomiej.bitcraftapp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.bartlomiej.bitcraftapp.R;
import com.example.bartlomiej.bitcraftapp.adapters.RecyclerViewAdapter;
import com.example.bartlomiej.bitcraftapp.interfaces.OnResponse;
import com.example.bartlomiej.bitcraftapp.model.Post;
import com.example.bartlomiej.bitcraftapp.services.PostsLoader;

import java.util.List;

public class MainActivity extends Activity implements OnResponse {

    private RecyclerView recyclerView;

    private ProgressBar progressBar;

    private TextView errorTextView;

    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeUI();
        loadData();
    }

    private void initializeUI() {
        recyclerView = (RecyclerView) findViewById(R.id.postsListView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        errorTextView = (TextView) findViewById(R.id.final_error_message_text_view);
    }

    private void loadData() {
        PostsLoader postsLoader = new PostsLoader();
        recyclerView.setVisibility(View.GONE);
        errorTextView.setVisibility(View.GONE);
        postsLoader.loadPosts(this, this);
    }

    @Override
    public void onPostsReceived(List<Post> posts) {
        progressBar.setVisibility(View.GONE);
        errorTextView.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);

        loadDataOnRecyclerView(posts);
    }

    private void loadDataOnRecyclerView(List<Post> posts) {
        recyclerViewAdapter = new RecyclerViewAdapter(posts);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onFailure() {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);
        errorTextView.setVisibility(View.VISIBLE);
    }
}
