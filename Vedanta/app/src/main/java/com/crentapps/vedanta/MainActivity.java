package com.crentapps.vedanta;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

public class MainActivity extends AppCompatActivity implements SwipeCardCallback{
    private SwipePlaceHolderView mSwipeView;
    private Context mContext;
    private String youtube="www.youtube.com", Image_url;
    private String[] host, videoID;
    private VedantCard vedantCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //snackbar
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwipeView = findViewById(R.id.swipeView);
        mContext = getApplicationContext();

        mSwipeView.getBuilder().setSwipeType(SwipePlaceHolderView.SWIPE_TYPE_HORIZONTAL).setIsUndoEnabled(true).setDisplayViewCount(6).setSwipeDecor(new SwipeDecor().setPaddingTop(-20).setRelativeScale(0.01f)
                .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in_msg_view)
                .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out_msg_view));

        for(Profile profile : Utils.loadProfiles(this.getApplicationContext())) {
            Image_url = profile.getImageUrl();
            host = Image_url.split("/", 4);
            if (host[2].equals(youtube)) {
                videoID = Image_url.split("v=", 2);
                Image_url = "http://i3.ytimg.com/vi/" + videoID[1] + "/maxresdefault.jpg";
                profile.setImageUrl(Image_url);
            }
            mSwipeView.addView(new VedantCard(mContext, profile, mSwipeView));
        }


        findViewById(R.id.rejectBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSwipeView.doSwipe(false);
            }
        });

        findViewById(R.id.acceptBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSwipeView.doSwipe(true);
            }
        });
        findViewById(R.id.listOpenBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListActivity.class));
            }
        });

    }


    @Override
    public void onSwipeIn() {

    }

    @Override
    public void onSwipeOut() {

    }
}
