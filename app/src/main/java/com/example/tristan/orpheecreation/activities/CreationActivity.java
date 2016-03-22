package com.example.tristan.orpheecreation.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.example.tristan.orpheecreation.R;
import org.billthefarmer.mididriver.MidiDriver;
import com.example.tristan.orpheecreation.ui.Song;
import com.example.tristan.orpheecreation.ui.Track;

public class CreationActivity extends AppCompatActivity implements View.OnTouchListener {

    private MidiDriver midi;
    private Song song;
    private Track currentTrack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation);

        midi = new MidiDriver();
        song = new Song(this, "New Song");

        initUI();
        //setListener();
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        if (midi != null)
            midi.start();
    }

    @Override
    protected void onPause()
    {
        super.onPause();

        if (midi != null)
            midi.stop();
    }

    /*@Override
    public void onMidiStart()
    {
        // Set instrument

        for (int i = 0; i <= buttons.length; i++)
            midi.writeChange(change + i, instrument);
    }*/

    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        int action = event.getAction();
        int id = v.getId();

        switch (action)
        {
            // Down

            case MotionEvent.ACTION_DOWN:
                switch (id)
                {

                }

                // Up

            case MotionEvent.ACTION_UP:
                switch (id)
                {

                }

            default:
                return false;
        }
    }

    /*private void setListener() {
        View v;

        // Set listener for all buttons

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                v = findViewById(buttons[i][j]);
                if (v != null)
                    v.setOnTouchListener(this);
            }
        }

        if (midi != null)
            midi.setOnMidiStartListener(this);
    }*/

    private void initUI() {
        currentTrack = song.addNewTrack("");
        currentTrack.init();
    }
}
