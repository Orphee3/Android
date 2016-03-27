package com.eip.tristan.orphee.dev.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.eip.tristan.orphee.R;
import com.eip.tristan.orphee.dev.activity.CreationActivity;

import org.billthefarmer.mididriver.MidiDriver;

/**
 * Created by Tristan on 05/03/2016.
 */
public class NoteButton {
    private Context mContext;
    private MidiDriver mMidiDriver;
    private Button mButton;
    private int mNote;
    private boolean mLocked;

    public NoteButton(Context context, MidiDriver midi, int note) {
        mContext = context;
        mMidiDriver = midi;
        mNote = note;
        mLocked = false;
        mButton = new Button(mContext);
        mButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                int action = event.getAction();

                switch (action)
                {
                    // Down

                    case MotionEvent.ACTION_DOWN:
                        sendMidi(0x90, mNote, 63);
                        if (mLocked) {
                            mLocked = false;
                            mButton.setBackgroundColor(Color.GRAY);
                        } else {
                            mLocked = true;
                            mButton.setBackgroundColor(Color.BLUE);
                        }

                        break;

                        // Up

                    case MotionEvent.ACTION_UP:
                        sendMidi(0x80, mNote, 0);
                        break;


                    default:
                        return false;
                }
                return false;
            }
        });
    }

    public Button getButton() {
        return mButton;
    }

    public int getNote() {
        return mNote;
    }

    public boolean isLocked() {
        return mLocked;
    }

    public void playNote() {
        sendMidi(0x90, mNote, 63);
    }

    // Send a midi message

    protected void sendMidi(int m, int p)
    {
        byte msg[] = new byte[2];

        msg[0] = (byte) m;
        msg[1] = (byte) p;

        mMidiDriver.write(msg);
    }

    // Send a midi message

    protected void sendMidi(int m, int n, int v)
    {
        byte msg[] = new byte[3];

        msg[0] = (byte) m;
        msg[1] = (byte) n;
        msg[2] = (byte) v;

        mMidiDriver.write(msg);
    }
}
