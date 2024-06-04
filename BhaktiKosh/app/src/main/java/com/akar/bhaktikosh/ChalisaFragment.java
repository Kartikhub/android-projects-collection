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
public class ChalisaFragment extends android.app.Fragment implements View.OnClickListener{
    CardView card1,card2,card3,card4,card5,card6,card7,card8,card9,card10,card11,card12,card13,card14,card15;
    ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15;


    public static ChalisaFragment newInstance() {
        return new ChalisaFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_chalisa, container, false);
        card1=(CardView) view.findViewById(R.id.cardc1);
        card2=(CardView) view.findViewById(R.id.cardc2);
        card3=(CardView) view.findViewById(R.id.cardc3);
        card4=(CardView) view.findViewById(R.id.cardc4);
        card5=(CardView) view.findViewById(R.id.cardc5);
        card6=(CardView) view.findViewById(R.id.cardc6);
        card7=(CardView) view.findViewById(R.id.cardc7);
        card8=(CardView) view.findViewById(R.id.cardc8);
        card9=(CardView) view.findViewById(R.id.cardc9);
        card10=(CardView) view.findViewById(R.id.cardc10);
        card11=(CardView) view.findViewById(R.id.cardc11);
        card12=(CardView) view.findViewById(R.id.cardc12);
        card13=(CardView) view.findViewById(R.id.cardc13);
        card14=(CardView) view.findViewById(R.id.cardc14);
        card15=(CardView) view.findViewById(R.id.cardc15);
        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);
        card7.setOnClickListener(this);
        card8.setOnClickListener(this);
        card9.setOnClickListener(this);
        card10.setOnClickListener(this);
        card11.setOnClickListener(this);
        card12.setOnClickListener(this);
        card13.setOnClickListener(this);
        card14.setOnClickListener(this);
        card15.setOnClickListener(this);

        img1=(ImageView) view.findViewById(R.id.c1);
        img2=(ImageView) view.findViewById(R.id.c2);
        img3=(ImageView) view.findViewById(R.id.c3);
        img4=(ImageView) view.findViewById(R.id.c4);
        img5=(ImageView) view.findViewById(R.id.c5);
        img6=(ImageView) view.findViewById(R.id.c6);
        img7=(ImageView) view.findViewById(R.id.c7);
        img8=(ImageView) view.findViewById(R.id.c8);
        img9=(ImageView) view.findViewById(R.id.c9);
        img10=(ImageView) view.findViewById(R.id.c10);
        img11=(ImageView) view.findViewById(R.id.c11);
        img12=(ImageView) view.findViewById(R.id.c12);
        img13=(ImageView) view.findViewById(R.id.c13);
        img14=(ImageView) view.findViewById(R.id.c14);
        img15=(ImageView) view.findViewById(R.id.c15);

        Glide.with(this).load(R.drawable.chalisap1).into(img1);
        Glide.with(this).load(R.drawable.chalisap2).into(img2);
        Glide.with(this).load(R.drawable.chalisap3).into(img3);
        Glide.with(this).load(R.drawable.chalisap4).into(img4);
        Glide.with(this).load(R.drawable.chalisap5).into(img5);
        Glide.with(this).load(R.drawable.chalisap6).into(img6);
        Glide.with(this).load(R.drawable.chalisap7).into(img7);
        Glide.with(this).load(R.drawable.chalisap8).into(img8);
        Glide.with(this).load(R.drawable.chalisap9).into(img9);
        Glide.with(this).load(R.drawable.chalisap10).into(img10);
        Glide.with(this).load(R.drawable.chalisap11).into(img11);
        Glide.with(this).load(R.drawable.chalisap12).into(img12);
        Glide.with(this).load(R.drawable.chalisap13).into(img13);
        Glide.with(this).load(R.drawable.chalisap14).into(img14);
        Glide.with(this).load(R.drawable.chalisap15).into(img15);

        return view;

    }

    @Override
    public void onClick(View view) {
        int i =view.getId();
        String aarti;
        Intent intent=new Intent(getActivity(), ChalisaActivity.class);

        switch (i){
            case R.id.cardc1:
                aarti=getResources().getString(R.string.chalisan1);
                intent.putExtra("ChalisaTitile", getResources().getString(R.string.chalisa1));
                intent.putExtra("ChalisaString", aarti);
                startActivity(intent);
                break;
            case R.id.cardc2:
                aarti=getResources().getString(R.string.chalisan2);
                intent.putExtra("ChalisaTitile", getResources().getString(R.string.chalisa2));
                intent.putExtra("ChalisaString", aarti);
                startActivity(intent);
                break;

            case R.id.cardc3:
                aarti=getResources().getString(R.string.chalisan3);
                intent.putExtra("ChalisaTitile", getResources().getString(R.string.chalisa3));
                intent.putExtra("ChalisaString", aarti);
                startActivity(intent);
                break;
            case R.id.cardc4:
                aarti=getResources().getString(R.string.chalisan4);
                intent.putExtra("ChalisaTitile", getResources().getString(R.string.chalisa4));
                intent.putExtra("ChalisaString", aarti);
                startActivity(intent);
                break;
            case R.id.cardc5:
                aarti=getResources().getString(R.string.chalisan5);
                intent.putExtra("ChalisaTitile", getResources().getString(R.string.chalisa5));
                intent.putExtra("ChalisaString", aarti);
                startActivity(intent);
                break;
            case R.id.cardc6:
                aarti=getResources().getString(R.string.chalisan6);
                intent.putExtra("ChalisaTitile", getResources().getString(R.string.chalisa6));
                intent.putExtra("ChalisaString", aarti);
                startActivity(intent);
                break;
            case R.id.cardc7:
                aarti=getResources().getString(R.string.chalisan7);
                intent.putExtra("ChalisaTitile", getResources().getString(R.string.chalisa7));
                intent.putExtra("ChalisaString", aarti);
                startActivity(intent);
                break;
            case R.id.cardc8:
                aarti=getResources().getString(R.string.chalisan8);
                intent.putExtra("ChalisaTitile", getResources().getString(R.string.chalisa8));
                intent.putExtra("ChalisaString", aarti);
                startActivity(intent);
                break;
            case R.id.cardc9:
                aarti=getResources().getString(R.string.chalisan9);
                intent.putExtra("ChalisaTitile", getResources().getString(R.string.chalisa9));
                intent.putExtra("ChalisaString", aarti);
                startActivity(intent);
                break;
            case R.id.cardc10:
                aarti=getResources().getString(R.string.chalisan10);
                intent.putExtra("ChalisaTitile", getResources().getString(R.string.chalisa10));
                intent.putExtra("ChalisaString", aarti);
                startActivity(intent);
                break;
            case R.id.cardc11:
                aarti=getResources().getString(R.string.chalisan11);
                intent.putExtra("ChalisaTitile", getResources().getString(R.string.chalisa11));
                intent.putExtra("ChalisaString", aarti);
                startActivity(intent);
                break;
            case R.id.cardc12:
                aarti=getResources().getString(R.string.chalisan12);
                intent.putExtra("ChalisaTitile", getResources().getString(R.string.chalisa12));
                intent.putExtra("ChalisaString", aarti);
                startActivity(intent);
                break;
            case R.id.cardc13:
                aarti=getResources().getString(R.string.chalisan13);
                intent.putExtra("ChalisaTitile", getResources().getString(R.string.chalisa13));
                intent.putExtra("ChalisaString", aarti);
                startActivity(intent);
                break;
            case R.id.cardc14:
                aarti=getResources().getString(R.string.chalisan14);
                intent.putExtra("ChalisaTitile", getResources().getString(R.string.chalisa14));
                intent.putExtra("ChalisaString", aarti);
                startActivity(intent);
                break;
            case R.id.cardc15:
                aarti=getResources().getString(R.string.chalisan15);
                intent.putExtra("ChalisaTitile", getResources().getString(R.string.chalisa15));
                intent.putExtra("ChalisaString", aarti);
                startActivity(intent);
                break;

        }


    }
}
