package com.example.tristan.orpheecreation.ui;

import android.content.Context;

import java.util.List;

/**
 * Created by Tristan on 05/03/2016.
 */
public class Song {
    private Context mContext;
    private String mTitle;
    private List<Track> mTrackList;

    public Song(Context context, String title) {
        mContext = context;
        mTitle = title;
    }

    public Track addNewTrack(String title) {
        Track track = new Track(mContext, title);
        mTrackList.add(track);
        return track;
    }

    public void deleteTrackById(int id) {
        // TODO
    }
}
