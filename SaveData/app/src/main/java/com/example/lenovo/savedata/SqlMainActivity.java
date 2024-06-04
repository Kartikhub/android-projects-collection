package com.example.lenovo.savedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.lenovo.savedata.model.Project;
import com.example.lenovo.savedata.model.ProjectsDatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class SqlMainActivity extends AppCompatActivity {
private ListView mListView;
    private ArrayList<Project> mProjects;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_main);
        Button createProjectActivityButton= (Button) findViewById(R.id.create_project_activity_button);
        createProjectActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createProjectIntent=new Intent(SqlMainActivity.this, SqlCreateProjectActivity.class);
                SqlMainActivity.this.startActivity(createProjectIntent);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        ProjectsDatabaseHelper database= new ProjectsDatabaseHelper(this);
        mProjects=database.getProjects();
        List<String> listViewValues= new ArrayList<String>();
        for (Project currentProject:mProjects){
            listViewValues.add(currentProject.getName());
        }
        mListView= (ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, listViewValues.toArray(new String[listViewValues.size()]));
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Project project=mProjects.get(position);
                Intent projectIntent= new Intent(SqlMainActivity.this, SqlProjectActivity.class);
                projectIntent.putExtra("project_id", project.getId());
                SqlMainActivity.this.startActivity(projectIntent);
            }
        });
    }
}
