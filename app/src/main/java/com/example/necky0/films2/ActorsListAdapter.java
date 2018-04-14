package com.example.necky0.films2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ActorsListAdapter extends RecyclerView.Adapter<ActorsListAdapter.ViewHolder> {
    private ArrayList<Actor> dataset;

    static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView primary_text;
        private TextView secondary_text;
        private ImageView picture;

        ViewHolder(View v) {
            super(v);
            primary_text = v.findViewById(R.id.primary_text);
            secondary_text = v.findViewById(R.id.secondary_text);
            picture = v.findViewById(R.id.picture);
        }
    }

    public ActorsListAdapter(ArrayList<Actor> dataset) {
        this.dataset = dataset;
    }

    @Override
    public ActorsListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task, parent,
                false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Actor actor = dataset.get(position);
        holder.primary_text.setText(actor.getName());
        holder.secondary_text.setText(actor.getMovieName());
        holder.picture.setImageResource(actor.getPicture());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}