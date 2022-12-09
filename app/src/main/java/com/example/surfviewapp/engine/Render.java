package com.example.surfviewapp.engine;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

public class Render {
    private final Paint paint;

    public Render(){
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    private void cls(Canvas canvas){
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        canvas.drawRect(0.0f,0.0f,canvas.getWidth(),canvas.getHeight(),this.paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10.0f);
        paint.setColor(Color.YELLOW);
        canvas.drawRect(0.0f,0.0f,canvas.getWidth(),canvas.getHeight(),this.paint);
    }

    public void draw(Canvas canvas,Model model){
        this.cls(canvas);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5.0f);
        paint.setColor(Color.WHITE);

        if(model.getPointsArray().size()>10)
        {
            String str="jj";
        }
        for(Point point: model.getPointsArray())
        {
            canvas.drawPoint(point.x,point.y,this.paint);
        }
    }
}
