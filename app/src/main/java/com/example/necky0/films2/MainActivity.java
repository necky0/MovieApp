package com.example.necky0.films2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private FilmsListAdapter mFilmsListAdapter;
    private ArrayList<Film> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTasks();
        initUI();
        initRecyclerView();
        initRecyclerViewAdapter();
        initSwipe();
    }

    public void initTasks() {
        data = new ArrayList<>();
        ArrayList<Actor> actors1 = new ArrayList<>();
        ArrayList<Actor> actors2 = new ArrayList<>();

        Actor downey = new Actor("Robert Downey","Iron Man", R.drawable.downey);
        Actor evans = new Actor("Chris Evans", "Kapitan Ameryka", R.drawable.evans);
        Actor cumberbatch = new Actor("Benedict Cumberbatch","Dr Strange", R.drawable.cumberbatch);
        Actor johansson = new Actor("Scarlett Johansson", "Czarna Wdowa", R.drawable.johansson);
        Actor hemsworth = new Actor("Chris Hemsworth", "Thor", R.drawable.hemsworth);
        Actor ruffalo = new Actor("Mark Ruffalo", "Hulk", R.drawable.ruffalo);
        Actor rudd = new Actor("Paul Rudd", "Ant-Man", R.drawable.rudd);
        Actor stan = new Actor("Sebastian Stan", "Zimowy Żołnierz", R.drawable.stan);
        Actor olsen = new Actor("Elizabeth Olsen", "Scarlet Witch", R.drawable.olsen);
        Actor renner = new Actor("Jeremy Renner", "Sokole Oko", R.drawable.renner);

        actors1.add(downey);
        actors1.add(cumberbatch);
        actors1.add(johansson);

        actors2.add(downey);
        actors2.add(evans);
        actors2.add(cumberbatch);
        actors2.add(johansson);
        actors2.add(hemsworth);
        actors2.add(ruffalo);
        actors2.add(rudd);
        actors2.add(stan);
        actors2.add(olsen);
        actors2.add(renner);


        ArrayList<Integer> pictures = new ArrayList<>();
        pictures.add(R.drawable.p1);
        pictures.add(R.drawable.p2);
        pictures.add(R.drawable.p3);
        pictures.add(R.drawable.p4);
        pictures.add(R.drawable.p5);
        pictures.add(R.drawable.p6);
        pictures.add(R.drawable.p7);
        pictures.add(R.drawable.p8);

        data.add(new Film("Spider-man", R.drawable.p1, "Science fiction", pictures, actors1));
        data.add(new Film("Ironman", R.drawable.p2, "Science fiction", pictures, actors2));
        data.add(new Film("Captain America", R.drawable.p3, "Science fiction", pictures, actors2));
        data.add(new Film("Thor", R.drawable.p4, "Science fiction", pictures, actors1));
        data.add(new Film("Dr. Strange", R.drawable.p5, "Science fiction", pictures, actors1));
        data.add(new Film("Avengers", R.drawable.p6, "Science fiction", pictures, actors2));
        data.add(new Film("Avengers: Age of Ultron", R.drawable.p7, "Science fiction", pictures, actors2));
        data.add(new Film("Avengers: Infinity war", R.drawable.p8, "Science fiction", pictures, actors2));
    }

    public void initUI() {
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
    }

    public void initRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void initRecyclerViewAdapter() {
        mFilmsListAdapter = new FilmsListAdapter(this, data);
        mRecyclerView.setAdapter(mFilmsListAdapter);
    }

    private void initSwipe(){
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder holder, int direction) {
                int position = holder.getAdapterPosition();

                mFilmsListAdapter.deleteFromDataset(position);
                mFilmsListAdapter.notifyDataSetChanged();
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
    }
}
