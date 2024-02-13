package com.example.homework1a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;

/**
 * @author Kira Kunitake
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create EventHandler object
        EventHandler handler = new EventHandler(this);

        //Register controller object with the seekbar
        SeekBar redSB = findViewById(R.id.redSeekBar);
        redSB.setOnSeekBarChangeListener(handler);

        SeekBar greenSB = findViewById(R.id.greenSeekBar);
        greenSB.setOnSeekBarChangeListener(handler);

        SeekBar blueSB = findViewById(R.id.blueSeekBar);
        blueSB.setOnSeekBarChangeListener(handler);
    }
}
