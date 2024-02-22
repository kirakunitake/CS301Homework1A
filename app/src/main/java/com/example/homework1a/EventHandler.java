package com.example.homework1a;

import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * @author Kira Kunitake
 */
public class EventHandler implements SeekBar.OnSeekBarChangeListener,
        AdapterView.OnItemSelectedListener,
        CompoundButton.OnCheckedChangeListener,
        View.OnClickListener {
    private MainActivity myActivity;
    private Face face;

    public EventHandler(MainActivity initActivity, Face faces){
        myActivity = initActivity;
        this.face = faces;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
      //get seek bar ID
        int seekBarId = seekBar.getId();
        //get rgb values from seek bars
        int red=((SeekBar) myActivity.findViewById(R.id.redSeekBar)).getProgress();
        int green=((SeekBar) myActivity.findViewById(R.id.greenSeekBar)).getProgress();
        int blue=((SeekBar) myActivity.findViewById(R.id.blueSeekBar)).getProgress();

      //reference text view and set value equal to progress
        if (seekBarId == R.id.redSeekBar){
          TextView maxTV1 = myActivity.findViewById(R.id.maxSeekBar1);
          maxTV1.setText("" + progress);
          //get progress of red seek bar
            red = progress;
       }
      else if (seekBarId == R.id.greenSeekBar){
          TextView maxTV2 = myActivity.findViewById(R.id.maxSeekBar2);
          maxTV2.setText("" + progress);
          //get progress of green seek bar
            green = progress;
      }
      else if (seekBarId == R.id.blueSeekBar){
          TextView maxTV3 = myActivity.findViewById(R.id.maxSeekBar3);
          maxTV3.setText("" + progress);
          //get progress of blue seek bar
            blue = progress;
      }

        if(fromUser){
            //if button is clicked, set rgb value to progress rgb values
            if(buttonClicked == hair){
                face.setHairColor(Color.rgb(red,green,blue));
            }
            else if(buttonClicked == eyes){
                face.setEyeColor(Color.rgb(red,green,blue));
            }
            else if(buttonClicked == skin){
                face.setSkinColor(Color.rgb(red,green,blue));
            }
            face.invalidate();
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //use setter method to set hair style depending on spinner selected
        face.setHairStyle(position);
        face.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //get id of radio buttons
    int hair = R.id.hairRadioButton;
    int eyes = R.id.eyesRadioButton;
    int skin = R.id.skinRadioButton;

    int buttonClicked;
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            //see which feature button was checked
            if (buttonView.getId() == hair) {
                //use getter method to get rgb values of the feature
                // and place them into new array
                int[] hairColor = face.getHair();
                //use helper method to set rgb value on seek bars
                updateSeekBar(hairColor[0], hairColor[1], hairColor[2]);
                //make buttonClicked equal to the button clicked
                buttonClicked = hair;
            } else if (buttonView.getId() == eyes) {
                int[] eyeColor = face.getEyes();
                updateSeekBar(eyeColor[0], eyeColor[1], eyeColor[2]);
                buttonClicked = eyes;
            } else if (buttonView.getId() == skin) {
                int[] skinColor = face.getSkin();
                updateSeekBar(skinColor[0], skinColor[1], skinColor[2]);
                buttonClicked = skin;
            }
        }
    }

    private void updateSeekBar(int red, int green, int blue){
        //get seek bar id
        SeekBar reds = myActivity.findViewById(R.id.redSeekBar);
        SeekBar greens = myActivity.findViewById(R.id.greenSeekBar);
        SeekBar blues = myActivity.findViewById(R.id.blueSeekBar);

        //set seek bar progress to rgb value
        reds.setProgress(red);
        greens.setProgress(green);
        blues.setProgress(blue);
    }

    @Override
    public void onClick(View v) {
        face.randomize();
        face.invalidate();
    }
}
