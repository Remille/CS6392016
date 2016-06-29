package com.example.sophia.sophiamunshimidterm;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        final EditText milesInput = (EditText) rootView.findViewById(R.id.milesInput);
        final TextView kilometerOutput = (TextView) rootView.findViewById(R.id.kilometerOutput);
        Button convert = (Button)rootView.findViewById(R.id.convertButton);
        convert.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input;
                if (!(milesInput.getText().length() > 0)) {
                    input = "0";
                }
                else {
                    input = milesInput.getText().toString();
                }

                Double miles = Double.parseDouble(input);
                Double kilometers = miles * 1.609;
                kilometerOutput.setText(kilometers.toString());
            }
        });

        Button clear = (Button)rootView.findViewById(R.id.clearButton);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                milesInput.setText("");
                kilometerOutput.setText("");
            }
        });
        return rootView;
    }


}
