package com.example.paletteactivity;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class PaletteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Palette Activity");
        final Spinner spinner = findViewById(R.id.spinner);
        Resources res = getResources();
        String[] color = res.getStringArray(R.array.color_array);
        final String[] colorBackground = res.getStringArray(R.array.color_array_background);
        spinner.setAdapter(new CustomAdapter(this, color, colorBackground));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PaletteActivity.this, CanvasActivity.class);
                if(!parent.getItemAtPosition(position).toString().equals(" ")) { //only go to second activity if selected string is color.
                    intent.putExtra("color", colorBackground[position]);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
