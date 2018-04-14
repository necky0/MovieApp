package com.example.necky0.films2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;


public class GalleryGridAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Integer> pictures;

    public GalleryGridAdapter(Context context, ArrayList<Integer> pictures) {
        this.context = context;
        this.pictures = pictures;
    }

    @Override
    public int getCount() {
        return pictures.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView iV;
        if(view==null){
            iV = new ImageView(context);
            iV.setLayoutParams(new GridView.LayoutParams(300,300));

            iV.setScaleType(ImageView.ScaleType.CENTER_CROP);
            iV.setPadding(8,8,8,8);
        }
        else {
            iV = (ImageView)view;
        }
        iV.setImageResource(pictures.get(i));
        return iV;
    }
}
