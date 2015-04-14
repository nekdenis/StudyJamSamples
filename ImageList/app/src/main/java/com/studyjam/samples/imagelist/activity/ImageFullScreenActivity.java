package com.studyjam.samples.imagelist.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.studyjam.samples.imagelist.R;
import com.studyjam.samples.imagelist.util.Constants;

import uk.co.senab.photoview.PhotoView;

public class ImageFullScreenActivity extends Activity {

    private PhotoView photoView;

    public static void startActivity(Context context, String imageUrl) {
        Intent i = new Intent(context, ImageFullScreenActivity.class);
        i.putExtra(Constants.EXTRA_IMAGE_URL, imageUrl);
        context.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_fullsreen);
        initView();
        setImage();
    }

    private void setImage() {
        String imageUrl = getIntent().getStringExtra(Constants.EXTRA_IMAGE_URL);
        ImageLoader.getInstance().displayImage(imageUrl, photoView);
    }

    private void initView() {
        photoView = (PhotoView) findViewById(R.id.image_fullscreen_view);
    }

}
