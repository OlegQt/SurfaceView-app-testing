package com.example.surfviewapp.engine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Model {
    private ArrayList<Star> starArray = null;
    private int screenHeight, screenWidth;

    public Model() {
        this.starArray = new ArrayList<>();
    }

    public void setScreenSize(int w, int h) {
        this.screenHeight = h;
        this.screenWidth = w;
    }


    // Add Random point into ArrayList
    public void update(long elapsedTime) {
        Random pRandom = new Random();

        for (int i = 0; i < 40; i++) {
            if(pRandom.nextInt(10)==3) {
                Star star = new Star(this.screenWidth, this.screenHeight);
                this.starArray.add(star);
            }
        }

        Iterator<Star> iterator = this.starArray.iterator();
        while (iterator.hasNext()) {
            Star pS = iterator.next();
            pS.moveStar(elapsedTime);
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
