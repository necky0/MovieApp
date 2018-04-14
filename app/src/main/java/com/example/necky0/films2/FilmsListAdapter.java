package com.example.necky0.films2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FilmsListAdapter extends RecyclerView.Adapter<FilmsListAdapter.ViewHolder> {
    private ArrayList<Film> dataset;
    private Context context;

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title;
        private TextView category;
        private ImageView avatar;
        private FilmsListAdapter filmsListAdapter;

        ViewHolder(View v, FilmsListAdapter filmsListAdapter) {
            super(v);
            v.setOnClickListener(this);
            this.filmsListAdapter = filmsListAdapter;
            title = v.findViewById(R.id.primary_text);
            category = v.findViewById(R.id.secondary_text);
            avatar = v.findViewById(R.id.picture);
        }

        @Override
        public void onClick(View v) {
            Film film = filmsListAdapter.getItem(getAdapterPosition());
            ArrayList<String> names = Actor.names(film.getActors());
            ArrayList<String> movie_names = Actor.movieNames(film.getActors());
            ArrayList<Integer> pictures = Actor.pictures(film.getActors());

            FilmDetailsActivity.start(filmsListAdapter.context, film.getTitle(), film.getCategory(), film.getMainPicture(),
                    names, movie_names, pictures, film.getPictures());
        }
    }

    public FilmsListAdapter(Context context, ArrayList<Film> dataset) {
        this.context = context;
        this.dataset = dataset;
    }

    @Override
    public FilmsListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task, parent,
                false);
        return new ViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Film film = dataset.get(position);
        holder.title.setText(film.getTitle());
        holder.category.setText(film.getCategory());
        holder.avatar.setImageResource(film.getMainPicture());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void deleteFromDataset(int index) {
        this.dataset.remove(index);
    }

    public Film getItem(int index) {
        return dataset.get(index);
    }
}