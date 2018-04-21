package com.example.android.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        /* Getting category chosen by user */
        Intent detailsIntent = getIntent();
        String sName = detailsIntent.getStringExtra("SongN");
        String sGroup = detailsIntent.getStringExtra("SongG");
        String sYear = detailsIntent.getStringExtra("SongY");

        TextView dName = findViewById(R.id.detailsName);
        dName.setText(sName);

        TextView dGroup = findViewById(R.id.detailsGroup);
        dGroup.setText(sGroup);

        TextView dYear = findViewById(R.id.detailsYear);
        dYear.setText(sYear);

    }
}
