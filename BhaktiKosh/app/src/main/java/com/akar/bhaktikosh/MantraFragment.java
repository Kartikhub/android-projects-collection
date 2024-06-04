package com.akar.bhaktikosh;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
/**
 * A simple {@link Fragment} subclass.
 */
public class MantraFragment extends android.app.Fragment implements View.OnClickListener {
CardView card1,card2, card3;
    ImageView img1,img2,img3;


    public static MantraFragment newInstance() {
        // Required empty public constructor
        return new MantraFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_mantra, container, false);
        card1=(CardView) view.findViewById(R.id.cardm1);
        card2=(CardView) view.findViewById(R.id.cardm2);
        card3=(CardView) view.findViewById(R.id.cardm3);
        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);

        img1=(ImageView) view.findViewById(R.id.m1);
        img2=(ImageView) view.findViewById(R.id.m2);
        img3=(ImageView) view.findViewById(R.id.m3);

        Glide.with(this).load(R.drawable.mantrap1).into(img1);
        Glide.with(this).load(R.drawable.mantrap2).into(img2);
        Glide.with(this).load(R.drawable.mantrap3).into(img3);


        return  view;
    }

    @Override
    public void onClick(View view) {
        int i =view.getId();
        String aarti;
        Intent intent=new Intent(getActivity(), MantraActivity.class);

        switch (i){
            case R.id.cardm1:
                aarti=getResources().getString(R.string.mantran1);
                intent.putExtra("MantraTitile", getResources().getString(R.string.mantra1));
                intent.putExtra("MantraString", aarti);
                startActivity(intent);
                break;
            case R.id.cardm2:
                aarti=getResources().getString(R.string.mantran2);
                intent.putExtra("MantraTitile", getResources().getString(R.string.mantra2));
                intent.putExtra("MantraString", aarti);
                startActivity(intent);
                break;
            case R.id.cardm3:
                aarti=getResources().getString(R.string.mantran3);
                intent.putExtra("MantraTitile", getResources().getString(R.string.mantra3));
                intent.putExtra("MantraString", aarti);
                startActivity(intent);
                break;

        }}
}
