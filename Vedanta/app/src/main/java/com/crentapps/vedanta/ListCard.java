package com.crentapps.vedanta;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

@Layout(R.layout.list_card)
public class ListCard {

    @View(R.id.profilelistImageView)
    public ImageView profileImageView;

    @View(R.id.listnameAgeTxt)
    public TextView nameAgeTxt;

    @View(R.id.listlocationNameTxt)
    public TextView locationNameTxt;

    public Profile mProfile;
    public Context mContext;

    public ListCard(Context context, Profile profile) {
        mContext = context;
        mProfile = profile;
    }
    @Resolve
    public void onResolved(){
        Glide.with(mContext).load(mProfile.getImageUrl()).into(profileImageView);
        nameAgeTxt.setText(mProfile.getName() + ", " + mProfile.getAge());
        locationNameTxt.setText(mProfile.getLocation());
    }

    @Click(R.id.listCard)
    public void OnClick(){
        Log.d("EVENT", "ClickClick"+mProfile.getName());
        Toast.makeText(mContext, "fgtrClick", Toast.LENGTH_SHORT).show();
    }
}
