package com.fragments.praveenkumar.fragmentsapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {


    //int[] rosterNumber = {2,25,18,4,30,35,23};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment f = new RosterList();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.frameLayout,f);
        transaction.commit();
        if(getResources().getDisplayMetrics().widthPixels>getResources().getDisplayMetrics().
                heightPixels)
        {

            Toast.makeText(this,"Screen switched to Landscape mode",Toast.LENGTH_SHORT).show();
        }
        else
        {

            Toast.makeText(this,"Screen switched to Portrait mode",Toast.LENGTH_SHORT).show();
        }
    }

}




