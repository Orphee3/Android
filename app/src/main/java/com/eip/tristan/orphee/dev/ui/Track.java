package com.eip.tristan.orphee.dev.ui;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eip.tristan.orphee.R;
import com.eip.tristan.orphee.dev.midi.Instrument;
import com.eip.tristan.orphee.dev.midi.Midi;

import org.billthefarmer.mididriver.MidiDriver;

import java.util.ArrayList;

/**
 * Created by Tristan on 05/03/2016.
 */
public class Track {
    private Context mContext;
    private boolean mIsCurrentTrack;
    private LinearLayout mLayout;
    private Button mAddColumn;
    private int mId;
    private Midi midi;
    private String mTitle;
    private ArrayList<Column> mColumnList;
    private Instrument mInstrument;

    private final int DEFAULT_SIZE = 8;

    Track(Context context, int id, String title) {
        mTitle = title;
        mIsCurrentTrack = true;
        mId = id;
        mContext = context;
        midi = Midi.getInstance();
        mInstrument = Instrument.PIANO1;
        setInstrument(mInstrument);

        mColumnList = new ArrayList<>();
        LayoutInflater inflater = (LayoutInflater)
                mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout mainLayout = (LinearLayout) ((Activity)mContext).findViewById(R.id.trackLayout);
        LinearLayout track_layout = (LinearLayout) inflater.inflate(R.layout.track_layout, mainLayout, false);
        mAddColumn = (Button) track_layout.findViewById(R.id.addColumn);
        mAddColumn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewColumn();
            }
        });
        mLayout = (LinearLayout) track_layout.findViewById(R.id.trackContent);
        for (int i =0; i < DEFAULT_SIZE; i++) {
            Column column = new Column(mContext, this, i);
            mColumnList.add(column);;
            mLayout.addView(column.getLayout());
        }
        mainLayout.addView(track_layout, mId);

        Log.d("TRACK", "track " + Integer.toString(mId) + " created");
    }

    public void addNewColumn() {
        Column column = new Column(mContext, this, mColumnList.size());
        mColumnList.add(column);
        mLayout.addView(column.getLayout());
    }

    public void deleteColumnById(int id) {
        mColumnList.remove(id);
    }

    public int getNumberOfColumns() {
        return mColumnList.size();
    }

    public Instrument getInstrument() {
        return mInstrument;
    }

    public void setInstrument(Instrument instrument) {
        mInstrument = instrument;
        //mInstrument = Instrument.values()[id];
        Log.d("TRACK", "change instrument to " + mInstrument.getName() + " in channel " + Integer.toString(mId));
        midi.changeInstrument(mId, mInstrument.getId());
    }

    public int getId() {
        return mId;
    }

    public boolean isCurrentTrack() {
        return mIsCurrentTrack;
    }

    public void setCurrentTrack(boolean currentTrack) {
        mIsCurrentTrack = currentTrack;
        if (currentTrack) {
            mLayout.setVisibility(View.VISIBLE);
            mAddColumn.setVisibility(View.VISIBLE);
        }
        else {
            mLayout.setVisibility(View.GONE);
            mAddColumn.setVisibility(View.GONE);
        }
    }

    public Column getColumnById(int id) {
        return mColumnList.get(id);
    }

}
