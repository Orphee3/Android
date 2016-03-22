package org.billthefarmer.mididriver;

/**
 * Created by Tristan on 05/03/2016.
 */
public class MidiDriver
{
    private OnMidiStartListener listener;

    // Constructor

    public MidiDriver()
    {
    }

    // Start midi

    public void start()
    {
        if (init() != true)
            return;

        // Call listener

        if (listener != null)
            listener.onMidiStart();
    }

    // Write program change message, two bytes

    public boolean writeChange(int m, int i)
    {
        byte changeMsg[] = new byte[2];

        changeMsg[0] = (byte)m;
        changeMsg[1] = (byte)i;

        write(changeMsg);
        return true;
    }

    // Write note message, three bytes

    public boolean writeNote(int m, int n, int v)
    {
        byte noteMsg[] = new byte[3];

        noteMsg[0] = (byte)m;
        noteMsg[1] = (byte)n;
        noteMsg[2] = (byte)v;

        write(noteMsg);
        return true;
    }

    // Stop

    public void stop()
    {
        shutdown();
    }

    // Set listener

    public void setOnMidiStartListener(OnMidiStartListener l)
    {
        listener = l;
    }

    // Listener interface

    public interface OnMidiStartListener
    {
        public abstract void onMidiStart();
    }

    // Native midi methods

    private native boolean init();
    private native boolean write(byte a[]);
    private native boolean shutdown();

    // Load midi library

    static
    {
        System.loadLibrary("midi");
    }
}
