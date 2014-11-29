package com.mentormate.academy.gamebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Future extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future);
        Button btnPresent= (Button) findViewById(R.id.btnPresent);
        btnPresent.setOnClickListener(this);
        Button btnPast= (Button) findViewById(R.id.btnPast);
        btnPast.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_future, menu);
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
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnPresent:
                Intent presentIntent=new Intent(this, Present.class);
                startActivity(presentIntent);
                break;
            case R.id.btnPast:
                Intent pastIntent=new Intent(this, Past.class);
                startActivity(pastIntent);
                break;
        }
    }
}
