package com.example.surfviewapp.engine;

import java.util.Random;

public class Star {
    private double vx, vy; // Speed
    private double x,y;

    public Star(int screenW,int screenH) {
        Random pRandom = new Random();
        int xCenter = screenW/2;
        int yCenter = screenH/2;
        int dx = pRandom.nextInt(100)-50;
        int dy = pRandom.nextInt(100)-50;
        this.x = dx+xCenter;
        this.y = dy+yCenter;
        this.vx=(double)dx /1000;
        this.vy=(double)dy /1000;
    }

    public void moveStar(long time){
        double timing = (double) (time / 1000000000);
        double dx=vx*timing;
        double dy=vy*timing;

        this.x+=dx;
        this.y+=dy;
    }
    public int getDistance(int x2, int y2){
        double a = Math.pow(x2-this.x,2);
        double b = Math.pow(y2-this.y,2);
        Double distance = Math.sqrt(a+b);
        return distance.intValue();
    }
    public int getX(){
        return (int)this.x;
    }
    public int getY(){
        return (int)this.y;
    }
}
