package com.example.lenovo.myapplication;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    private ArrayAdapter<String> ItemAdapter;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_blank, container, false);

        SharedPreferences sharedprefs= PreferenceManager.getDefaultSharedPreferences(getActivity());
        String item=sharedprefs.getString("pref_detail","No Item");
        PreferenceManager.setDefaultValues(getActivity() ,R.xml.pref_detail, false);
         String[] Itemsarray = {
                "earphones",
                "hard disk",
                "Mobile phone",
                "laptop",
                "bottle",
                "wallet",
                "charger",
                "pillow",
                "towel",
                "clothes",
                "powder",
                "oil",
                "comb",
                item
        };

        List<String> listitem= new ArrayList<String>(Arrays.asList(Itemsarray));
        ItemAdapter= new ArrayAdapter<String>(getActivity(),R.layout.fragment_list_layout,R.id.list_layout,listitem);
        ListView list= (ListView) rootview.findViewById(R.id.listview_first);
        list.setAdapter(ItemAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String stringitem= ItemAdapter.getItem(position);
                Intent intent=new Intent(getActivity(), DetailActivity.class).putExtra(Intent.EXTRA_TEXT, stringitem);
                startActivity(intent);
            }
        });
        return rootview;

    }


}
