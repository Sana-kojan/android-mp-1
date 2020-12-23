package com.example.day1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText q = findViewById(R.id.Quiz);
        final EditText h = findViewById(R.id.HW);
        final EditText m = findViewById(R.id.Mid);
        final EditText f = findViewById(R.id.Final);
        final TextView res = findViewById(R.id.result);
        Button c = findViewById(R.id.calc);
        Button re = findViewById(R.id.reset);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(q.getText().toString().matches("") || h.getText().toString().matches("") || m.getText().toString().matches("") || m.getText().toString().matches(""))
                    Toast.makeText(MainActivity.this, "Please fill all the fields", Toast.LENGTH_LONG).show();
                else{
                    if(!(Double.parseDouble(q.getText().toString())<=15 && Double.parseDouble(q.getText().toString())>-1))
                        Toast.makeText(MainActivity.this, "The quiz percentage is invalid", Toast.LENGTH_LONG).show();
                    else if(!(Double.parseDouble(h.getText().toString())<=25 && Double.parseDouble(h.getText().toString())>-1))
                        Toast.makeText(MainActivity.this, "The homework percentage is invalid", Toast.LENGTH_LONG).show();
                    else if(!(Double.parseDouble(m.getText().toString())<=30 && Double.parseDouble(m.getText().toString())>-1))
                        Toast.makeText(MainActivity.this, "The midterm percentage is invalid", Toast.LENGTH_LONG).show();
                    else if(!(Double.parseDouble(f.getText().toString())<=30 && Double.parseDouble(f.getText().toString())>-1))
                        Toast.makeText(MainActivity.this, "The final percentage is invalid", Toast.LENGTH_LONG).show();
                    else{
                        double dq= Double.parseDouble(q.getText().toString());
                        double dh= Double.parseDouble(h.getText().toString());
                        double dm= Double.parseDouble(m.getText().toString());
                        double df= Double.parseDouble(f.getText().toString());
                        double r = dq + dh + dm + df;
                        if(r<=100 && r>=90){
                            res.setText("A");
                            res.setTextColor(0xFF00FF00);}
                        else if (r<=89 && r>=80){
                            res.setText("B");
                            res.setTextColor(0xffffff00);}
                        else if (r<=79 && r>=70){
                            res.setText("C");
                            res.setTextColor(Color.rgb(255, 165, 0));}
                        else if (r<=69 && r>=60){
                            res.setText("D");
                            res.setTextColor(Color.rgb(255, 87, 51));
                        }
                        else{
                            res.setText("F");
                            res.setTextColor(0xffff0000);}
                    }
                }
            }
        });
        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q.setText("");
                h.setText("");
                m.setText("");
                f.setText("");

            }
        });


    }
}