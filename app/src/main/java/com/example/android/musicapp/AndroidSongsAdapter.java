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

    Activity a;

    public AndroidSongsAdapter(Activity context, ArrayList<Song> Songs) {
        super(context, 0, Songs);

        this.a = context;
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

        TextView nameTextView = listItemView.findViewById(R.id.song_name);
        nameTextView.setText(currentSong.getSongName());

        TextView groupTextView = listItemView.findViewById(R.id.song_group);
        groupTextView.setText(currentSong.getSongGroup());

        TextView yearTextView =  listItemView.findViewById(R.id.song_year);
        yearTextView.setText(currentSong.getSongYear());

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

    private void openDetailsActivity(String sname, String sgroup, String syear){
        Intent detailsIntent= new Intent(a, DetailsActivity.class);
        detailsIntent.putExtra("SongN", sname );
        detailsIntent.putExtra("SongG", sgroup );
        detailsIntent.putExtra("SongY", syear );

        a.startActivity(detailsIntent);
    }



}
