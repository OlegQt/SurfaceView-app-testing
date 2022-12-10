package com.example.surfviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Button;

import com.example.surfviewapp.engine.Engine;
import com.google.android.material.slider.Slider;

public class MainActivity extends AppCompatActivity {
    // GLOBAL
    private Button btnAction;
    private SurfaceView surface;
    private Slider sld;
    private final String BTNNEWORDER = "NEW ORDER";
    private SurfaceHolder surfaceHolder;

    private Engine engine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // CODE HER
        btnAction = findViewById(R.id.btn1);
        surface = findViewById(R.id.surface);
        sld= findViewById(R.id.sld);

        // Запуск потока
        engine=new Engine(surface);


        btnAction.setOnClickListener(view -> {
            btnAction.setText(this.engine.GetCurrentPointsCount());
        });

        sld.addOnChangeListener((slider, value, fromUser) -> {
            this.engine.setSpeedFly(value);
        });

    }

    @Override
    protected void onDestroy() {
        engine.stop(true);
        super.onDestroy();
    }
}