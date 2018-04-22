package com.example.android.musicapp;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AndroidSongsAdapter extends ArrayAdapter<Song> {

    Activity activity;

    public AndroidSongsAdapter(Activity context, ArrayList<Song> Songs) {
        super(context, 0, Songs);
        this.activity = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the Song object located at this position in the list
        final Song currentSong = getItem(position);

        TextView nameTextView = listItemView.findViewById(R.id.songName);
        nameTextView.setText(currentSong.getSongName());

        TextView groupTextView = listItemView.findViewById(R.id.songGroup);
        groupTextView.setText(currentSong.getSongGroup());

        TextView yearTextView =  listItemView.findViewById(R.id.songYear);
        yearTextView.setText(currentSong.getSongYear());

        // Open the details activity on item click
        listItemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openDetailsActivity(currentSong.getSongName(), currentSong.getSongGroup(), currentSong.getSongYear());
            }
        });

        // Return the whole list item layout (containing 3 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }

    // Open the details activity method through intent and adding some extras
    private void openDetailsActivity(String detailsSongName, String detailsSongGroup, String detailsSongYear){
        Intent detailsIntent= new Intent(activity, DetailsActivity.class);
        detailsIntent.putExtra("detailsSongName", detailsSongName );
        detailsIntent.putExtra("detailsSongGroup", detailsSongGroup );
        detailsIntent.putExtra("detailsSongYear", detailsSongYear );

        activity.startActivity(detailsIntent);
    }
}
