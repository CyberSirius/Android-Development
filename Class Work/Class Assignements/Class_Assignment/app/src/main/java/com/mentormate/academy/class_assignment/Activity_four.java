package com.mentormate.academy.class_assignment;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


public class Activity_four extends Activity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {
    TextView txtRed = null;
    TextView txtGreen = null;
    TextView txtBlue = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        SeekBar red = (SeekBar) findViewById(R.id.seekBar_red);
        red.setOnSeekBarChangeListener(this);
        txtRed = (TextView) findViewById(R.id.txtRed);


        SeekBar green = (SeekBar) findViewById(R.id.seekBar_green);
        green.setOnSeekBarChangeListener(this);
        txtGreen = (TextView) findViewById(R.id.txtGreen);


        SeekBar blue = (SeekBar) findViewById(R.id.seekBar_blue);
        blue.setOnSeekBarChangeListener(this);
        txtBlue = (TextView) findViewById(R.id.txtBlue);


        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_four, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.seekBar_red:
                txtRed.setText(String.valueOf(progress));
                break;
            case R.id.seekBar_green:
                txtGreen.setText(String.valueOf(progress));
                break;
            case R.id.seekBar_blue:
                txtBlue.setText(String.valueOf(progress));
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                int red = Integer.valueOf(txtRed.getText().toString());
                int green = Integer.valueOf(txtGreen.getText().toString());
                int blue = Integer.valueOf(txtBlue.getText().toString());
                int color = Color.rgb(red, green, blue);
                getWindow().getDecorView().setBackgroundColor(color);
                break;
        }
    }
}
