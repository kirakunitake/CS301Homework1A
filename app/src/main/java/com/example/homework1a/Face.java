package com.example.homework1a;

import java.util.Random;
import android.graphics.Canvas;
import android.graphics.Color;

/**
 * @author Kira Kunitake
 */
public class Face {
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle;


    //initializes variables to randomly selected values
    public void randomize(){
        Random random = new Random();
        skinColor = Color.rgb(random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256));
        eyeColor = Color.rgb(random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256));
        hairColor = Color.rgb(random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256));
        hairStyle = random.nextInt(3);
    }

    public Face(){
        randomize();
    }

    //draws face
    public void onDraw(Canvas canvas){

    }
}
