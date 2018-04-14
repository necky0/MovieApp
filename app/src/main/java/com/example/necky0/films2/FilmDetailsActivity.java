package com.example.necky0.films2;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FilmDetailsActivity extends AppCompatActivity {
    final static String TITLE = "TITLE";
    final static String CATEGORY = "CATEGORY";
    final static String PICTURE = "PICTURE";
    final static String ACTORS_NAMES = "ACTORS_NAMES";
    final static String ACTORS_MOVIE_NAMES = "ACTORS_MOVIE_NAMES";
    final static String ACTORS_PICTURES = "ACTORS_PICTURES";
    final static String GALLERY = "GALLERY";

    TextView title_details;
    TextView category_details;
    ImageView picture_details;
    ViewPager viewPager;

    private String title;
    private String category;
    private int picture;
    private ArrayList<String> actors_names;
    private ArrayList<String> actors_movie_names;
    private ArrayList<Integer> actors_pictures;
    private ArrayList<Integer> gallery;

    private ArrayList<Fragment> fragments;
    FragmentsViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_details);

        init();
        initUI();
        initFragments();
        initViewPagerAdapter();
    }

    public static void start(Context context, String title, String category, int picture,
                             ArrayList<String> actors_names,
                             ArrayList<String> actors_movie_names,
                             ArrayList<Integer> actors_pictures,
                             ArrayList<Integer> gallery) {
        Intent starter = new Intent(context, FilmDetailsActivity.class);
        starter.putExtra(TITLE, title);
        starter.putExtra(CATEGORY, category);
        starter.putExtra(PICTURE, picture);
        starter.putExtra(ACTORS_NAMES, actors_names);
        starter.putExtra(ACTORS_MOVIE_NAMES, actors_movie_names);
        starter.putExtra(ACTORS_PICTURES, actors_pictures);
        starter.putExtra(GALLERY, gallery);
        context.startActivity(starter);
    }

    public void init() {
        Intent intent = getIntent();
        title = intent.getStringExtra(TITLE);
        category = intent.getStringExtra(CATEGORY);
        picture = intent.getIntExtra(PICTURE, 0);
        actors_names = intent.getStringArrayListExtra(ACTORS_NAMES);
        actors_movie_names = intent.getStringArrayListExtra(ACTORS_MOVIE_NAMES);
        actors_pictures = intent.getIntegerArrayListExtra(ACTORS_PICTURES);
        gallery = intent.getIntegerArrayListExtra(GALLERY);
    }

    public void initUI() {
        title_details = findViewById(R.id.title_details);
        category_details = findViewById(R.id.category_details);
        picture_details = findViewById(R.id.picture_details);
        viewPager = findViewById(R.id.viewPager);

        title_details.setText(title);
        category_details.setText(category);
        picture_details.setImageResource(picture);
    }

    public void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(GalleryFragment.newInstance(gallery));
        fragments.add(ActorsFragment.newInstance(actors_names, actors_movie_names, actors_pictures));
    }

    public void initViewPagerAdapter() {
        viewPagerAdapter = new FragmentsViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(viewPagerAdapter);
    }
}
