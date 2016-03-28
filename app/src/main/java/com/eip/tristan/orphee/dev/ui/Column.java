package com.eip.tristan.orphee.dev.ui;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.eip.tristan.orphee.R;

import org.billthefarmer.mididriver.MidiDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tristan on 05/03/2016.
 */
public class Column {
    private int mId;
    private Track mTrack;
    private ArrayList<NoteButton> mNoteButtonList;
    private Context mContext;
    private LinearLayout mLayout;

    private final int DEFAULT_SIZE = 12;

    public Column(Context context, Track track, int id) {
        mContext = context;
        mTrack = track;
        mId = id;
        mNoteButtonList = new ArrayList<>();

        LayoutInflater inflater = (LayoutInflater)
                mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayout = (LinearLayout) inflater.inflate(R.layout.column_layout, null);
        TextView idText = (TextView) mLayout.findViewById(R.id.columnId);
        idText.setText(Integer.toString(id+1));
        for (int i =0; i < DEFAULT_SIZE; i++) {
            NoteButton noteButton = new NoteButton(mContext, mTrack.getId(), 60+i);
            mNoteButtonList.add(noteButton);
            mLayout.addView(noteButton.getButton());
        }
    }

    public LinearLayout getLayout() {
        return mLayout;
    }
}
