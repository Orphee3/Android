package com.eip.tristan.orphee.dev.ui;

import android.content.Context;

import com.eip.tristan.orphee.dev.midi.Instrument;

import org.billthefarmer.mididriver.MidiDriver;

import java.util.ArrayList;

/**
 * Created by Tristan on 05/03/2016.
 */
public class Track {
    private Context mContext;
    private MidiDriver mMidiDriver;
    private String mTitle;
    private ArrayList<Column> mColumnList;
    private int mInstrument;

    private final int DEFAULT_SIZE = 8;

    Track(Context context, MidiDriver midi, String title) {
        mTitle = title;
        mContext = context;
        mMidiDriver = midi;
        mInstrument = Instrument.getInstance().PIANO;

        mColumnList = new ArrayList<>();
        for (int i=0; i < DEFAULT_SIZE; i++)
            mColumnList.add(new Column(mContext, mMidiDriver, i));
    }

    public void addNewColumn() {
        mColumnList.add(new Column(mContext, mMidiDriver, mColumnList.size()));
    }

    public void deleteColumnById(int id) {
        mColumnList.remove(id);
    }

    public int getNumberOfColumns() {
        return mColumnList.size();
    }

    public int getInstrument() {
        return mInstrument;
    }

    public void setInstrument(int instrument) {
        mInstrument = instrument;
    }

    protected void sendMidi(int m, int p)
    {
        byte msg[] = new byte[2];

        msg[0] = (byte) m;
        msg[1] = (byte) p;

        mMidiDriver.write(msg);
    }

}
