package com.example.surfviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    // GLOBAL
    private Button btnAction;
    private SurfaceView surface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// CODE HERE
        btnAction = findViewById(R.id.btn1);
        surface = findViewById(R.id.surface);

    }
}