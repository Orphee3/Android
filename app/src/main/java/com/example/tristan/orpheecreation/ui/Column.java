package com.example.tristan.orpheecreation.ui;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tristan.orpheecreation.R;

import java.util.List;

/**
 * Created by Tristan on 05/03/2016.
 */
public class Column {
    private int mId;
    private List<NoteButton> mNoteButtonList;
    private Context mContext;

    private final int DEFAULT_SIZE = 5;

    public Column(Context context, int id) {
        mContext = context;
        mId = id;

        LayoutInflater vi = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = vi.inflate(R.layout.column_layout, null);

        // fill in any details dynamically here
        TextView textView = (TextView) v.findViewById(R.id.columnId);
        textView.setText(String.valueOf(mId));

        for (int i=0; i < DEFAULT_SIZE; i++)
            mNoteButtonList.add(new NoteButton());

        // insert into main view
        /*ViewGroup insertPoint = (ViewGroup) findViewById(R.id.insert_point);
        insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));*/


    }
}
