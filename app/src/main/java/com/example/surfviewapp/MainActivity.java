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

public class MainActivity extends AppCompatActivity {
    // GLOBAL
    private Button btnAction;
    private SurfaceView surface;
    private final String BTNNEWORDER = "NEW ORDER";
    private SurfaceHolder surfaceHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // CODE HER
        btnAction = findViewById(R.id.btn1);
        surface = findViewById(R.id.surface);
        //surfaceHolder = surface.getHolder();

        // Отслеживаем, что происходит с поверхностью
        surface.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
                Canvas canvas = surfaceHolder.lockCanvas();
                Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
                paint.setColor(Color.WHITE);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(16.0f);
                canvas.drawPoint(100, 100,paint);
                surfaceHolder.unlockCanvasAndPost(canvas);
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

            }
        });



        btnAction.setOnClickListener(view -> {
            btnAction.setText(BTNNEWORDER);
        });

    }
}