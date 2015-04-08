package com.studyjam.samples.imagelist.data.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ImageResponse {

    @SerializedName("responseData")
    private ResponseData responseData;

    private class ResponseData {
        @SerializedName("results")
        private List<ImageResult> results;
    }

    public List<ImageResult> getImagesList() {
        if (responseData != null) {
            return responseData.results;
        } else {
            return null;
        }
    }
}
