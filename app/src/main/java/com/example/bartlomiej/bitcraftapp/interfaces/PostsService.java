package com.example.bartlomiej.bitcraftapp.interfaces;

import com.example.bartlomiej.bitcraftapp.model.Post;

import java.util.List;

import retrofit.http.GET;
import rx.Observable;

public interface PostsService {

    String SERVICE_ENDPOINT = "https://jsonplaceholder.typicode.com";

    @GET("/posts")
    Observable<List<Post>> getPosts();
}
