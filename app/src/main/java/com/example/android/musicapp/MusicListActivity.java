package com.example.android.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MusicListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);

        // Create an ArrayList of Song objects
        final ArrayList<Song> Songs = new ArrayList<>();
        Songs.add(new Song("Imagine", "John Lennon", "1971"));
        Songs.add(new Song("Bohemian Rhapsody", "Queen", "1975"));
        Songs.add(new Song("Cats In The Cradle", "Harry Chapin", "1974"));
        Songs.add(new Song("Brothers In Arms", "Dire Straits", "1985"));
        Songs.add(new Song("Stairway To Heaven", "Led Zeppelin", "1971"));
        Songs.add(new Song("The Sound of Silence", "Simon & Garfunkel", "1964"));
        Songs.add(new Song("Simple Man", "Lynyrd Skynyrd", "1973"));
        Songs.add(new Song("Another Brick In The Wall", "Pink Floyd", "1982"));
        Songs.add(new Song("Riders On The Storm", "The Doors", "1971"));
        Songs.add(new Song("Space Oddity", "David Bowie", "1972"));

        // Create an AndroidSongsAdapter, whose data source is a list of Songs.
        // The adapter knows how to create list item views for each item in the list.
        AndroidSongsAdapter songAdapter = new AndroidSongsAdapter(this, Songs);

        // Get a reference to the ListView, and attach the adapter to the listView.
        final ListView listView = findViewById(R.id.listview_songs);
        listView.setAdapter(songAdapter);
    }
}
