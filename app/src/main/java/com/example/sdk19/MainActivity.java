package com.example.sdk19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private long pauseOffset;
    private boolean running;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer = findViewById(R.id.chronometer);
        Button btnStart = (Button) findViewById(R.id.btnstart);
        Button btnPause = (Button) findViewById(R.id.btnpause);
        Button btnReset = (Button) findViewById(R.id.btnreset);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!running){
                    chronometer.setBase(SystemClock.elapsedRealtime()-pauseOffset);
                    chronometer.start();
                    running=true;
                }
            }
        });
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(running){
                    chronometer.stop();
                    pauseOffset =SystemClock.elapsedRealtime()-chronometer.getBase();
                    running= false;
                }
            }
        });
        
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!running){
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    pauseOffset=0;

                }
            }
        });

    }
    }
