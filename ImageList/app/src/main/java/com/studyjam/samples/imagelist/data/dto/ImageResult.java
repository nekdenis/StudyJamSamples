package com.studyjam.samples.imagelist.data.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ImageResult implements Serializable {

    @SerializedName("GsearchResultClass")
    private String gsearchResultClass;

    @SerializedName("width")
    private int width;

    @SerializedName("")
    private int height;

    @SerializedName("imageId")
    private String imageId;

    @SerializedName("tbWidth")
    private int tbWidth;

    @SerializedName("tbHeight")
    private int tbHeight;

    @SerializedName("unescapedUrl")
    private String unescapedUrl;

    @SerializedName("url")
    private String url;

    @SerializedName("visibleUrl")
    private String visibleUrl;

    @SerializedName("title")
    private String title;

    @SerializedName("titleNoFormatting")
    private String titleNoFormatting;

    @SerializedName("originalContextUrl")
    private String originalContextUrl;

    @SerializedName("content")
    private String content;

    @SerializedName("contentNoFormatting")
    private String contentNoFormatting;

    @SerializedName("tbUrl")
    private String tbUrl;

    public String getContent() {
        return content;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnailUrl() {
        return tbUrl;
    }
}