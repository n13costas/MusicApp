package com.example.android.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        /* Get the extras from intent to show them in details activity */
        Intent detailsIntent = getIntent();
        String songName = detailsIntent.getStringExtra("detailsSongName");
        String songGroup = detailsIntent.getStringExtra("detailsSongGroup");
        String songYear = detailsIntent.getStringExtra("detailsSongYear");

        // Add the extras to views
        TextView detailsName = findViewById(R.id.detailsName);
        detailsName.setText(songName);

        TextView detailsGroup = findViewById(R.id.detailsGroup);
        detailsGroup.setText(songGroup);

        TextView detailsYear = findViewById(R.id.detailsYear);
        detailsYear.setText(songYear);

        // Go back to list view
        TextView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
