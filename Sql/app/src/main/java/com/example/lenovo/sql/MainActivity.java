package com.example.lenovo.sql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
private EditText username;
   private String gender;
    private ArrayAdapter<String> adapt;
    private ListView list;
    private boolean listshow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listshow=false;
        username= (EditText) findViewById(R.id.name);
        Button create= (Button) findViewById(R.id.create_profile);
        final Button show= (Button) findViewById(R.id.show_profiles);
        final RadioGroup gend= (RadioGroup) findViewById(R.id.gender);
        final SqlFirstHelper db=new SqlFirstHelper(this);
         list= (ListView) findViewById(R.id.listprofiles);
        final List<Profile> profiles=db.getprofiles();
        final List<String> listprofs=new ArrayList<String>();
        for(Profile profile:profiles){
            listprofs.add(profile.getName());
        }

        adapt=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1, listprofs);
        list.setAdapter(adapt);
        gend.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id=group.getCheckedRadioButtonId();
                switch (id){
                    case R.id.male:
                        gender="Male";
                        break;
                    case R.id.female:
                        gender="Female";
                        break;
                }
            }
        });
create.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        db.createProfile(username.getText().toString(), gender);
        Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
        adapt.clear();
        profiles.clear();
        profiles.addAll(db.getprofiles());
        for(Profile profile:profiles){
            listprofs.add(profile.getName());
        }

        adapt.notifyDataSetChanged();


    }

});
        show.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (!listshow) {
                    list.setVisibility(View.VISIBLE);
                    listshow=true;
                    adapt.notifyDataSetChanged();
                } else {
list.setVisibility(View.GONE);
                    listshow=false;
                }
            }
        });

list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
String str=adapt.getItem(position);
        db.deleteprofile(db.getProfile(str));
        adapt.clear();
        profiles.clear();
        profiles.addAll(db.getprofiles());
        for(Profile profile:profiles){
            listprofs.add(profile.getName());
        }

        adapt.notifyDataSetChanged();

    }
});
    }




}
