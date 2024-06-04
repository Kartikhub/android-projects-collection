package com.example.lenovo.myapplication;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);
        getFragmentManager().beginTransaction().add(android.R.id.content, new DetailFrag()).commit();
        Intent intent = this.getIntent();
        getSupportActionBar().setTitle("Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       int id =item.getItemId();
        if(id == R.id.settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }return super.onOptionsItemSelected(item);
    }
    public static class DetailFrag extends android.app.Fragment {

        private static final String ITEM_SHARE_HASHTAG ="#First" ;
        private static final String LOG_TAG =DetailFrag.class.getSimpleName() ;
        private String mitemstr;

        public DetailFrag() {
            setHasOptionsMenu(true);
        }


        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootview = inflater.inflate(R.layout.detail_fragment, container, false);
            Intent intent = getActivity().getIntent();
            if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
                mitemstr = intent.getStringExtra(Intent.EXTRA_TEXT);
                TextView text = (TextView) rootview.findViewById(R.id.textView);
                text.setText(mitemstr);

            }
            return rootview;
        }

        @Override
        public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
            inflater.inflate(R.menu.detail_fragment, menu);
            MenuItem  menuItem= menu.findItem(R.id.Share);
            ShareActionProvider mAction= (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
            if(mAction != null){
                mAction.setShareIntent(createShareIntent());

            }else {
                Log.d(LOG_TAG, "Share Action Provider is null");
            }
        }

        private Intent createShareIntent() {
Intent shareintent=new Intent(Intent.ACTION_SEND);
      shareintent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
        shareintent.setType("text/plain");
        shareintent.putExtra(Intent.EXTRA_TEXT, mitemstr + ITEM_SHARE_HASHTAG);
        return shareintent;
    }
}}
