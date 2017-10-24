package com.fragments.praveenkumar.fragmentsapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by PraveenKumar on 10/22/2017.
 */

public class RosterList extends Fragment {

    String[] rosterNames = {"PraveenKumar","Jordan Bell", "Chris Boucher", "Quinn Cook", "Kevin Durant", "Draymond Green", "Andre lguodala"};
    int[] rosterNumbers = {0,2,25,4,35,23,9};
    String[] fieldPositions = {"xyz@gmail.com","Forward","Forward","Guard","Forward","Forward","Guard-Forward"};
    ListView listView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rosterlist_fragment, container, false);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, rosterNames);

        listView = (ListView) view.findViewById(R.id.roster_list);
        listView.setAdapter(adapter);

        return  view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment detailsFragment = new PlayerDetails();
                String details = rosterNames[position];
                Bundle b = new Bundle();
                b.putInt("index",position);
                b.putString("position",fieldPositions[position]);
                b.putInt("number",rosterNumbers[position]);
                b.putString("details",details);
                detailsFragment.setArguments(b);
                FragmentManager fm = getFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.frameLayout, detailsFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}
