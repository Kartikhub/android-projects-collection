package com.akar.bhaktikosh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class ChalisaActivity extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chalisa);

        textView=(TextView) findViewById(R.id.textchalisa);

        Intent intent=getIntent();
        String chalisa=intent.getStringExtra("ChalisaString");
        setTitle(intent.getStringExtra("ChalisaTitile"));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.chalisa_action);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
textView.setText(chalisa);
    }
}
