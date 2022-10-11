package com.sbsolutions.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
//    inicializar el textview
    TextView cronometro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int time = 180000; // en milisegundos
        cronometro = findViewById(R.id.creonometro);
        new CountDownTimer(time, 1000) {
            public void onTick(long millisUntilFinished) {
                NumberFormat f = new DecimalFormat("00");
                long min = (millisUntilFinished / 60000) % 60;
                long sec = (millisUntilFinished / 1000) % 60;
                cronometro.setText(String.format("%s : %s",  f.format(min), f.format(sec)));
            }
            public void onFinish() {
                cronometro.setText("00:00:00");
            }
        }.start();
    }
}