package com.eip.tristan.orphee.dev.midi;

import android.support.annotation.NonNull;

import com.eip.tristan.orphee.dev.ui.Song;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

/**
 * Created by Tristan on 28/03/2016.
 */
public class MidiFile {
    private Song mSong;
    private Midi midi;
    private File mFile;
    private byte[] tempoTrack;

    public MidiFile() {
        midi = Midi.getInstance();
    }

    public void create(Song song) {
        mSong = song;
        mFile = new File("song1");
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(mFile));
            bos.write(tempoTrack);
            bos.flush();
            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void writeTempoTrack() {

    }
}
