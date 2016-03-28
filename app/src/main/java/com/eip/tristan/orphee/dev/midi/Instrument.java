package com.eip.tristan.orphee.dev.midi;

/**
 * Created by Tristan on 28/03/2016.
 */
public enum Instrument {
    PIANO1("Piano", 1),
    GUITAR1("Guitar", 25);

    private String mName;
    private int mId;

    //Constructeur

    Instrument(String name, int id){
        mName = name;
        mId = id;
    }

    public String toString(){
        return mName;
    }

    public String getName() {
        return mName;
    }

    public int getId() {
        return mId;
    }
}
