package com.example.homework1a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;

/**
 * @author Kira Kunitake
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create face object
        Face face = findViewById(R.id.surfaceView);

        //create EventHandler object
        EventHandler handler = new EventHandler(this,face);

        //Register controller object with the seekbar
        SeekBar redSB = findViewById(R.id.redSeekBar);
        redSB.setOnSeekBarChangeListener(handler);

        SeekBar greenSB = findViewById(R.id.greenSeekBar);
        greenSB.setOnSeekBarChangeListener(handler);

        SeekBar blueSB = findViewById(R.id.blueSeekBar);
        blueSB.setOnSeekBarChangeListener(handler);

        Spinner hairStyleSpinner = findViewById(R.id.hairStyleSpinner);
        hairStyleSpinner.setOnItemSelectedListener(handler);

        RadioButton hairButton = findViewById(R.id.hairRadioButton);
        hairButton.setOnCheckedChangeListener(handler);

        RadioButton eyesButton = findViewById(R.id.eyesRadioButton);
        eyesButton.setOnCheckedChangeListener(handler);

        RadioButton skinButton = findViewById(R.id.skinRadioButton);
        skinButton.setOnCheckedChangeListener(handler);

        Button rand = findViewById(R.id.randomFaceButton);
        rand.setOnClickListener(handler);


    }
}
