package com.studyjam.samples.imagelist.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.studyjam.samples.imagelist.R;
import com.studyjam.samples.imagelist.adapter.ImagePreviewAdapter;
import com.studyjam.samples.imagelist.api.Api;
import com.studyjam.samples.imagelist.data.dto.ImageResponse;
import com.studyjam.samples.imagelist.data.dto.ImageResult;
import com.studyjam.samples.imagelist.util.Constants;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ImageSearchActivity extends Activity {

    private static final String EXTRA_STATE_DATA_ARRAY_LIST = "EXTRA_STATE_DATA_ARRAY_LIST";
    private static final String EXTRA_STATE_OFFSET = "EXTRA_STATE_OFFSET";
    private static final String EXTRA_STATE_QUERY = "EXTRA_STATE_QUERY";

    private GridView imagePreviewGridView;
    private EditText searchQueryEditText;
    private Button performSearchButton;
    private ImagePreviewAdapter imagePreviewAdapter;
    private ArrayList<ImageResult> imageResultList = new ArrayList<>();
    private int lastSearchOffset = 0;
    private Api api;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, ImageSearchActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_search);
        api = getApi();
        initView();
        initImagesGrid();
        initListeners();
        if (savedInstanceState != null) {
            restoreState(savedInstanceState);
        }
    }

    private void restoreState(Bundle savedInstanceState) {
        ArrayList<ImageResult> list = (ArrayList<ImageResult>) savedInstanceState.getSerializable(EXTRA_STATE_DATA_ARRAY_LIST);
        imageResultList.clear();
        imageResultList.addAll(list);
        imagePreviewAdapter.notifyDataSetChanged();
        lastSearchOffset = savedInstanceState.getInt(EXTRA_STATE_OFFSET);
        imagePreviewGridView.smoothScrollToPosition(imageResultList.size() - 1);
//        searchQueryEditText.setText(savedInstanceState.getString(EXTRA_STATE_QUERY));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(EXTRA_STATE_DATA_ARRAY_LIST, imageResultList);
        outState.putInt(EXTRA_STATE_OFFSET, lastSearchOffset);
//        outState.putString(EXTRA_STATE_QUERY, searchQueryEditText.getText().toString());
    }

    private void initView() {
        searchQueryEditText = (EditText) findViewById(R.id.image_search_query_edit_text);
        imagePreviewGridView = (GridView) findViewById(R.id.image_search_grid_view);
        performSearchButton = (Button) findViewById(R.id.image_search_perform_search_button);
    }

    private void initImagesGrid() {
        imagePreviewAdapter = new ImagePreviewAdapter(this, imageResultList);
        imagePreviewGridView.setAdapter(imagePreviewAdapter);
    }

    private void initListeners() {
        performSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performNewSearch();
            }
        });
        imagePreviewGridView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                final int lastItem = firstVisibleItem + visibleItemCount;
                if (lastItem > 0 && totalItemCount > 0) {
                    if (lastItem == imagePreviewAdapter.getCount()) {
                        performOffsetSearch(lastItem);
                    }
                }
            }
        });
    }

    private void performNewSearch() {
        String searchQuery = searchQueryEditText.getText().toString();
        imageResultList.clear();
        imagePreviewAdapter.notifyDataSetChanged();
        int start = 0;
        searchImages(searchQuery, start);
    }

    private void performOffsetSearch(int offset) {
        String searchQuery = searchQueryEditText.getText().toString();
        searchImages(searchQuery, offset);
    }

    private void searchImages(String searchQuery, int start) {
        api.searchImages(searchQuery, start, searchImageCallback);
    }

    private Api getApi() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Constants.API_PREFIX)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        return restAdapter.create(Api.class);
    }

    private Callback<ImageResponse> searchImageCallback = new Callback<ImageResponse>() {
        @Override
        public void success(ImageResponse imageResponse, Response response) {

            if (imageResponse.getImagesList() != null) {
                imageResultList.addAll(imageResponse.getImagesList());
                imagePreviewAdapter.notifyDataSetChanged();
            } else {
                showErrorMessage();
            }
        }

        @Override
        public void failure(RetrofitError error) {
            showErrorMessage();
        }
    };

    private void showErrorMessage() {
        Toast.makeText(this, R.string.search_error, Toast.LENGTH_SHORT).show();
    }
}
