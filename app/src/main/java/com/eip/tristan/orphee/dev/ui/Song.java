package com.eip.tristan.orphee.dev.ui;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Tristan on 05/03/2016.
 */
public class Song {
    private Context mContext;
    private String mTitle;
    private ArrayList<Track> mTrackList;
    private int mCurrentTrack;

    public Song(Context context, String title) {
        mContext = context;
        mTitle = title;
        mTrackList = new ArrayList<>();
        mCurrentTrack = 0;
    }

    public void addNewTrack(String title) {
        mTrackList.add(new Track(mContext, title));
    }

    public void deleteTrackById(int id) {
        mTrackList.remove(id);
    }

    public Track getCurrentTrack() {
        return mTrackList.get(mCurrentTrack);
    }

    public int getNumberOfTracks() {
        return mTrackList.size();
    }
}
