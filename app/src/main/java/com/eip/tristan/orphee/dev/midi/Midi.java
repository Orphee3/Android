package com.eip.tristan.orphee.dev.midi;

import org.billthefarmer.mididriver.MidiDriver;

/**
 * Created by Tristan on 28/03/2016.
 */
public class Midi implements MidiDriver.OnMidiStartListener {
    private MidiDriver midiDriver;

    private static Midi ourInstance = new Midi();

    public static Midi getInstance() {
        return ourInstance;
    }

    private Midi() {
        midiDriver = new MidiDriver();
        // Set on midi start listener

        if (midiDriver != null)
            midiDriver.setOnMidiStartListener(this);
    }

    public MidiDriver getMidiDriver() {
        return midiDriver;
    }

    public void playNote(int channel, int note) {
        sendMidi(0x90 + channel, note, 63);
    }

    public void stopNote(int channel, int note) {
        sendMidi(0x80 + channel, note, 0);
    }

    public void changeInstrument(int channel, int instrument) {
        sendMidi(0xc0 + channel, instrument);
    }

    public void sendMidi(int m, int p)
    {
        byte msg[] = new byte[2];

        msg[0] = (byte) m;
        msg[1] = (byte) p;

        midiDriver.write(msg);
    }

    public void sendMidi(int m, int n, int v)
    {
        byte msg[] = new byte[3];

        msg[0] = (byte) m;
        msg[1] = (byte) n;
        msg[2] = (byte) v;

        midiDriver.write(msg);
    }

    public void onMidiStart()
    {
        sendMidi(0xc0, 6);
    }
}
