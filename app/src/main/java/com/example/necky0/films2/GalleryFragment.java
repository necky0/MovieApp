package com.example.necky0.films2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;


public class GalleryFragment extends Fragment {

    private static final String GALLERY = "GALLERY";

    private ArrayList<Integer> gallery;

    public GalleryFragment() {
        // Required empty public constructor
    }

    public static GalleryFragment newInstance(ArrayList<Integer> gallery) {
        GalleryFragment fragment = new GalleryFragment();
        Bundle args = new Bundle();
        args.putIntegerArrayList(GALLERY, gallery);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            gallery = getArguments().getIntegerArrayList(GALLERY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gallery_grid, container, false);

        GalleryGridAdapter galleryGridAdapter = new GalleryGridAdapter(view.getContext(), gallery);
        GridView pictures_grid = view.findViewById(R.id.gallery_grid);
        pictures_grid.setAdapter(galleryGridAdapter);

        return view;
    }
}
