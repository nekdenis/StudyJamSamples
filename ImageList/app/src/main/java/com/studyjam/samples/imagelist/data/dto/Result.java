package com.studyjam.samples.imagelist.data.dto;

public class ImageResult {

    private ResponseData responseData;
    private class ResponseData{
        private List<ImageResponse> results
    }
    @SerializedName("GsearchResultClass")
    private String GsearchResultClass;
    @Expose
    private String width;
    @Expose
    private String height;
    @Expose
    private String imageId;
    @Expose
    private String tbWidth;
    @Expose
    private String tbHeight;
    @Expose
    private String unescapedUrl;
    @Expose
    private String url;
    @Expose
    private String visibleUrl;
    @Expose
    private String title;
    @Expose
    private String titleNoFormatting;
    @Expose
    private String originalContextUrl;
    @Expose
    private String content;
    @Expose
    private String contentNoFormatting;
    @Expose
    private String tbUrl;
}
