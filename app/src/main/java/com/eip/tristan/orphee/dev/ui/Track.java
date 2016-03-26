package com.eip.tristan.orphee.dev.ui;

import android.content.Context;

import java.util.List;

/**
 * Created by Tristan on 05/03/2016.
 */
public class Track {
    private Context mContext;
    private String mTitle;
    private List<Column> mColumnList;

    private final int DEFAULT_SIZE = 8;

    Track(Context context, String title) {
        mTitle = title;
    }

    public void init() {
        for (int i=0; i < DEFAULT_SIZE; i++)
            mColumnList.add(new Column(mContext, i + 1));
    }

    public void addNewColumn() {
        mColumnList.add(new Column(mContext, mColumnList.size() + 1));
    }

    public void deleteColumnById(int id) {
        // TODO
    }

    public int getNumberOfColumns() {
        return mColumnList.size();
    }
}
