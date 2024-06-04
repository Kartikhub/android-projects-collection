package com.example.lenovo.savedata;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SqlCounterViewActivity extends LinearLayout {
private int mCoiunterValue=1;

    public SqlCounterViewActivity(Context context) {
        super(context);
initializeViews(context);
    }
    public SqlCounterViewActivity(Context context, AttributeSet attrs){
        super(context, attrs);
        initializeViews(context);
    }
    public SqlCounterViewActivity(Context context, AttributeSet attrs,int defStyle){
        super(context, attrs);
        initializeViews(context);
    }
    public int getValue(){
        return mCoiunterValue;
    }

    private void initializeViews(Context context) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.activity_sql_counter_view,this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Button removeButton= (Button) this.findViewById(R.id.counter_view_remove);
        removeButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mCoiunterValue++;
                refreshCounterValueView();
            }
        });
    }

    private void refreshCounterValueView() {
        TextView valueView= (TextView) this.findViewById(R.id.counter_view_value);
        valueView.setText(String.valueOf(mCoiunterValue));
    }
    public void setValue(int counterValue){
        mCoiunterValue=counterValue;
        refreshCounterValueView();
    }
}
