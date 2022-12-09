package com.example.surfviewapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Button;

import com.example.surfviewapp.engine.Engine;

public class MainActivity extends AppCompatActivity {
    // GLOBAL
    private Button btnAction;
    private SurfaceView surface;
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
        //surfaceHolder = surface.getHolder();

        // Отслеживаем, что происходит с поверхностью
        engine=new Engine(surface);


        btnAction.setOnClickListener(view -> {
            btnAction.setText(this.engine.GetCurrentPointsCount());
            //finish();
        });

    }

    @Override
    protected void onDestroy() {
        engine.stop(true);
        super.onDestroy();
    }
}