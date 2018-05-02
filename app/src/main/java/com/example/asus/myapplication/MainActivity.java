package com.example.asus.myapplication;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText lend;
    private EditText rate;
    private EditText num;
    private TextView vamount;
    private Button bt_sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setComponent();
        setListener();

    }

    @SuppressLint("WrongViewCast")
    private void setComponent() {
        lend = (EditText)findViewById(R.id.input_lend);
        rate=(EditText)findViewById(R.id.input_rate);
        num=(EditText)findViewById(R.id.input_number);
        vamount=(TextView) findViewById(R.id.amount);
        bt_sub= (Button)findViewById(R.id.submit);
    }
    private void setListener() {
        bt_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat df=new DecimalFormat("0");
                double d_lend=Double.parseDouble(lend.getText().toString());
                double d_rate=Double.parseDouble(rate.getText().toString());
                double d_number=Double.parseDouble(num.getText().toString());
                double resault=d_lend*Math.pow((d_rate/12/100)+1, d_number);
                vamount.setText("本利和為:"+df.format(resault));
            }

            }
        });

    }
}
