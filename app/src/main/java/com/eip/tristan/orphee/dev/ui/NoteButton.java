package com.eip.tristan.orphee.dev.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.eip.tristan.orphee.dev.activity.CreationActivity;
import com.eip.tristan.orphee.dev.midi.Midi;

import org.billthefarmer.mididriver.MidiDriver;

/**
 * Created by Tristan on 05/03/2016.
 */
public class NoteButton {
    private Context mContext;
    private int mTrackId;
    private Button mButton;
    private int mNote;
    private boolean mLocked;
    private Midi midi;

    public NoteButton(Context context, int trackId, int note) {
        mContext = context;
        mTrackId = trackId;
        midi = Midi.getInstance();
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
                        midi.playNote(mTrackId, mNote);
                        Log.d("NOTEBUTTON", "play note " + Integer.toString(mNote) + " in channel " + Integer.toString(mTrackId));
                        if (mLocked) {
                            mLocked = false;
                            mButton.getBackground().setColorFilter(0xFFC7C7C7, PorterDuff.Mode.MULTIPLY);
                        } else {
                            mLocked = true;
                            mButton.getBackground().setColorFilter(0xFF2F41A5, PorterDuff.Mode.MULTIPLY);
                        }

                        break;

                        // Up

                    case MotionEvent.ACTION_UP:
                        Log.d("NOTEBUTTON", "stop note " + Integer.toString(mNote) + " in channel " + Integer.toString(mTrackId));
                        midi.stopNote(mTrackId, mNote);
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

    public void play() {
        midi.playNote(mTrackId, mNote);
    }
}
