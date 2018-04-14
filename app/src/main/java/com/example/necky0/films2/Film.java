package com.example.necky0.films2;

import java.util.ArrayList;

public class Film {
    private String title;
    private int mainPicture;
    private ArrayList<Integer> pictures;
    private ArrayList<Actor> actors;
    private String category;

    public Film(String title, int mainPicture, String category, ArrayList<Integer> pictures,
                ArrayList<Actor> actors) {
        this.title = title;
        this.mainPicture = mainPicture;
        this.category = category;
        this.pictures = pictures;
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public int getMainPicture() {
        return mainPicture;
    }

    public ArrayList<Integer> getPictures() {
        return pictures;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }
}