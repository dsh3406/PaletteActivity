package com.example.paletteactivity;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class PaletteActivity extends AppCompatActivity implements PaletteFragment.ColorFragmentInterface{
    CanvasFragment canvasFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Palette Activity");

        PaletteFragment paletteFragment = new PaletteFragment();
        canvasFragment = new CanvasFragment();
        addFragment(paletteFragment, R.id.container_1);
        addFragment(canvasFragment, R.id.container_2);
    }

    public void addFragment(Fragment fragment, int id){
        getSupportFragmentManager()
                .beginTransaction()
                .add(id, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void colorSelected(String color) {
        Bundle bundle = new Bundle();
        bundle.putString("color", color);
        canvasFragment.setArguments(bundle);
        canvasFragment.changeColor();
    }
}
