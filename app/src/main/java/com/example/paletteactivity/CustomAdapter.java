package com.example.paletteactivity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context context;
    //String[] color = new String[]{" ", "red", "yellow", "green", "blue", "gray"}; //added a blank string because I didn't like that main activity switches to second activity when application starts.
    String[] color; String[] colorBackground;

    public CustomAdapter(Context context, String[] color, String[] colorBackground){
        this.context = context;
        this.color = color;
        this.colorBackground = colorBackground;
    }

    @Override
    public int getCount() {
        return color.length;
    }

    @Override
    public Object getItem(int position) {
        return color[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final TextView textView = new TextView(context);
        textView.findViewById(R.id.spinner);
        textView.setText(getItem(position).toString());
        if(!getItem(position).toString().equals(" ")){
            textView.setBackgroundColor(Color.parseColor(colorBackground[position]));
        }
        return textView;
    }
}
