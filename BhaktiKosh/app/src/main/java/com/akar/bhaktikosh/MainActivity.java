package com.akar.bhaktikosh;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


           setTitle("Aarti");
           loadAarti();


           getSupportActionBar().setDisplayShowHomeEnabled(true);
           getSupportActionBar().setLogo(R.drawable.aarti_action);
           getSupportActionBar().setDisplayUseLogoEnabled(true);

           BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                   = new BottomNavigationView.OnNavigationItemSelectedListener() {

               @Override
               public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                   switch (item.getItemId()) {
                       case R.id.navigation_home:
                           setTitle("Aarti");
                           getSupportActionBar().setDisplayShowHomeEnabled(true);
                           getSupportActionBar().setLogo(R.drawable.aarti_action);
                           getSupportActionBar().setDisplayUseLogoEnabled(true);

                           loadAarti();
                           return true;
                       case R.id.navigation_dashboard:
                           setTitle("Chalisa");
                           getSupportActionBar().setDisplayShowHomeEnabled(true);
                           getSupportActionBar().setLogo(R.drawable.chalisa_action);
                           getSupportActionBar().setDisplayUseLogoEnabled(true);

                           loadChalisa();
                           return true;
                       case R.id.navigation_notifications:
                           setTitle("Mantra");
                           loadMantra();
                           getSupportActionBar().setDisplayShowHomeEnabled(true);
                           getSupportActionBar().setLogo(R.drawable.mantra_action);
                           getSupportActionBar().setDisplayUseLogoEnabled(true);

                           return true;
                   }
                   return false;
               }

           };

           BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
           navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

       }


    private void loadMantra() {
        MantraFragment fragment = MantraFragment.newInstance();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        //ft.setCustomAnimations(R.animator.enterleft,R.animator.exitleft, R.animator.enterright, R.animator.exitright);
        ft.setCustomAnimations(R.animator.fadein, R.animator.fadeout);
        ft.replace(R.id.content, fragment);
        ft.commit();

    }

    private void loadChalisa() {
        ChalisaFragment fragment = ChalisaFragment.newInstance();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        //ft.setCustomAnimations(R.animator.enterleft,R.animator.exitleft, R.animator.enterright, R.animator.exitright);
        ft.setCustomAnimations(R.animator.fadein, R.animator.fadeout);
        ft.replace(R.id.content, fragment);
        ft.commit();
    }

    private void loadAarti() {
        AartiFragment fragment = AartiFragment.newInstance();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        //ft.setCustomAnimations(R.animator.enterleft,R.animator.exitleft, R.animator.enterright, R.animator.exitright);
        ft.setCustomAnimations(R.animator.fadein, R.animator.fadeout);
        ft.replace(R.id.content, fragment, "FragmentName");
        ft.commit();
    }


}
