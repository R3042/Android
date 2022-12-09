package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView judul, kategori, deskripsi;
        ImageView image;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        judul = findViewById(R.id.textView3);
        kategori = findViewById(R.id.textView4);
        image = findViewById(R.id.imageView2);
        deskripsi = findViewById(R.id.textView5);
        Intent intent = getIntent();
        String[] data = intent.getStringArrayExtra("datastring");
        judul.setText(data[0]);
        kategori.setText(data[1]);
        Glide.with(this)
                .load(data[2])
                .apply(RequestOptions.centerCropTransform())
                .into(image);
        deskripsi.setText(data[3]);
    }
}