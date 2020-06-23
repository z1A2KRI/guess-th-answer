package com.barmj.giftsuggetion;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String BUNDLE_CURRENT_INDEX = "BUNDLE_CURRENT_INDEX";
    int[] mGiftPictures = {
            R.drawable.football,
            R.drawable.park,
            R.drawable.walking,
            R.drawable.place
    };
    int mCurrentIndex = -1;
    ImageView giftImageView;
    private Random mRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        giftImageView = findViewById(R.id.image_gift);
        Drawable giftDrawable = ContextCompat.getDrawable(this, R.drawable.football);
        giftImageView.setImageDrawable(giftDrawable);
        mRandom = new Random();
    }

    public void display(View view) {
        Log.d(TAG, "display =" + mCurrentIndex);
        mCurrentIndex = mRandom.nextInt(mGiftPictures.length);
        showImage();
    }

    private void showImage() {
        Drawable giftDrawable = ContextCompat.getDrawable(this, mGiftPictures[mCurrentIndex]);
        giftImageView.setImageDrawable(giftDrawable);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(BUNDLE_CURRENT_INDEX, mCurrentIndex);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCurrentIndex = savedInstanceState.getInt(BUNDLE_CURRENT_INDEX);
        if (mCurrentIndex != -1) {
            Log.d(TAG, "display =" + mCurrentIndex);
            showImage();
        }
        Log.i(TAG, "onRestoreInstanceState");
    }

}








