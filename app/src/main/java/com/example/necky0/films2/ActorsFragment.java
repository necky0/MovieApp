package com.example.necky0.films2;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class ActorsFragment extends Fragment {

    private static final String ACTORS_NAME = "ACTORS_NAME";
    private static final String ACTORS_MOVIE_NAME = "ACTORS_MOVIE_NAME";
    private static final String ACTORS_PICTURES = "ACTORS_PICTURES";

    private ArrayList<String> actors_names;
    private ArrayList<String> actors_movie_names;
    private ArrayList<Integer> actors_pictures;

    public ActorsFragment() {
        // empty
    }

    public static ActorsFragment newInstance(ArrayList<String> actors_names, ArrayList<String> actors_movie_names, ArrayList<Integer> actors_pictures) {
        ActorsFragment fragment = new ActorsFragment();
        Bundle args = new Bundle();
        args.putStringArrayList(ACTORS_NAME, actors_names);
        args.putStringArrayList(ACTORS_MOVIE_NAME, actors_movie_names);
        args.putIntegerArrayList(ACTORS_PICTURES, actors_pictures);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            actors_names = getArguments().getStringArrayList(ACTORS_NAME);
            actors_movie_names = getArguments().getStringArrayList(ACTORS_MOVIE_NAME);
            actors_pictures = getArguments().getIntegerArrayList(ACTORS_PICTURES);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_actors_list, container, false);

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;

            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            ActorsListAdapter mAdapter = new ActorsListAdapter(Actor.marge(actors_names, actors_movie_names, actors_pictures));
            recyclerView.setAdapter(mAdapter);
        }
        return view;
    }
}
