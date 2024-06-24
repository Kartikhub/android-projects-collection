package com.crentapps.vedanta;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Position;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;
import com.mindorks.placeholderview.listeners.ItemRemovedListener;

import java.net.MalformedURLException;
import java.net.URL;

import javax.security.auth.callback.Callback;


@Layout(R.layout.tinder_card_view)
public class VedantCard {


    @View(R.id.profileImageView)
    public ImageView profileImageView;

    @View(R.id.nameAgeTxt)
    public TextView nameAgeTxt;

    @View(R.id.locationNameTxt)
    public TextView locationNameTxt;

    public Profile mProfile;
    public Context mContext;
    public SwipePlaceHolderView mSwipeView;
    public SwipeCardCallback mSwipeCardCallback;


    public VedantCard(Context context, Profile profile, SwipePlaceHolderView swipeView) {
        mContext = context;
        mProfile = profile;
        mSwipeView = swipeView;
        this.mSwipeCardCallback= (SwipeCardCallback) context;

    }




    @Resolve
    public void onResolved() {
        Glide.with(mContext).load(mProfile.getImageUrl()).into(profileImageView);
        nameAgeTxt.setText(mProfile.getName() + ", " + mProfile.getAge());
        locationNameTxt.setText(mProfile.getLocation());

    }





    @SwipeOut
    public void onSwipedOut() {

        Toast.makeText(mContext, mProfile.getName(), Toast.LENGTH_SHORT).show();

        Log.d("EVENT", "onSwipedOut");


    }


    @SwipeCancelState
    public void onSwipeCancelState(){
        Log.d("EVENT", "onSwipeCancelState");
    }    @SwipeIn
    public void onSwipeIn(){
        Log.d("EVENT", "onSwipedIn");
    }

    @SwipeInState
    public void onSwipeInState(){
        Log.d("EVENT", "onSwipeInState");
    }

    @SwipeOutState
    public void onSwipeOutState(){
        Log.d("EVENT", "onSwipeOutState");
    }

    @Click(R.id.tinderCard)
    public void OnWebClick(){
        Intent intent;
        Log.d("EVENT", "ClickClick"+mProfile.getName());
        intent =new Intent(this.mContext, WebInfo.class);
        intent.putExtra("Url", mProfile.getImageUrl());
        mContext.startActivity(intent);
        }
}
