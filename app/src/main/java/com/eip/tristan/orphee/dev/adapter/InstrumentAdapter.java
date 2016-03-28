package com.eip.tristan.orphee.dev.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.eip.tristan.orphee.R;
import com.eip.tristan.orphee.dev.midi.Instrument;

import java.util.ArrayList;

/**
 * Created by Tristan on 28/03/2016.
 */
public class InstrumentAdapter extends ArrayAdapter<Instrument> {

    public InstrumentAdapter(Context context, ArrayList<Instrument> instruments) {
        super(context, 0, instruments);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Instrument instrument = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_instrument, parent, false);
        }
        // Lookup view for data population
        TextView instrumentName = (TextView) convertView.findViewById(R.id.instrumentName);
        // Populate the data into the template view using the data object
        instrumentName.setText(instrument.getName());
        // Return the completed view to render on screen
        return convertView;
    }

    /*public Instrument getItem(int position){
        return instruments.get(position);
    }*/
}
