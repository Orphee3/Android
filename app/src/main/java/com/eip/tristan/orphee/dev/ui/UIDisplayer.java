package com.eip.tristan.orphee.dev.ui;

import android.app.Activity;
import android.content.Context;
import android.net.LinkAddress;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.eip.tristan.orphee.R;
import com.eip.tristan.orphee.dev.adapter.InstrumentAdapter;
import com.eip.tristan.orphee.dev.midi.Instrument;
import com.eip.tristan.orphee.dev.midi.Midi;

import java.util.ArrayList;

/**
 * Created by Tristan on 28/03/2016.
 */
public class UIDisplayer {
    private Context mContext;
    private Midi midi;
    private Song mSong;
    private RelativeLayout mUILayout;
    private LinearLayout mTrackButtonsLayout;
    private ArrayList<Button> buttonsList;

    public UIDisplayer(Context context) {
        mContext = context;
        midi = Midi.getInstance();
        mSong = new Song(mContext, "");
        mUILayout = (RelativeLayout) ((Activity) mContext).findViewById(R.id.uiLayout);
        //mTrackButtonsLayout = (LinearLayout) ((Activity) mContext).findViewById(R.id.trackButtonsLayout);
        mTrackButtonsLayout = (LinearLayout) mUILayout.findViewById(R.id.trackButtonsLayout);
        buttonsList = new ArrayList<>();
        Button addTrackButton = (Button) mTrackButtonsLayout.findViewById(R.id.addTrack);
        addTrackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTrack();
            }
        });
        Button playButton = (Button) mUILayout.findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSong();
            }
        });

        initInstrumentsList();
        addTrack();
    }

    private void initInstrumentsList() {
        // Construct the data source
        ArrayList<Instrument> instruments = new ArrayList<Instrument>();
        for (int i=0; i < Instrument.values().length; i++)
            instruments.add(Instrument.values()[i]);
        // Create the adapter to convert the array to views
        final InstrumentAdapter adapter = new InstrumentAdapter(mContext, instruments);
        // Attach the adapter to a ListView
        ListView listView = (ListView) ((Activity) mContext).findViewById(R.id.instrumentsList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Instrument instrument = adapter.getItem(position);
                mSong.getCurrentTrack().setInstrument(instrument);
            }
        });
    }

    public void setSong(Song song) {
        mSong = song;
    }

    public Song getSong() {
        return mSong;
    }

    public void playSong() {
        mSong.play();
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
