package com.eip.tristan.orphee.dev.midi;

/**
 * Created by Tristan on 28/03/2016.
 */
public enum Instrument {
    PIANO1("Piano 1", 0),
    PIANO2("Piano 2", 1),
    PIANO3("Piano 3", 2),
    PIANO4("Piano 4", 3),
    PIANO5("Piano 5", 4),
    PIANO6("Piano 6", 5),
    PIANO7("Piano 7", 6),
    PIANO8("Piano 8", 7),
    CHROPERC1("Chromatic Percussion 1", 8),
    CHROPERC2("Chromatic Percussion 2", 9),
    CHROPERC3("Chromatic Percussion 3", 10),
    CHROPERC4("Chromatic Percussion 4", 11),
    CHROPERC5("Chromatic Percussion 5", 12),
    CHROPERC6("Chromatic Percussion 6", 13),
    CHROPERC7("Chromatic Percussion 7", 14),
    CHROPERC8("Chromatic Percussion 8", 15),
    ORGAN1("Organ 1", 16),
    ORGAN2("Organ 2", 17),
    ORGAN3("Organ 3", 18),
    ORGAN4("Organ 4", 19),
    ORGAN5("Organ 5", 20),
    ORGAN6("Organ 6", 21),
    ORGAN7("Organ 7", 22),
    ORGAN8("Organ 8", 23),
    GUITAR1("Guitar 1", 24),
    GUITAR2("Guitar 2", 25),
    GUITAR3("Guitar 3", 26),
    GUITAR4("Guitar 4", 27),
    GUITAR5("Guitar 5", 28),
    GUITAR6("Guitar 6", 29),
    GUITAR7("Guitar 7", 30),
    GUITAR8("Guitar 8", 31),
    BASS1("Bass 1", 32),
    BASS2("Bass 2", 33),
    BASS3("Bass 3", 34),
    BASS4("Bass 4", 35),
    BASS5("Bass 5", 36),
    BASS6("Bass 6", 37),
    BASS7("Bass 7", 38),
    BASS8("Bass 8", 39),
    STRING1("String 1", 40),
    STRING2("String 2", 41),
    STRING3("String 3", 42),
    STRING4("String 4", 43),
    STRING5("String 5", 44),
    STRING6("String 6", 45),
    STRING7("String 7", 46),
    STRING8("String 8", 47);


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
