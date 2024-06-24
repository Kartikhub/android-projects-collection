package com.crentapps.vedanta;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.hussain_chachuliya.snappy.Snappy;

import java.lang.reflect.Array;
import java.net.URL;

public class WebInfo extends AppCompatActivity {
    private WebView mWebView;
    private ProgressBar progressBar;
    private TextView textView;
    FrameLayout frameLayout;
    Snappy snappy;
    private String[] host;
    private  Integer[] colorArray;
    private ImageView imageViewtool;
    android.support.v7.widget.Toolbar toolbar;
    private Intent intent;
    private FloatingActionButton FAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_info);
        mWebView=findViewById(R.id.activity_main_webview);
        imageViewtool =findViewById(R.id.imagetool);
        toolbar =findViewById(R.id.my_toolbar);
        textView =findViewById(R.id.tooltext);
        frameLayout=findViewById(R.id.frame_layout);
        progressBar=findViewById(R.id.pbar);
        FAB=findViewById(R.id.fab);
        //backpressed code start
        imageViewtool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebInfo.super.onBackPressed();

            }
        });
         // end

        setSupportActionBar(toolbar);

        //toolbar color change code start
        colorArray =new Integer[]{R.color.colorPrimaryDark, R.color.colorPrimary, R.color.color1,
                R.color.color2, R.color.color3,R.color.color4,R.color.color5,R.color.color6,R.color.color7};
        snappy= new Snappy(this, colorArray);
        snappy.setDuration(500);
        snappy.startBreathing(toolbar);
        //end


        //FAB start
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //FAB end
        //progressbar and webview code start
        progressBar.setVisibility(View.GONE);
       progressBar.setMax(100);

        WebSettings webSettings=mWebView.getSettings();
        MyWebViewClient myWebViewClient= new MyWebViewClient();
        mWebView.setWebViewClient(myWebViewClient );
        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                frameLayout.setVisibility(View.VISIBLE);
                progressBar.setProgress(newProgress);
                if (newProgress == 100){
                    frameLayout.setVisibility(View.GONE);
                }
                super.onProgressChanged(view, newProgress);
            }
        });

        webSettings.setJavaScriptEnabled(true);
        intent =getIntent();
        mWebView.loadUrl(intent.getStringExtra("Url"));
        progressBar.setProgress(0);


    }

    private class MyWebViewClient extends WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return false;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            progressBar.setVisibility(View.VISIBLE );
            textView.setText("Loading...");
            super.onPageStarted(view, url, favicon);
            }

        @Override
        public void onPageFinished(WebView view, String url) {
            snappy.stopBreathing(toolbar);
            host = mWebView.getUrl().split("/", 4);
            textView.setText(host[2]);
            textView.setTextColor(getResources().getColor(R.color.colorB));
            super.onPageFinished(view, url);
        }
    }

    //end
}
