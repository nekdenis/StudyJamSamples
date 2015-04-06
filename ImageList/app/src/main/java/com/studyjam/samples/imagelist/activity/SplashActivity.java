package com.studyjam.samples.imagelist.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import com.studyjam.samples.imagelist.R;

public class SplashActivity extends Activity {

    private static final long START_DELAY = 2l * 1000;
    private Handler handler;
    private Runnable startRunnable = new Runnable() {
        @Override
        public void run() {
            PersonsActivity.startActivityAsTop(SplashActivity.this);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler = new Handler();
    }

    @Override
    protected void onStart() {
        super.onStart();
        handler.postDelayed(startRunnable, START_DELAY);
    }

    @Override
    protected void onStop() {
        handler.removeCallbacks(startRunnable);
        super.onStop();
    }
}
