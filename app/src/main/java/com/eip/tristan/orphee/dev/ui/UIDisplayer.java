package com.eip.tristan.orphee.dev.ui;

import android.app.Activity;
import android.content.Context;
import android.net.LinkAddress;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.eip.tristan.orphee.R;

import java.util.ArrayList;

/**
 * Created by Tristan on 28/03/2016.
 */
public class UIDisplayer {
    private Context mContext;
    private Song mSong;
    private LinearLayout mTrackButtonsLayout;
    private ArrayList<Button> buttonsList;

    public UIDisplayer(Context context) {
        mContext = context;
        mSong = new Song(mContext, "");
        mTrackButtonsLayout = (LinearLayout) ((Activity) mContext).findViewById(R.id.trackButtonsLayout);
        buttonsList = new ArrayList<>();
        Button addTrackButton = (Button) mTrackButtonsLayout.findViewById(R.id.addTrack);
        addTrackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTrack();
            }
        });

        addTrack();
    }

    public void setSong(Song song) {
        mSong = song;
    }

    public Song getSong() {
        return mSong;
    }

    public void addTrack() {
        final int trackId = mSong.getNumberOfTracks();
        mSong.addNewTrack("");
        Button button = new Button(mContext);
        button.setText("Track "+ Integer.toString(trackId));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTrack(trackId);
            }
        });
        LinearLayout buttonsList = (LinearLayout) mTrackButtonsLayout.findViewById(R.id.trackButtonsList);
        buttonsList.addView(button);
        displayTrack(trackId);
    }

    public void deleteTrack() {

    }

    public void displayTrack(int id) {
        mSong.setCurrentTrack(id);
    }
}
