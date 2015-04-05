package com.studyjam.samples.imagelist;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

public class ImagesActivity extends Activity {

    private ListView imagesListView;
    private EditText queryEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
        initView();
    }

    private void initView() {
        imagesListView = (ListView) findViewById(R.id.images_list);
        queryEditText = (EditText) findViewById(R.id.images_query_edittext);
    }
}
