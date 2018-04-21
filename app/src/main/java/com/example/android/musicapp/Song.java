package com.example.android.musicapp;

public class Song {

    // Name of the song
    private String mSongName;

    // Name of the group
    private String mSongGroup;

    // Year of first release
    private String mSongYear;

    public Song(String sName, String sGroup, String sYear)
    {
        mSongName = sName;
        mSongGroup = sGroup;
        mSongYear = sYear;
    }

    /**
     * Get the name of the song
     */
    public String getSongName() {
        return mSongName;
    }

    /**
     * Get the name of the group
     */
    public String getSongGroup() {
        return mSongGroup;
    }

    /**
     * Get the year of first release
     */
    public String getSongYear() {
        return mSongYear;
    }

}
