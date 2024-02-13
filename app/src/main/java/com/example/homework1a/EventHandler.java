package com.example.homework1a;

import android.widget.SeekBar;
import android.widget.TextView;

/**
 * @author Kira Kunitake
 */
public class EventHandler implements SeekBar.OnSeekBarChangeListener{
    private MainActivity myActivity;
    public EventHandler(MainActivity initActivity){
        myActivity = initActivity;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
      //get seek bar ID
        int seekBarId = seekBar.getId();

      //reference text view and set value equal to progress
        if (seekBarId == R.id.redSeekBar){
          TextView maxTV1 = myActivity.findViewById(R.id.maxSeekBar1);
          maxTV1.setText("" + progress);
       }
      else if (seekBarId == R.id.greenSeekBar){
          TextView maxTV2 = myActivity.findViewById(R.id.maxSeekBar2);
          maxTV2.setText("" + progress);
      }
      else if (seekBarId == R.id.blueSeekBar){
          TextView maxTV3 = myActivity.findViewById(R.id.maxSeekBar3);
          maxTV3.setText("" + progress);
      }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
