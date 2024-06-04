package com.example.lenovo.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity  {
TextView show;
    Button Set;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBar();
        setContentView(R.layout.activity_main2);
        show= (TextView) findViewById(R.id.show);
        Intent intent=this.getIntent();
        String str=intent.getStringExtra(intent.EXTRA_TEXT);
        show.setText(str);

    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Item");
            actionBar.setSubtitle("frame");
        }

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        switch (id){
            case R.id.settings_icon:
                startActivity(new Intent(this, SettingsActivity.class));
                break;
            case  R.id.edit:
                Toast.makeText(Main2Activity.this, "Edit was clicked", Toast.LENGTH_SHORT).show();
                break;
            case  R.id.delete:
                Toast.makeText(Main2Activity.this, "Delete was clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    }
