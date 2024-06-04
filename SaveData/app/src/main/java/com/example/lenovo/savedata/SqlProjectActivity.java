package com.example.lenovo.savedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lenovo.savedata.model.Project;
import com.example.lenovo.savedata.model.ProjectsDatabaseHelper;
import com.example.lenovo.savedata.model.RowCounter;

import java.util.ArrayList;

public class SqlProjectActivity extends AppCompatActivity {
private ArrayList<RowCounter> mRowCounters;
    @Override
                            protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_project);
        Intent intent=getIntent();
        long project_id=intent.getLongExtra("project_id",-1);
        ProjectsDatabaseHelper database= new ProjectsDatabaseHelper(this);
        Project currentProject=database.getProject(project_id);
        TextView projectNameView= (TextView) findViewById(R.id.project_name);
        projectNameView.setText(currentProject.getName());
        ListView rowCounterList= (ListView) findViewById(R.id.row_counters_list);
        mRowCounters=currentProject.getRowCounters();
        ListAdapter rowCounterListAdapter=new SqlRowCounterAdapter(this, R.layout.activity_sql_row_counter_row,currentProject.getRowCounters());
    rowCounterList.setAdapter(rowCounterListAdapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        ProjectsDatabaseHelper database=new ProjectsDatabaseHelper(this);
        for (RowCounter rowCounter:mRowCounters){
            database.updateRowCounterCurrentAmount(rowCounter);
        }
    }
}
