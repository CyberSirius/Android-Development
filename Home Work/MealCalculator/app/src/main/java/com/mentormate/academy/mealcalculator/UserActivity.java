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
    //<editor-fold desc="Constants">
    static final int DISH_PRICE=5;
    static final int DESSERT_PRICE=2;
    static final int DRINK_PRICE=2;
    double totalPrice=0;
    //</editor-fold>
    Currency currentCurrency=Currency.EUR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        //<editor-fold desc="Button init">
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
        //</editor-fold>

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

        TextView txtTotalPriceCurrency = (TextView) findViewById(R.id.txtCurrencyTotalPrice);

        TextView txtTotalPrice = (TextView) findViewById(R.id.txtTotalPrice);
        TextView txtDishQuantity = (TextView) findViewById(R.id.txtDishQuantity);
        int dishQuantity = Integer.parseInt(txtDishQuantity.getText().toString());

        TextView txtDessertQuantity = (TextView) findViewById(R.id.txtDessertQuantity);
        int dessertQuantity = Integer.parseInt(txtDessertQuantity.getText().toString());

        SeekBar seekDrink = (SeekBar) findViewById(R.id.seekDrink);
        seekDrink.setOnSeekBarChangeListener(this);

        CheckBox checkDelivery = (CheckBox) findViewById(R.id.checkHomeDelivery);


        //<editor-fold desc="Button switch">
        switch (v.getId()) {

            case R.id.btnPlusDish:
                if (dishQuantity < 10) {
                    txtDishQuantity.setText(String.valueOf((dishQuantity + 1)));
                }
                break;

            case R.id.btnMinusDish:
                if (dishQuantity > 0) {
                    txtDishQuantity.setText(String.valueOf((dishQuantity - 1)));
                }
                break;

            case R.id.btnPlusDessert:
                if (dessertQuantity < 10) {
                    txtDessertQuantity.setText(String.valueOf((dessertQuantity + 1)));
                }
                break;

            case R.id.btnMinusDessert:
                if (dessertQuantity > 0) {
                    txtDessertQuantity.setText(String.valueOf((dessertQuantity - 1)));
                }
                break;
            case R.id.btnCalculate:
                double tempPrice=0;
                if (checkDelivery.isChecked()){
                    tempPrice+=10;
                }
                tempPrice+=dishQuantity*DISH_PRICE + dessertQuantity*DESSERT_PRICE + seekDrink.getProgress()*DRINK_PRICE;
                totalPrice=tempPrice;
                totalPrice=CurrencyConverter(Currency.EUR,currentCurrency, totalPrice);
                txtTotalPrice.setText(String.valueOf(totalPrice));
                break;
            case R.id.btnEUR:
                totalPrice=CurrencyConverter(currentCurrency,Currency.EUR,totalPrice);
                currentCurrency=Currency.EUR;
                txtTotalPrice.setText(String.valueOf(totalPrice));
                txtTotalPriceCurrency.setText(currentCurrency.toString());
                break;
            case R.id.btnUSD:
                totalPrice=CurrencyConverter(currentCurrency,Currency.USD,totalPrice);
                currentCurrency=Currency.USD;
                txtTotalPrice.setText(String.valueOf(totalPrice));
                txtTotalPriceCurrency.setText(currentCurrency.toString());
                break;
            case R.id.btnBGN:
                totalPrice=CurrencyConverter(currentCurrency,Currency.BNG,totalPrice);
                currentCurrency=Currency.BNG;
                txtTotalPrice.setText(String.valueOf(totalPrice));
                txtTotalPriceCurrency.setText(currentCurrency.toString());
                break;
        }
        //</editor-fold>
    }

    private double CurrencyConverter(Currency currentCurrency, Currency futureCurrency, double amount) {
        return (amount/currentCurrency.Exchange())*futureCurrency.Exchange();
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
