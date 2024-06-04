package com.example.lenovo.savedata;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.lenovo.savedata.model.ProjectsDatabaseHelper;
import com.example.lenovo.savedata.model.RowCounter;

import java.util.ArrayList;

public class SqlRowCounterAdapter extends ArrayAdapter<RowCounter> {
private int mLayoutResourceId;
    private ArrayList<RowCounter> mData;
    public SqlRowCounterAdapter(Context context, int LayoutResourceId,ArrayList<RowCounter> data) {

        super(context, LayoutResourceId, data);
        mLayoutResourceId=LayoutResourceId;
        mData=data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater= (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(mLayoutResourceId,parent,false);
        }
        RowCounter currentRowCounter=mData.get(position);
        TextView rowCounterNameView= (TextView) convertView.findViewById(R.id.row_counter_name);
        rowCounterNameView.setText("#"+ String.valueOf(position + 1));
        TextView rowCounterValueView= (TextView) convertView.findViewById(R.id.row_counter_value);
        rowCounterValueView.setText(currentRowCounter.toString());
        Button removeButon= (Button) convertView.findViewById(R.id.row_counter_remove);
        removeButon.setTag(currentRowCounter);
        removeButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RowCounter clickedRowCounter= (RowCounter) v.getTag();
                clickedRowCounter.removeOneRow();
                TextView parentView = (TextView) ((View)v.getParent()).findViewById(R.id.row_counter_value);
                parentView.setText(clickedRowCounter.toString());
            }
        });
        Button addButon= (Button) convertView.findViewById(R.id.row_counter_add);
        addButon.setTag(currentRowCounter);
        addButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RowCounter clickedRowCounter= (RowCounter) v.getTag();
                clickedRowCounter.addOneRow();
                TextView parentView = (TextView) ((View)v.getParent()).findViewById(R.id.row_counter_value);
                parentView.setText(clickedRowCounter.toString());
            }
        });
        Button deleteButon= (Button) convertView.findViewById(R.id.row_counter_delete);
        deleteButon.setTag(position);
        deleteButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int clickedPosition= (int) v.getTag();
                RowCounter clickedRowCounter=mData.get(clickedPosition);
                ProjectsDatabaseHelper database=new ProjectsDatabaseHelper(getContext());
                database.deleteRowCounter(clickedRowCounter);
                mData.remove(clickedPosition);
                notifyDataSetChanged();
                }
        });

        return (convertView);
    }
}
