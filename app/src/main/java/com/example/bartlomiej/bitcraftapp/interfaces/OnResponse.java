package com.example.bartlomiej.bitcraftapp.interfaces;

import com.example.bartlomiej.bitcraftapp.model.Post;

import java.util.List;

public interface OnResponse {
    void onPostsReceived(List<Post> posts);
    void onFailure();
}
