package com.example.surfviewapp.engine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Model {
    private ArrayList<Star> starArray = null;
    private int screenHeight, screenWidth;
    private final int MAX_COUNT = 17000; // Ограничить количество элементов массива
    private double speedIncrement=20;

    public Model() {
        this.starArray = new ArrayList<>();
    }

    public void setScreenSize(int w, int h) {
        this.screenHeight = h;
        this.screenWidth = w;
    }

    public void setSpeed(double val) {
        speedIncrement = val;
    }

    // Add Random point into ArrayList
    public void update(long elapsedTime) {
        Random pRandom = new Random();

        if(this.starArray.size()<MAX_COUNT) {
            for (int i = 0; i < 40; i++) {
                if (pRandom.nextInt(10) == 3) {
                    Star star = new Star(this.screenWidth, this.screenHeight,speedIncrement);
                    this.starArray.add(star);
                }
            }
        }

        Iterator<Star> iterator = this.starArray.iterator();
        while (iterator.hasNext()) {
            Star pS = iterator.next();
            pS.moveStar(elapsedTime);
            //pS.spiral(screenWidth / 2, screenHeight / 2,0.001);

            if (pS.getDistance(screenWidth / 2, screenHeight / 2) > 1000) {
                iterator.remove();
            }
        }
    }
    // Return full ArrayList of points
    public ArrayList<Star> getPointsArray() {
        return this.starArray;
    }
}
