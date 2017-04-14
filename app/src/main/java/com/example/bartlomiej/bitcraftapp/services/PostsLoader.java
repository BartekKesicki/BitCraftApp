package com.example.bartlomiej.bitcraftapp.services;

import android.content.Context;
import android.widget.Toast;

import com.example.bartlomiej.bitcraftapp.R;
import com.example.bartlomiej.bitcraftapp.interfaces.OnResponse;
import com.example.bartlomiej.bitcraftapp.interfaces.PostsService;
import com.example.bartlomiej.bitcraftapp.model.Post;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PostsLoader {

    private PostsService postsService;

    public void loadPosts(final OnResponse onResponse, final Context context) {
        postsService = PostsServiceFactory.createRetrofitService(PostsService.class, PostsService.SERVICE_ENDPOINT);
        postsService.getPosts()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Post>>() {
                    @Override
                    public void onCompleted() { }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Toast.makeText(context, R.string.download_failure_message, Toast.LENGTH_SHORT).show();
                        onResponse.onFailure();
                    }

                    @Override
                    public void onNext(List<Post> posts) {
                        onResponse.onPostsReceived(posts);
                    }
                });
    }
}
