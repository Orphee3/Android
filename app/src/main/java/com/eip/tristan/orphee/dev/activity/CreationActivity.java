package com.eip.tristan.orphee.dev.activity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eip.tristan.orphee.R;
import com.eip.tristan.orphee.dev.ui.Column;
import com.eip.tristan.orphee.dev.ui.Song;
import com.eip.tristan.orphee.dev.ui.Track;

import org.billthefarmer.mididriver.MidiDriver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CreationActivity extends AppCompatActivity implements View.OnTouchListener, View.OnClickListener,MidiDriver.OnMidiStartListener {

    protected MidiDriver midi;
    protected MediaPlayer player;
    private Song song;

    private Button addColumn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation);

        addColumn = (Button) findViewById(R.id.addColumn);
        addColumn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                song.getCurrentTrack().addNewColumn();
                Log.d("CREATION", "ajout colonne");
            }
        });

        View v = findViewById(R.id.button);
        if (v != null)
            v.setOnTouchListener(this);

        midi = new MidiDriver();

        // Set on midi start listener

        if (midi != null)
            midi.setOnMidiStartListener(this);

        song = new Song(this, "");
        song.addNewTrack("track1");
        Log.d("CREATION", "number of columns = " + song.getCurrentTrack().getNumberOfColumns());

    }

    @Override
    protected void onResume()
    {
        super.onResume();

        // Start midi

        if (midi != null)
            midi.start();
    }

    // On pause

    @Override
    protected void onPause()
    {
        super.onPause();

        // Stop midi

        if (midi != null)
            midi.stop();

        // Stop player

        if (player != null)
            player.stop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

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
                    case R.id.button:
                        sendMidi(0x90, 48, 63);
                        sendMidi(0x90, 52, 63);
                        sendMidi(0x90, 55, 63);
                        break;

                    default:
                        return false;
                }
                break;

            // Up

            case MotionEvent.ACTION_UP:
                switch (id)
                {
                    case R.id.button:
                        sendMidi(0x80, 48, 0);
                        sendMidi(0x80, 52, 0);
                        sendMidi(0x80, 55, 0);
                        break;

                    default:
                        return false;
                }
                break;

            default:
                return false;
        }

        return false;
    }

    public void onClick(View v)
    {
        int id = v.getId();

        switch (id)
        {
            case R.id.button2:
                if (player != null)
                {
                    player.stop();
                    player.release();
                }

                player = MediaPlayer.create(this, R.raw.ants);
                player.start();
                break;

            /*case R.id.addColumn:
                song.getCurrentTrack().addNewColumn();
                Log.d("CREATION", "ajout colonne");
                break;*/
        }
    }


    public void onMidiStart()
    {
        // Program change - harpsicord

        sendMidi(0xc0, 6);

        // Get the config

        int config[] = midi.config();
        String format =
                "maxVoices = %d\nnumChannels = %d\n" +
                        "sampleRate = %d\nmixBufferSize = %d";

        String info = String.format(format, config[0], config[1],
                config[2], config[3]);

        /*if (text != null)
            text.setText(info);*/
    }

    // Send a midi message

    protected void sendMidi(int m, int p)
    {
        byte msg[] = new byte[2];

        msg[0] = (byte) m;
        msg[1] = (byte) p;

        midi.write(msg);
    }

    // Send a midi message

    protected void sendMidi(int m, int n, int v)
    {
        byte msg[] = new byte[3];

        msg[0] = (byte) m;
        msg[1] = (byte) n;
        msg[2] = (byte) v;

        midi.write(msg);
    }
}

