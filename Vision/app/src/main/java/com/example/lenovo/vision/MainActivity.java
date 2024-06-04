package com.example.lenovo.vision;

import android.content.Intent;
import android.media.audiofx.BassBoost;
import android.media.audiofx.EnvironmentalReverb;
import android.provider.Settings;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.team, menu);
    return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.team:
                startActivity(new Intent(MainActivity.this, Team.class));
        break;
            case R.id.about:
                startActivity(new Intent(MainActivity.this, About.class));
                break;
            case R.id.next:
                startActivity(new Intent(MainActivity.this, Next.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
