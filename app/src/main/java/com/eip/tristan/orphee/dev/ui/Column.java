package com.eip.tristan.orphee.dev.ui;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eip.tristan.orphee.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tristan on 05/03/2016.
 */
public class Column {
    private int mId;
    private ArrayList<NoteButton> mNoteButtonList;
    private Context mContext;

    private final int DEFAULT_SIZE = 5;

    public Column(Context context, int id) {
        mContext = context;
        mId = id;

        LayoutInflater inflater = (LayoutInflater)
                mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout linearLayout = (LinearLayout) ((Activity)mContext).findViewById(R.id.trackContent);
        linearLayout.addView(inflater.inflate(R.layout.column_layout, linearLayout, false), mId);

    }
}
