package com.eip.tristan.orphee.dev.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import org.billthefarmer.mididriver.MidiDriver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Tristan on 05/03/2016.
 */
public class Song {
    private final int MAX_NUMBER_OF_TRACKS = 16;

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
        if (mTrackList.size() < MAX_NUMBER_OF_TRACKS) {
            mTrackList.add(new Track(mContext, mTrackList.size(), title));
            setCurrentTrack(mTrackList.size());
        }
        else
            Log.d("SONG", "max number of tracks reached");
    }

    public Track getCurrentTrack() {
        return mTrackList.get(mCurrentTrack);
    }

    public void setCurrentTrack(int id) {
        for (int i=0; i < mTrackList.size(); i++) {
            if (i == id)
                mTrackList.get(i).setCurrentTrack(true);
            else
                mTrackList.get(i).setCurrentTrack(false);
        }
    }

    public int getNumberOfTracks() {
        return mTrackList.size();
    }

    public Track getTrackById(int id) {
        return mTrackList.get(id);
    }

    public void deleteTrackById(int id) {
        mTrackList.remove(id);
    }
}
