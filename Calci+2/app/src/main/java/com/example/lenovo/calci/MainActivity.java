package com.example.lenovo.calci;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.TtsSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
private TextView cal;
    private ViewGroup set,hiddenPanel;
    private boolean isPanelShown;

    private String x,y,z;
    private StringBuilder builder=new StringBuilder();
private TextView rem;
   private String str,str2;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       hiddenPanel= (ViewGroup) findViewById(R.id.hid);
       set= (ViewGroup) findViewById(R.id.set);
       isPanelShown=false;
       rem= (TextView) findViewById(R.id.shortrem);
       cal= (TextView) findViewById(R.id.calculation);
       Button down= (Button) findViewById(R.id._down);
       Button C2= (Button) findViewById(R.id._C2);
       Button integrate= (Button) findViewById(R.id._integrate);
       Button Del= (Button) findViewById(R.id._del2);
       Button pow= (Button) findViewById(R.id._pow);
       Button sin= (Button) findViewById(R.id._sin);
       Button cos= (Button) findViewById(R.id._cos);
       Button tan= (Button) findViewById(R.id._tan);
       Button log= (Button) findViewById(R.id._log);
       Button ln= (Button) findViewById(R.id._ln);
       Button pie= (Button) findViewById(R.id._pie);
       Button e= (Button) findViewById(R.id._e);;
       Button fact= (Button) findViewById(R.id._fact);
       Button braco= (Button) findViewById(R.id._bracOpen);
       Button bracc= (Button) findViewById(R.id._bracClose);
       C2.setOnClickListener(this);
       integrate.setOnClickListener(this);
       Del.setOnClickListener(this);
       pow.setOnClickListener(this);
       sin.setOnClickListener(this);
       cos.setOnClickListener(this);
       tan.setOnClickListener(this);
       log.setOnClickListener(this);
       ln.setOnClickListener(this);
       pie.setOnClickListener(this);
       e.setOnClickListener(this);
       fact.setOnClickListener(this);
       braco.setOnClickListener(this);
       bracc.setOnClickListener(this);
       Button root= (Button) findViewById(R.id._root);
       root.setOnClickListener(this);
       Button _1= (Button) findViewById(R.id._1);
        Button _2= (Button) findViewById(R.id._2);
        Button _3= (Button) findViewById(R.id._3);
        Button _4= (Button) findViewById(R.id._4);
        Button _5= (Button) findViewById(R.id._5);
        Button _6= (Button) findViewById(R.id._6);
        Button _7= (Button) findViewById(R.id._7);
        Button _8= (Button) findViewById(R.id._8);
        Button _9= (Button) findViewById(R.id._9);
        Button _0= (Button) findViewById(R.id._0);
        Button _minus= (Button) findViewById(R.id._minus);
        Button _plus= (Button) findViewById(R.id._plus);
        Button _multiply= (Button) findViewById(R.id._multiply);
        Button _divide= (Button) findViewById(R.id._divide);
        Button _clear= (Button) findViewById(R.id._C);
        Button _delete= (Button) findViewById(R.id._del);
        Button _decimal= (Button) findViewById(R.id._decimal);
        Button _equal= (Button) findViewById(R.id._equal);
        Button _percent= (Button) findViewById(R.id._percent);
        Button _integer= (Button) findViewById(R.id._integer);
       Button sl= (Button) findViewById(R.id.updown);
       sl.setOnClickListener(this);
        _0.setOnClickListener(this);
        _1.setOnClickListener(this);
        _2.setOnClickListener(this);
        _3.setOnClickListener(this);
        _4.setOnClickListener(this);
        _5.setOnClickListener(this);
        _6.setOnClickListener(this);
        _7.setOnClickListener(this);
        _8.setOnClickListener(this);
        _9.setOnClickListener(this);
        _minus.setOnClickListener(this);
        _multiply.setOnClickListener(this);
        _divide.setOnClickListener(this);
        _plus.setOnClickListener(this);
        _clear.setOnClickListener(this);
        _delete.setOnClickListener(this);
        _decimal.setOnClickListener(this);
        _equal.setOnClickListener(this);
        _percent.setOnClickListener(this);
        _integer.setOnClickListener(this);
       down.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        int id=v.getId();
        switch (id) {
            case R.id._0:
                builder.append("0");
                show();
                break;
            case R.id._1:
                builder.append("1");
                show();
                break;
            case R.id._2:
                builder.append("2");
                show();
                break;
            case R.id._3:
                builder.append("3");
                show();
                break;
            case R.id._4:
                builder.append("4");
                show();
                break;
            case R.id._5:
                builder.append("5");
                show();
                break;
            case R.id._6:
                builder.append("6");
                show();
                break;
            case R.id._7:
                builder.append("7");
                show();
                break;
            case R.id._8:
                builder.append("8");
                show();
                break;
            case R.id._9:
                builder.append("9");
                show();
                break;
            case R.id._plus:
                builder.append("+");
                show();
                break;
            case R.id._pow:
                builder.append("^");
                show();
                break;

            case R.id._percent:
                percent();
                break;
            case R.id._minus:
                builder.append("-");
                show();
                break;
            case R.id._multiply:
                builder.append("X");
                show();
                break;
            case R.id._divide:
                builder.append("/");
                show();
                break;
            case R.id._del:
            case R.id._del2:
                builder.deleteCharAt(builder.length() - 1);
                show();
                break;
            case R.id._decimal:
                builder.append(".");
                show();
                break;
            case R.id._C:
            case R.id._C2:
                int q = builder.length();
                builder.replace(0, q, "");
                rem.setText(builder.toString());
                show();
                break;
            case R.id._equal:
                wohoo();
                break;
            case R.id._integer:
                int qw = builder.length();
                builder.replace(0, qw, str2);
                cal.setText(str2);
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.updown:
            case R.id._down:
                try {
                    if (!isPanelShown) {
                        Animation bottomUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.next);
                        hiddenPanel.startAnimation(bottomUp);

                        hiddenPanel.setVisibility(View.VISIBLE);


                        isPanelShown = true;
                    } else {
                        Animation bottomDown = AnimationUtils.loadAnimation(this, R.anim.previous);
                        hiddenPanel.startAnimation(bottomDown);
                        hiddenPanel.setVisibility(View.INVISIBLE);
                        isPanelShown = false;

                    }
                } catch (Exception e) {
                    Log.d("LOG_TAG", e.toString());
                }
                break;
            case R.id._sin:
                builder.append("sin(");
                show();
                break;
        }
           }

    private void percent() {
        try {


            for (int i = 1; i <= builder.length(); i++) {
                if (builder.charAt(i) == '/') {
                    x = builder.substring(0, i);
                    y = builder.substring(i + 1, builder.length());
                    float a, b, c;
                    a = Float.parseFloat(x);
                    b = Float.parseFloat(y);
                    c = a / b;
                    c=c*100;
                    z=Float.toString(c)+"%";
                    cal.setText(z);
                    rem.setText(builder.toString()+ "--> %");
                    str2=builder.toString();
                    builder.replace(0, builder.length(), z);
                }
            }
        }catch (Exception e){
                    Log.d("LOG_TAG", e.toString());
                }
    }



    private void wohoo() {
        try {


        for (int i = 0; i <= builder.length(); i++) {
            if (builder.charAt(i) == '+') {
                x = builder.substring(0, i);
                y = builder.substring(i + 1, builder.length());
                float a, b, c;
                a = Float.parseFloat(x);
                b = Float.parseFloat(y);
                c = a + b;
                z=Float.toString(c);
                cal.setText(z);
                rem.setText(builder.toString());
                str2=builder.toString();
                builder.replace(0, builder.length(), z);
            }
            if (builder.charAt(i) == '-') {
                x = builder.substring(0, i);
                y = builder.substring(i + 1, builder.length());
                float a, b, c;
                a = Float.parseFloat(x);
                b = Float.parseFloat(y);
                c = a - b;
                z=Float.toString(c);
                cal.setText(z);
                rem.setText(builder.toString());
                str2=builder.toString();
                builder.replace(0, builder.length(), z);
            }
            if (builder.charAt(i) == '^') {
                x = builder.substring(0, i);
                y = builder.substring(i + 1, builder.length());
                float a, b, c;
                a = Float.parseFloat(x);
                b = Float.parseFloat(y);
                c= (float) Math.pow(a,b);
                z=Float.toString(c);
                cal.setText(z);
                rem.setText(builder.toString());
                str2=builder.toString();
                builder.replace(0, builder.length(), z);
            }
            if (builder.charAt(i) == '/') {
                x = builder.substring(0, i);
                y = builder.substring(i + 1, builder.length());
                float a, b, c;
                a = Float.parseFloat(x);
                b = Float.parseFloat(y);
                c = a / b;
                z=Float.toString(c);
                cal.setText(z);
                rem.setText(builder.toString());
                str2=builder.toString();
                builder.replace(0, builder.length(), z);
            }
            if (builder.charAt(i) == 'X') {
                x = builder.substring(0, i);
                y = builder.substring(i + 1, builder.length());
                float a, b, c;
                a = Float.parseFloat(x);
                b = Float.parseFloat(y);
                c = a * b;
                z=Float.toString(c);
                cal.setText(z);
                rem.setText(builder.toString());
                str2=builder.toString();
                builder.replace(0, builder.length(), z);
            }
            if (builder.charAt(i) == 's'&&builder.charAt(i+1)=='i'&&builder.charAt(i+2)=='n') {
                y = builder.substring(i + 4, builder.length());
                float  b, c;

                b = Float.parseFloat(y);
                c = (float) Math.sin(b);
                z=Float.toString(c);
                cal.setText(z);
                rem.setText(builder.toString());
                str2=builder.toString();
                builder.replace(0, builder.length(), z);
            }
        }
        }catch (Exception e){
            Log.d("LOG_TAG", e.toString());
        }
    }

    private void show() {
        str=builder.toString();
        cal.setText(str);

    }


}
