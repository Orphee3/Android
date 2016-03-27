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
    private ArrayList<NoteButton> mNoteButtonList;
    private Context mContext;

    private final int DEFAULT_SIZE = 12;

    public Column(Context context, int id) {
        mContext = context;
        mId = id;
        mNoteButtonList = new ArrayList<>();

        LayoutInflater inflater = (LayoutInflater)
                mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout linearLayout = (LinearLayout) ((Activity)mContext).findViewById(R.id.trackContent);
        LinearLayout column_layout = (LinearLayout) inflater.inflate(R.layout.column_layout, linearLayout, false);
        for (int i =0; i < DEFAULT_SIZE; i++) {
            NoteButton noteButton = new NoteButton(mContext, 60+i);
            mNoteButtonList.add(noteButton);
            column_layout.addView(noteButton.getButton());
        }
        linearLayout.addView(column_layout, mId);

    }
}
