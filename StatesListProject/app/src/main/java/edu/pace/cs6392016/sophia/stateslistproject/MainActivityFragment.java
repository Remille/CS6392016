package edu.pace.cs6392016.sophia.stateslistproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        States st = new States();
        final String[] states = st.getStateArray();
        //final String[] stateCapitols = st.getStateCapitals();
        final String[] stateCapitolsLatLong = st.getStateCapitolsLongLat();

        List<String> stateList = new ArrayList<String>(Arrays.asList(states));

        ArrayAdapter<String> stateAdapter = new ArrayAdapter<String>(getActivity(),
                R.layout.listviewiteminlinear,
                R.id.textviewitem1,
                stateList);

        ListView lv = (ListView) rootView.findViewById(R.id.listView);
        lv.setAdapter(stateAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String stateName = states[position];
                //String stateCapitol = stateCapitols[position];
                //String query = stateCapitol+", "+stateName;
                String query = stateCapitolsLatLong[position];
                String geoUri = "geo:"+query+"?z=12";
                Uri geo = Uri.parse(geoUri);
                Intent intent = new Intent(Intent.ACTION_VIEW,geo);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
