package com.example.lenovo.vision;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Team extends AppCompatActivity {
    ListView team;
    Intent callintent;
    ArrayAdapter<String> adapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        team = (ListView) findViewById(R.id.teamList);
        List<String> listTeam = new ArrayList<String>();

        listTeam.add("Harshit agrawal\n(Mining Engg.)");
        listTeam.add("Kartik Sharma\n(Civil Engg.)");
        listTeam.add("Karan Singh Shekhawat\n(EEE)");
        listTeam.add("Kunal Kandhari\n(Electrical Engg.)");
        listTeam.add("Divyanshu Gupta\n(ECC)");
        listTeam.add("Harshit Mishra\n(Mechanical Engg.)");
        listTeam.add("Kuldeep Nagar\n(EEE)");
        listTeam.add("Naveen Singhal\n(ECE)");
        listTeam.add("Balkrishna Attal\n(Civil Engg.)");
        listTeam.add("Vipul Chaurasia\n(I.T.)");
        listTeam.add("Adarsh Sharma\n(Mechanical Engg.)");
        listTeam.add("Shivdan Singh Rathore\n(Mining Engg.)");
        listTeam.add("Piyush Roat\n(Civil Engg.)");
        listTeam.add("Puspak Mangal\n(EEE)");
        listTeam.add("Jayesh Singhvi\n(Chemical Engg.)");


        adapt = new ArrayAdapter<String>(this, R.layout.listlayout, R.id.textl, listTeam);
        team.setAdapter(adapt);
        team.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        callintent=new Intent(Intent.ACTION_DIAL);
                        callintent.setData(Uri.parse("tel:7597764352"));
                        startActivity(callintent);
break;
                    case 1:
                        callintent=new Intent(Intent.ACTION_DIAL);
                        callintent.setData(Uri.parse("tel:9024935315"));
                        startActivity(callintent);
                        break;
                    case 2:
                        callintent=new Intent(Intent.ACTION_DIAL);
                        callintent.setData(Uri.parse("tel:7742086430"));
                        startActivity(callintent);
                        break;
                    case 3:
                        callintent=new Intent(Intent.ACTION_DIAL);
                        callintent.setData(Uri.parse("tel:8504815027"));
                        startActivity(callintent);
                        break;
                    case 4:
                        callintent=new Intent(Intent.ACTION_DIAL);
                        callintent.setData(Uri.parse("tel:9024481821"));
                        startActivity(callintent);
                        break;
                    case 5:
                        callintent=new Intent(Intent.ACTION_DIAL);
                        callintent.setData(Uri.parse("tel:9571498386"));
                        startActivity(callintent);
                        break;
                    case 6:
                        callintent=new Intent(Intent.ACTION_DIAL);
                        callintent.setData(Uri.parse("tel:7610942778"));
                        startActivity(callintent);
                        break;
                    case 7:
                        callintent=new Intent(Intent.ACTION_DIAL);
                        callintent.setData(Uri.parse("tel:8696178135"));
                        startActivity(callintent);
                        break;
                    case 8:
                        callintent=new Intent(Intent.ACTION_DIAL);
                        callintent.setData(Uri.parse("tel:7737781426"));
                        startActivity(callintent);
                        break;
                    case 9:
                        callintent=new Intent(Intent.ACTION_DIAL);
                        callintent.setData(Uri.parse("tel:8560018230"));
                        startActivity(callintent);
                        break;
                    case 10:
                        callintent=new Intent(Intent.ACTION_DIAL);
                        callintent.setData(Uri.parse("tel:7733870721"));
                        startActivity(callintent);
                        break;
                    case 11:
                        callintent=new Intent(Intent.ACTION_DIAL);
                        callintent.setData(Uri.parse("tel:9785529832"));
                        startActivity(callintent);
                        break;
                    case 12:
                        callintent=new Intent(Intent.ACTION_DIAL);
                        callintent.setData(Uri.parse("tel:9610946898"));
                        startActivity(callintent);
                        break;
                    case 13:
                        callintent=new Intent(Intent.ACTION_DIAL);
                        callintent.setData(Uri.parse("tel:9024410432"));
                        startActivity(callintent);
                        break;
                    case 14:
                        callintent=new Intent(Intent.ACTION_DIAL);
                        callintent.setData(Uri.parse("tel:7733935874"));
                        startActivity(callintent);
                        break;
                }
            }
        });
    }
}
