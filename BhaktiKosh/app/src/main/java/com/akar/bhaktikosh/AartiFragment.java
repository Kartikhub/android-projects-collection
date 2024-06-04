package com.akar.bhaktikosh;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

/**
 * A simple {@link Fragment} subclass.
 */
public class AartiFragment extends android.app.Fragment implements View.OnClickListener {
    CardView card1,card2,card3,card4,card5,card6,card7,card8,card9,card10,card11,card12,card13,card14,card15;
    ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15;



  public static AartiFragment newInstance(){
      return new AartiFragment();
  }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_aarti, container, false);


        card1=(CardView) view.findViewById(R.id.carda1);
        card2=(CardView) view.findViewById(R.id.carda2);
        card3=(CardView) view.findViewById(R.id.carda3);
        card4=(CardView) view.findViewById(R.id.carda4);
        card5=(CardView) view.findViewById(R.id.carda5);
        card6=(CardView) view.findViewById(R.id.carda6);
        card7=(CardView) view.findViewById(R.id.carda7);
        card8=(CardView) view.findViewById(R.id.carda8);
        card9=(CardView) view.findViewById(R.id.carda9);
        card10=(CardView) view.findViewById(R.id.carda10);
        card11=(CardView) view.findViewById(R.id.carda11);
        card12=(CardView) view.findViewById(R.id.carda12);
        card13=(CardView) view.findViewById(R.id.carda13);
        card14=(CardView) view.findViewById(R.id.carda14);
        card15=(CardView) view.findViewById(R.id.carda15);
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

        img1=(ImageView) view.findViewById(R.id.a1);
        img2=(ImageView) view.findViewById(R.id.a2);
        img3=(ImageView) view.findViewById(R.id.a3);
        img4=(ImageView) view.findViewById(R.id.a4);
        img5=(ImageView) view.findViewById(R.id.a5);
        img6=(ImageView) view.findViewById(R.id.a6);
        img7=(ImageView) view.findViewById(R.id.a7);
        img8=(ImageView) view.findViewById(R.id.a8);
        img9=(ImageView) view.findViewById(R.id.a9);
        img10=(ImageView) view.findViewById(R.id.a10);
        img11=(ImageView) view.findViewById(R.id.a11);
        img12=(ImageView) view.findViewById(R.id.a12);
        img13=(ImageView) view.findViewById(R.id.a13);
        img14=(ImageView) view.findViewById(R.id.a14);
        img15=(ImageView) view.findViewById(R.id.a15);

        Glide.with(this).load(R.drawable.aartip1).into(img1);
        Glide.with(this).load(R.drawable.aartip2).into(img2);
        Glide.with(this).load(R.drawable.aartip3).into(img3);
        Glide.with(this).load(R.drawable.aartip4).into(img4);
        Glide.with(this).load(R.drawable.aartip5).into(img5);
        Glide.with(this).load(R.drawable.aartip6).into(img6);
        Glide.with(this).load(R.drawable.aartip7).into(img7);
        Glide.with(this).load(R.drawable.aartip8).into(img8);
        Glide.with(this).load(R.drawable.aartip9).into(img9);
        Glide.with(this).load(R.drawable.aartip10).into(img10);
        Glide.with(this).load(R.drawable.aartip11).into(img11);
        Glide.with(this).load(R.drawable.aartip12).into(img12);
        Glide.with(this).load(R.drawable.aartip13).into(img13);
        Glide.with(this).load(R.drawable.aartip14).into(img14);
        Glide.with(this).load(R.drawable.aartip15).into(img15);

        return view;
    }

    @Override
    public void onClick(View view) {
        int i =view.getId();
        String aarti;
        Intent intent=new Intent(getActivity(), AartiActivity.class);

        switch (i){
            case R.id.carda1:
                aarti=getResources().getString(R.string.aartin1);
                intent.putExtra("AartiTitile", getResources().getString(R.string.aarti1));
                intent.putExtra("AartiString", aarti);
                startActivity(intent);
                break;
            case R.id.carda2:
                aarti=getResources().getString(R.string.aartin2);
                intent.putExtra("AartiTitile", getResources().getString(R.string.aarti2));
                intent.putExtra("AartiString", aarti);
                startActivity(intent);
                break;

            case R.id.carda3:
                aarti=getResources().getString(R.string.aartin3);
                intent.putExtra("AartiTitile", getResources().getString(R.string.aarti3));
                intent.putExtra("AartiString", aarti);
                startActivity(intent);
                break;
            case R.id.carda4:
                aarti=getResources().getString(R.string.aartin4);
                intent.putExtra("AartiTitile", getResources().getString(R.string.aarti4));
                intent.putExtra("AartiString", aarti);
                startActivity(intent);
                break;
            case R.id.carda5:
                aarti=getResources().getString(R.string.aartin5);
                intent.putExtra("AartiTitile", getResources().getString(R.string.aarti5));
                intent.putExtra("AartiString", aarti);
                startActivity(intent);
                break;
            case R.id.carda6:
                aarti=getResources().getString(R.string.aartin6);
                intent.putExtra("AartiTitile", getResources().getString(R.string.aarti6));
                intent.putExtra("AartiString", aarti);
                startActivity(intent);
                break;
            case R.id.carda7:
                aarti=getResources().getString(R.string.aartin7);
                intent.putExtra("AartiTitile", getResources().getString(R.string.aarti7));
                intent.putExtra("AartiString", aarti);
                startActivity(intent);
                break;
            case R.id.carda8:
                aarti=getResources().getString(R.string.aartin8);
                intent.putExtra("AartiTitile", getResources().getString(R.string.aarti8));
                intent.putExtra("AartiString", aarti);
                startActivity(intent);
                break;
            case R.id.carda9:
                aarti=getResources().getString(R.string.aartin9);
                intent.putExtra("AartiTitile", getResources().getString(R.string.aarti9));
                intent.putExtra("AartiString", aarti);
                startActivity(intent);
                break;
            case R.id.carda10:
                aarti=getResources().getString(R.string.aartin10);
                intent.putExtra("AartiTitile", getResources().getString(R.string.aarti10));
                intent.putExtra("AartiString", aarti);
                startActivity(intent);
                break;
            case R.id.carda11:
                aarti=getResources().getString(R.string.aartin11);
                intent.putExtra("AartiTitile", getResources().getString(R.string.aarti11));
                intent.putExtra("AartiString", aarti);
                startActivity(intent);
                break;
            case R.id.carda12:
                aarti=getResources().getString(R.string.aartin12);
                intent.putExtra("AartiTitile", getResources().getString(R.string.aarti12));
                intent.putExtra("AartiString", aarti);
                startActivity(intent);
                break;
            case R.id.carda13:
                aarti=getResources().getString(R.string.aartin13);
                intent.putExtra("AartiTitile", getResources().getString(R.string.aarti13));
                intent.putExtra("AartiString", aarti);
                startActivity(intent);
                break;
            case R.id.carda14:
                aarti=getResources().getString(R.string.aartin14);
                intent.putExtra("AartiTitile", getResources().getString(R.string.aarti14));
                intent.putExtra("AartiString", aarti);
                startActivity(intent);
                break;
            case R.id.carda15:
                aarti=getResources().getString(R.string.aartin15);
                intent.putExtra("AartiTitile", getResources().getString(R.string.aarti15));
                intent.putExtra("AartiString", aarti);
                startActivity(intent);
                break;

        }

    }
}
