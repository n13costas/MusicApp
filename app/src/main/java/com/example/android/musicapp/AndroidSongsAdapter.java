package com.example.android.musicapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AndroidSongsAdapter extends ArrayAdapter<Song> {

    private static final String LOG_TAG = AndroidSongsAdapter.class.getSimpleName();

    public AndroidSongsAdapter(Activity context, ArrayList<Song> Songs) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, Songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Song currentSong = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = listItemView.findViewById(R.id.song_name);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentSong.getSongName());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView groupTextView = listItemView.findViewById(R.id.song_group);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        groupTextView.setText(currentSong.getSongGroup());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        TextView yearTextView =  listItemView.findViewById(R.id.song_year);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        yearTextView.setText(currentSong.getSongYear());

        // Return the whole list item layout (containing 3 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }


}
