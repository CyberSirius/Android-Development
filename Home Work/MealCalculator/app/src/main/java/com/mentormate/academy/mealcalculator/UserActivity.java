package com.mentormate.academy.mealcalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class UserActivity extends Activity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    //<editor-fold desc="Constants">
    private static final int DISH_PRICE = 5;
    private static final int DESSERT_PRICE = 2;
    private static final int DRINK_PRICE = 2;
    //</editor-fold>

    private double totalPrice = 0;

    private Currency currentCurrency = Currency.EUR;

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
                double tempPrice = 0;
                if (checkDelivery.isChecked()) {
                    tempPrice += 10;
                }
                tempPrice += dishQuantity * DISH_PRICE + dessertQuantity * DESSERT_PRICE + seekDrink.getProgress() * DRINK_PRICE;
                tempPrice = CurrencyConverter(Currency.EUR, currentCurrency, tempPrice);
                totalPrice = tempPrice;
                ConvertAndDisplay(currentCurrency);
                break;
            case R.id.btnEUR:
                ConvertAndDisplay(Currency.EUR);
                break;
            case R.id.btnUSD:
                ConvertAndDisplay(Currency.USD);
                break;
            case R.id.btnBGN:
                ConvertAndDisplay(Currency.BNG);
                break;
            case R.id.btnAbout:
                Intent intent = new Intent(UserActivity.this, AboutActivity.class);
                startActivity(intent);
                break;
        }
        //</editor-fold>
    }

    private void ConvertAndDisplay(Currency futureCurrency) {
        //<editor-fold desc="TextView init">
        TextView txtCurrencyDish = (TextView) findViewById(R.id.txtCurrencyDish);
        TextView txtCurrencyDessert = (TextView) findViewById(R.id.txtCurrencyDessert);
        TextView txtCurrencyDrink = (TextView) findViewById(R.id.txtCurrencyDrink);
        TextView txtCurrencyDelivery = (TextView) findViewById(R.id.txtCurrencyDelivery);
        TextView txtTotalPriceCurrency = (TextView) findViewById(R.id.txtCurrencyTotalPrice);
        TextView txtTotalPrice = (TextView) findViewById(R.id.txtTotalPrice);
        TextView txtPriceDish = (TextView) findViewById(R.id.txtPriceDish);
        TextView txtPriceDrink = (TextView) findViewById(R.id.txtPriceDrink);
        TextView txtPriceDessert = (TextView) findViewById(R.id.txtPriceDessert);
        TextView txtPriceDelivery = (TextView) findViewById(R.id.txtPriceDelivery);
        //</editor-fold>

        DecimalFormat formatter = new DecimalFormat("##0.00");

        totalPrice = CurrencyConverter(currentCurrency, futureCurrency, totalPrice);

        txtPriceDish.setText(formatter.format(CurrencyConverter(currentCurrency, futureCurrency, Double.parseDouble(txtPriceDish.getText().toString()))));
        txtPriceDessert.setText(formatter.format(CurrencyConverter(currentCurrency, futureCurrency, Double.parseDouble(txtPriceDessert.getText().toString()))));
        txtPriceDrink.setText(formatter.format(CurrencyConverter(currentCurrency, futureCurrency, Double.parseDouble(txtPriceDrink.getText().toString()))));
        txtPriceDelivery.setText(formatter.format(CurrencyConverter(currentCurrency, futureCurrency, Double.parseDouble(txtPriceDelivery.getText().toString()))));

        currentCurrency = futureCurrency;

        txtTotalPrice.setText(formatter.format(totalPrice));
        txtTotalPriceCurrency.setText(currentCurrency.toString());

        txtCurrencyDessert.setText(currentCurrency.toString());
        txtCurrencyDish.setText(currentCurrency.toString());
        txtCurrencyDrink.setText(currentCurrency.toString());
        txtCurrencyDelivery.setText(currentCurrency.toString());
    }

    private double CurrencyConverter(Currency currentCurrency, Currency futureCurrency, double amount) {
        return (amount / currentCurrency.Exchange()) * futureCurrency.Exchange();
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
