package com.eip.tristan.orphee.dev.midi;

import org.billthefarmer.mididriver.MidiDriver;

/**
 * Created by Tristan on 28/03/2016.
 */
public class Midi implements MidiDriver.OnMidiStartListener {
    public final int EVENT_NOTE_ON = 0x90;
    public final int EVENT_NOTE_OFF = 0x80;
    public final int EVENT_CHANGE_PROGRAM = 0xc0;
    public final int END_OF_TRACK = 0xff2f00;
    public final int TIME_SIGNATURE = 0xff5804;
    public final int TEMPO = 0xff5103;
    public final int MThd = 0x4d546864;
    public final int MTrk = 0x4d54726b;

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
        sendMidi(EVENT_NOTE_ON + channel, note, 63);
    }

    public void stopNote(int channel, int note) {
        sendMidi(EVENT_NOTE_OFF + channel, note, 0);
    }

    public void changeInstrument(int channel, int instrument) {
        sendMidi(EVENT_CHANGE_PROGRAM + channel, instrument);
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
