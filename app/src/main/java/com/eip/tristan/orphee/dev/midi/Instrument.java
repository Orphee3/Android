package com.eip.tristan.orphee.dev.midi;

/**
 * Created by Tristan on 28/03/2016.
 */
public class Instrument {
    final public int PIANO = 1;
    final public int GUITAR = 25;

    private static Instrument ourInstance = new Instrument();

    public static Instrument getInstance() {
        return ourInstance;
    }

    private Instrument() {
    }
}
