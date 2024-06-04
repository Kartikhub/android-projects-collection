package com.akar.check;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
String x="asd",y="dfdf",z="gsfdfhi";
    public String qwert;
    Button btn;
    TextView textView;
    HashMap<String, String> hashMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= (TextView) findViewById(R.id.txt);
        btn= (Button) findViewById(R.id.ab);
        hashMap=new HashMap<>();
        hashMap.put("abc", x);
        hashMap.put("def", y);
        hashMap.put("ghi", z);
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        for(Map.Entry<String, String> key:hashMap.entrySet()){
            String ky = key.getKey();
            String value = key.getValue();
            if (ky=="abc"){
                qwert=value;
            }
        }
        textView.setText(qwert);

    }
});

    }
}
