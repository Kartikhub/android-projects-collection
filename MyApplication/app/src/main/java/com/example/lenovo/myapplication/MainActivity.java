package com.example.lenovo.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button login;
    EditText user;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button) findViewById(R.id.login);
        user= (EditText) findViewById(R.id.username);
        pass= (EditText) findViewById(R.id.password);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String username=user.getText().toString();
        String password=pass.getText().toString();
int x=password.length();

        if (!Objects.equals(username, "") && !Objects.equals(password, ""))
        {
            if(x>6)
            {
        Intent intent=new Intent(this, Main2Activity.class).putExtra(Intent.EXTRA_TEXT,"Welcome " +username+ " You have come in the VIRTUAL world");
        startActivity(intent);
        Toast.makeText(MainActivity.this, username+" "+password+" "+"clicked the button", Toast.LENGTH_SHORT).show();
            }
        else{
                Toast.makeText(MainActivity.this, "enter password with length greater than 6", Toast.LENGTH_SHORT).show();

        }

    }
        else{
            Toast.makeText(MainActivity.this, "Enter username/password", Toast.LENGTH_SHORT).show();
        }}

}