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
        // Program change - harpsicord

        sendMidi(0xc0, 6);

        // Get the config

        /*int config[] = midiDriver.config();
        String format =
                "maxVoices = %d\nnumChannels = %d\n" +
                        "sampleRate = %d\nmixBufferSize = %d";

        String info = String.format(format, config[0], config[1],
                config[2], config[3]);

        /*if (text != null)
            text.setText(info);*/
    }
}
