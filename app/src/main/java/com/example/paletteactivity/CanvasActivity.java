package com.example.paletteactivity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;

public class CanvasActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        setTitle("Canvas Activity");
        ConstraintLayout layout = findViewById(R.id.layout);
        String color = getIntent().getStringExtra("color");
        layout.setBackgroundColor(Color.parseColor(color));
    }
}
