package com.wang.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class BigImageActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_image);
        imageView = (ImageView) findViewById(R.id.image);
        String path = getIntent().getStringExtra("path");

        if(!TextUtils.isEmpty(path)){
            Glide.with(this).load(path).into(imageView);
        }
    }
}
