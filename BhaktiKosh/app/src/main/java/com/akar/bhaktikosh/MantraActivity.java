package com.akar.bhaktikosh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;



public class MantraActivity extends AppCompatActivity {
TextView textView;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mantra);


        textView= (TextView) findViewById(R.id.textmantra);
        Intent intent=getIntent();
        String mantra=intent.getStringExtra("MantraString");
        setTitle(intent.getStringExtra("MantraTitile"));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.mantra_action);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        textView.setText(mantra);
    }
}
