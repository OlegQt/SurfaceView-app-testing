package com.example.surfviewapp.engine;

import java.util.Random;

public class Star {
    private double vx, vy; // Speed
    private double x, y; // Coordinates

    public Star(int screenW, int screenH,double speed) {
        Random pRandom = new Random();
        int xCenter = screenW / 2;
        int yCenter = screenH / 2;
        int dx = pRandom.nextInt(6) - 3;
        int dy = pRandom.nextInt(6) - 3;
        this.x = dx + xCenter;
        this.y = dy + yCenter;

        double decrement = 1000/speed;
        this.vx = (pRandom.nextDouble() - 0.5) / decrement;
        this.vy = (pRandom.nextDouble() - 0.5) / decrement;
    }
    public void rotateSpeedVector(double angle)
    {
        // Для точки (вектора) по формуле приводим смещаем вектор в начало координат
        // Но для вектора скорости началом координат будет служить координаты самой точки
        vx=vx-x;
        vy=vy-y;
        // Умножаем на матрицу поворода вектора на угол
        double vx1=vx*Math.cos(angle)+vy*Math.sin(angle);
        double vy1=vy*Math.cos(angle)-vx*Math.sin(angle);
        // Переносм вектор обратно
        vx=vx1+x;
        vy=vy1+y;
    }

    public void moveStar(long time) {
        double timing = (double) (time / 100000000);
        double dx = vx * 100;
        double dy = vy * 100;

        this.x += dx;
        this.y += dy;
    }

    public void spiral(int halfWidth, int halfHeight,double angle){

        // Для точки (вектора) по формуле приводим смещаем вектор в начало координат
        x=x-halfWidth;
        y=y-halfHeight;
        // Умножаем на матрицу поворода вектора на угол
        double x1=x*Math.cos(angle)+y*Math.sin(angle);
        double y1=y*Math.cos(angle)-x*Math.sin(angle);
        // Переносм вектор обратно
        this.x=x1+halfWidth;
        this.y=y1+halfHeight;
    }

    public int getDistance(int x2, int y2) {
        double a = Math.pow(x2 - this.x, 2);
        double b = Math.pow(y2 - this.y, 2);
        Double distance = Math.sqrt(a + b);
        return distance.intValue();
    }

    public int getX() {
        return (int) this.x;
    }

    public int getY() {
        return (int) this.y;
    }
}
