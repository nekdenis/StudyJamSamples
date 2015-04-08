package com.studyjam.samples.imagelist.api;

import com.studyjam.samples.imagelist.data.dto.ImageResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface Api {

    @GET("/search/images?v=1.0&rsz=8&")
    public void searchImages(
            @Query("q") String query,
            @Query("start") int start,
            Callback<ImageResponse> callback);

}
