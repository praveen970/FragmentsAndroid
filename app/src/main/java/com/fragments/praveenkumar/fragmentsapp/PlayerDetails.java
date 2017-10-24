package com.fragments.praveenkumar.fragmentsapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by PraveenKumar on 10/22/2017.
 */

public class PlayerDetails extends Fragment {

    TextView textview;
    Button backButton;
    ImageView imgVw;
    TextView number;
    TextView positionPlayer;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.playerdetails_fragment, container, false);
        Bundle b = getArguments();
        int num = b.getInt("number");
        int position = b.getInt("index");
        position+=1;
        String field_position = b.getString("position");
        positionPlayer = (TextView) view.findViewById(R.id.playerPosition);
        positionPlayer.setText(field_position);
        number = (TextView) view.findViewById(R.id.playerNumber);
        number.setText(Integer.toString(num));
        backButton = (Button) view.findViewById(R.id.backbutton);
        textview = (TextView) view.findViewById(R.id.playerName);
        String details = b.getString("details");
        textview.setText(details);
        imgVw = (ImageView) view.findViewById(R.id.imageView);
        int id = getResources().getIdentifier("pic"+(position-1),"drawable","com.fragments.praveenkumar.fragmentsapp");
        imgVw.setImageResource(id);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Fragment rosterFragment = new RosterList();
                FragmentManager fm = getFragmentManager();
                /* transaction = fm.beginTransaction();
                transaction.replace(R.id.frameLayout, rosterFragment);
                transaction.commit();*/

                fm.popBackStack();
            }
        });

        return view;

    }
}
