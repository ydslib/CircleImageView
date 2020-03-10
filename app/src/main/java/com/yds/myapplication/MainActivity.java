package com.yds.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.img);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.img);
        Drawable drawable = new CircleImageViewDrawable(bitmap);
        mImageView.setImageDrawable(drawable);
    }
}
