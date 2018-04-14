package com.example.necky0.films2;


import java.util.ArrayList;

public class Actor {
    private String name;
    private String movieName;
    private int picture;

    Actor(String name, String movieName, int picture){
        this.name = name;
        this.movieName = movieName;
        this.picture = picture;
    }

    public static ArrayList<String> names(ArrayList<Actor> actors) {
        ArrayList<String> names = new ArrayList<>();
        for(Actor a: actors) {
            names.add(a.name);
        }

        return names;
    }

    public static ArrayList<String> movieNames(ArrayList<Actor> actors) {
        ArrayList<String> movieNames = new ArrayList<>();
        for(Actor a: actors) {
            movieNames.add(a.movieName);
        }

        return movieNames;
    }

    public static ArrayList<Integer> pictures(ArrayList<Actor> actors) {
        ArrayList<Integer> pictures = new ArrayList<>();
        for(Actor a: actors) {
            pictures.add(a.picture);
        }

        return pictures;
    }

    public static ArrayList<Actor> marge(ArrayList<String> names, ArrayList<String> movieNames, ArrayList<Integer> pictures) {
        if (names.size() != pictures.size() && movieNames.size() != pictures.size()) return null;

        ArrayList<Actor> actors = new ArrayList<>();
        for(int i=0; i<names.size(); i++) {
            actors.add(new Actor(names.get(i), movieNames.get(i), pictures.get(i)));
        }

        return actors;
    }

    public String getName() {
        return name;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getPicture() {
        return picture;
    }
}
