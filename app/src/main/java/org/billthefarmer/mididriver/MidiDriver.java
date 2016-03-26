package org.billthefarmer.mididriver;

/**
 * Created by trstm on 10/10/2015.
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

    // Queue event

    public void queueEvent(byte[] event)
    {
        write(event);
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
    public  native int[]   config();
    public  native boolean write(byte a[]);
    private native boolean shutdown();

    // Load midi library

    static
    {
        System.loadLibrary("midi");
    }
}