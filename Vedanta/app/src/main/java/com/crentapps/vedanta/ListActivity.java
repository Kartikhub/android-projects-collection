package com.crentapps.vedanta;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.mindorks.placeholderview.PlaceHolderView;

public class ListActivity extends AppCompatActivity {
private PlaceHolderView placeHolderView;
private Context mContext;
    private String youtube="www.youtube.com", Image_url;
    private String[] host, videoID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mContext=getApplicationContext();
        placeHolderView=findViewById(R.id.listholderview);
        placeHolderView.getBuilder()
                .setHasFixedSize(false)
                .setItemViewCacheSize(10)
                .setLayoutManager(new GridLayoutManager(this, 2));

        for(Profile profile : Utils.loadProfiles(this.getApplicationContext())){
            Image_url = profile.getImageUrl();
            host = Image_url.split("/", 4);
            if (host[2].equals(youtube)) {
                videoID = Image_url.split("v=", 2);
                Image_url = "http://i3.ytimg.com/vi/" + videoID[1] + "/maxresdefault.jpg";
                profile.setImageUrl(Image_url);

            }
            placeHolderView.addView(new ListCard(mContext, profile));
        }

    }
}
