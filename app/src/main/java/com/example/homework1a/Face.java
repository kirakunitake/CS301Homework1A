package com.example.homework1a;

import java.util.Random;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceView;
import android.content.Context;
import android.util.AttributeSet;

/**
 * @author Kira Kunitake
 */
public class Face extends SurfaceView{
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle;

    //create paint for hair
    Paint hairPaint = new Paint();

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

        //set hair paint color
        hairPaint.setColor(hairColor);
        invalidate();
    }

    public Face(Context context, AttributeSet attrs){
        super(context, attrs);
        randomize();
        setWillNotDraw(false);
    }

    //draw face
    private void drawFace(Canvas canvas){
        Paint facePaint = new Paint();
        facePaint.setColor(skinColor);
        canvas.drawCircle(canvas.getWidth()/2,canvas.getHeight()/2, 350, facePaint);
    }

    //draw eyes
    private void drawEyes(Canvas canvas){
        Paint eyePaint = new Paint();
        eyePaint.setColor(eyeColor);
        canvas.drawCircle(canvas.getWidth()/2+100, canvas.getHeight()/2-100, 50,eyePaint);
        canvas.drawCircle(canvas.getWidth()/2-100,canvas.getHeight()/2-100,50,eyePaint);

    }

    //draw mouth
    private void drawMouth(Canvas canvas){
        Paint mouthPaint = new Paint();
        mouthPaint.setColor(Color.BLACK);
        canvas.drawArc(canvas.getWidth()/2-100,
                canvas.getHeight()/2+50,
                canvas.getWidth()/2+100,
                canvas.getHeight()/2+200,
                0,
                180,
                false,
                mouthPaint);
    }

    //draw hair
    private void drawStraightHair(Canvas canvas) {
        //Straight hair
        canvas.drawRect(canvas.getWidth() / 2 - 375,
                canvas.getHeight() / 2 + 400,
                canvas.getWidth() / 2 + 375,
                canvas.getHeight() / 2,
                hairPaint);
        canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, 375, hairPaint);
    }

    private void drawCurlyHair(Canvas canvas){
        //Curly hair
        for (int i = 0; i<6; i++){
            canvas.drawOval(canvas.getWidth()/2-400,
                    canvas.getHeight()/2-200+(i*100),
                    canvas.getWidth()/2+400,
                    canvas.getHeight()/2+100 + (i*100),
                    hairPaint);
        }
        canvas.drawCircle(canvas.getWidth()/2,canvas.getHeight()/2, 375, hairPaint);
    }

    private void drawBraidedHair(Canvas canvas){
        //Braided hair
        //left braid
        for(int j = 0; j<6; j++){
            canvas.drawOval(canvas.getWidth()/2-350,
                    canvas.getHeight()/2+(100+(j*50)),
                    canvas.getWidth()/2-200,
                    canvas.getHeight()/2+(200+(j*50)),
                    hairPaint);
        }
        //right braid
        for(int k=0; k<6;k++){
            canvas.drawOval(canvas.getWidth()/2+350,
                    canvas.getHeight()/2+(100+(k*50)),
                    canvas.getWidth()/2+200,
                    canvas.getHeight()/2+(200+(k*50)),
                    hairPaint);
        }
        canvas.drawCircle(canvas.getWidth()/2,canvas.getHeight()/2, 375, hairPaint);
    }

    //set hair style to int position in array
    public void setHairStyle(int num){
        hairStyle = num;
    }

   //create array to store rgb values
    int[] rgb = new int[3];
    //get rgb value of hair, eyes, and skin and store it in the array
    public int[] getHair(){
        rgb[0] = Color.red(hairColor);
        rgb[1] = Color.green(hairColor);
        rgb[2] = Color.blue(hairColor);
        return rgb;
    }
    public int[] getEyes(){
        rgb[0] = Color.red(eyeColor);
        rgb[1] = Color.green(eyeColor);
        rgb[2] = Color.blue(eyeColor);
        return rgb;
    }
    public int[] getSkin(){
        rgb[0] = Color.red(skinColor);
        rgb[1] = Color.green(skinColor);
        rgb[2] = Color.blue(skinColor);
        return rgb;
    }

    //set hair color
    public void setHairColor(int color){
        this.hairColor = color;
        hairPaint.setColor(hairColor);
        invalidate();
    }
    //set eye color
    public void setEyeColor(int color){
        this.eyeColor = color;
    }
    //set skin color
    public void setSkinColor(int color){
        this.skinColor = color;
    }

    public void onDraw(Canvas canvas){
        if(hairStyle == 0){
            drawStraightHair(canvas);
        }
        else if(hairStyle == 1){
            drawCurlyHair(canvas);
        }
        else if(hairStyle == 2){
            drawBraidedHair(canvas);
        }
        drawFace(canvas);
        drawEyes(canvas);
        drawMouth(canvas);
    }
}
