package com.mentormate.academy.gamebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.LinkedList;


public class Present extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private LinkedList<Boolean> choices = new LinkedList<Boolean>();
    private boolean choice = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present);
        Button past = (Button) findViewById(R.id.btnPast);
        past.setOnClickListener(this);
        Button future = (Button) findViewById(R.id.btnFuture);
        future.setOnClickListener(this);

        Button choose = (Button) findViewById(R.id.btnChoose);
        choose.setOnClickListener(this);
        Spinner choice = (Spinner) findViewById(R.id.spChoice);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.choices, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        choice.setAdapter(adapter);
        choice.setOnItemSelectedListener(this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPast:
                Intent pastIntent = new Intent(this, Past.class);
                startActivity(pastIntent);
                break;
            case R.id.btnFuture:
                Intent futureIntent = new Intent(this, Future.class);
                startActivity(futureIntent);
                break;
            case R.id.btnChoose:
                choices.add(choice);
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        choice = !(parent.getItemAtPosition(position) == parent.getItemAtPosition(1) || parent.getItemAtPosition(0).equals(parent.getItemAtPosition(position)));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
