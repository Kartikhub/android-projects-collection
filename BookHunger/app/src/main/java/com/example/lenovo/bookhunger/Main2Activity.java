package com.example.lenovo.bookhunger;

import android.animation.Animator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {
private RecyclerView mrecview;
    private RecyclerView.Adapter madapter;
    private RecyclerView.LayoutManager mManager;
    private String[] myDataset;
    private Button btn;
    private ImageView ani;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn= (Button) findViewById(R.id.animbtn);
        ani= (ImageView) findViewById(R.id.col);
        ani.setVisibility(View.INVISIBLE);

btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        int cx=ani.getWidth();
        int cy=ani.getHeight();
        int finrad=Math.max(ani.getWidth(), ani.getHeight());

        final Animator animator= ViewAnimationUtils.createCircularReveal(ani, cx, cy,0, finrad);
        ani.setVisibility(View.VISIBLE);

        animator.start();

    }
});
    mrecview = (RecyclerView) findViewById(R.id.recview);
        mrecview.setHasFixedSize(true);
        mManager = new LinearLayoutManager(this);
        mrecview.setLayoutManager(mManager);
         myDataset= new String[]{"avvv", "assddd","adsdd"};
        madapter = new MyAdapter(myDataset);
        mrecview.setAdapter(madapter);
    }
}
