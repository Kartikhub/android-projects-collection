package com.bookhunger.bookhunger;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {
    private static int SPLASH_TIME_OUT =2000;

    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        img= (ImageView) findViewById(R.id.img);
        img.setBackgroundResource(R.drawable.anim);
        AnimationDrawable framanim= (AnimationDrawable) img.getBackground();
        framanim.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i= new Intent(Splash.this, Main_Activity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);

    }
    }


