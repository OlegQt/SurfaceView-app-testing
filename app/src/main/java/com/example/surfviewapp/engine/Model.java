package com.example.surfviewapp.engine;

import android.graphics.Point;

import java.util.ArrayList;
import java.util.Random;

public class Model {
    final private ArrayList<Point> pointsArray = new ArrayList<>();

    public Model() {
        if(this.pointsArray!=null){
            this.pointsArray.clear();
        }
    }

    // Add Random point into ArrayList
    public void update(long elapsedTime){
        Random pRandom = new Random();
        Point point = new Point(pRandom.nextInt(1000),pRandom.nextInt(1000));
        this.pointsArray.add(point);
    }

    // Return full ArrayList of points
    public ArrayList<Point> getPointsArray(){
        return this.pointsArray;
    }
}
