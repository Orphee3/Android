package com.eip.tristan.orphee.dev.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Tristan on 05/03/2016.
 */
public class Track {
    private Context mContext;
    private String mTitle;
    private ArrayList<Column> mColumnList;

    private final int DEFAULT_SIZE = 8;

    Track(Context context, String title) {
        mTitle = title;
        mContext = context;

        mColumnList = new ArrayList<>();
        for (int i=0; i < DEFAULT_SIZE; i++)
            mColumnList.add(new Column(mContext, i));
    }

    public void addNewColumn() {
        Log.d("TRACK", "add new column");
        mColumnList.add(new Column(mContext, mColumnList.size()));
    }

    public void deleteColumnById(int id) {
        mColumnList.remove(id);
    }

    public int getNumberOfColumns() {
        return mColumnList.size();
    }
}
