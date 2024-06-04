package com.akar.bhaktikosh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class AartiActivity extends AppCompatActivity {
TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aarti);
        textView=(TextView) findViewById(R.id.textaarti);

        Intent intent=getIntent();
        String aarti=intent.getStringExtra("AartiString");
        setTitle(intent.getStringExtra("AartiTitile"));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.aarti_action);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        textView.setText(aarti);

    }
}
