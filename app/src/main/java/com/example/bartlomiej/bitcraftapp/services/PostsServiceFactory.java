package com.example.bartlomiej.bitcraftapp.services;


import retrofit.RestAdapter;

public class PostsServiceFactory {

    public static <T> T createRetrofitService(final Class<T> serviceClass, final String endPoint) {
        final RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(endPoint)
                .build();
        T service = restAdapter.create(serviceClass);
        return service;
    }
}
