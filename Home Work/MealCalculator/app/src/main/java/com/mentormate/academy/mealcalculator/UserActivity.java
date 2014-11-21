package com.mentormate.academy.mealcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;


public class UserActivity extends Activity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Button btnEUR = (Button) findViewById(R.id.btnEUR);
        btnEUR.setOnClickListener(this);

        Button btnBGN = (Button) findViewById(R.id.btnBGN);
        btnBGN.setOnClickListener(this);

        Button btnUSD = (Button) findViewById(R.id.btnUSD);
        btnUSD.setOnClickListener(this);

        Button btnPlusDessert = (Button) findViewById(R.id.btnPlusDessert);
        btnPlusDessert.setOnClickListener(this);

        Button btnMinusDessert = (Button) findViewById(R.id.btnMinusDessert);
        btnMinusDessert.setOnClickListener(this);

        Button btnPlusDish = (Button) findViewById(R.id.btnPlusDish);
        btnPlusDish.setOnClickListener(this);

        Button btnMinusDish = (Button) findViewById(R.id.btnMinusDish);
        btnMinusDish.setOnClickListener(this);

        Button btnCalculate = (Button) findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(this);

        Button btnAbout = (Button) findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(this);

        SeekBar seekDrink=(SeekBar) findViewById(R.id.seekDrink);
        seekDrink.setOnSeekBarChangeListener(this);

        CheckBox checkDelivery=(CheckBox) findViewById(R.id.checkHomeDelivery);

        TextView txtTotalPrice=(TextView) findViewById(R.id.txtTotalPrice);

        TextView txtTotalPriceCurrency= (TextView) findViewById(R.id.txtCurrencyTotalPrice);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user, menu);
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

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
