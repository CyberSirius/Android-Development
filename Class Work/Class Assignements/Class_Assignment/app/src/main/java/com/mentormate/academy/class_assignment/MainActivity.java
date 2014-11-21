package com.mentormate.academy.class_assignment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button firstButton = (Button) findViewById(R.id.button_one);
        firstButton.setOnClickListener(this);
        Button secondButton = (Button) findViewById(R.id.button_two);
        secondButton.setOnClickListener(this);
        Button thirdButton = (Button) findViewById(R.id.button_three);
        thirdButton.setOnClickListener(this);
        Button fourButton = (Button) findViewById(R.id.button_four);
        fourButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_one:
                Intent intent = new Intent(MainActivity.this, activity_one.class);
                startActivity(intent);
                break;
            case R.id.button_two:
                intent = new Intent(MainActivity.this, activity_two.class);
                startActivity(intent);
                break;
            case R.id.button_three:
                intent = new Intent(MainActivity.this, activity_three.class);
                startActivity(intent);
                break;
            case R.id.button_four:
                intent = new Intent(MainActivity.this, Activity_four.class);
                startActivity(intent);
                break;

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
