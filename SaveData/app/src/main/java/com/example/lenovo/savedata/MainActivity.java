package com.example.lenovo.savedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
private final static String STORETEXT="storeext.txt";
    private EditText txtEditor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
Button open= (Button) findViewById(R.id.sqlmain);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SqlMainActivity.class));

            }
        });
        txtEditor= (EditText) findViewById(R.id.textbox);

    }




    public void saveClicked(View v){
        try {
            OutputStreamWriter out=new OutputStreamWriter(openFileOutput(STORETEXT, 0));
            out.write(txtEditor.getText().toString());
            Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
            out.close();
            startActivity(new Intent(this, Main2Activity.class));

        } catch (Throwable e) {
            Toast.makeText(MainActivity.this, "Exception: "+e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
