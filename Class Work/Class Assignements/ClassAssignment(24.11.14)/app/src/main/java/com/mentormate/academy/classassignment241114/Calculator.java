package com.mentormate.academy.classassignment241114;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Stack;


public class Calculator extends Activity implements View.OnClickListener {
    EditText input;
    Stack<Integer> values = new Stack<Integer>();
    Stack<Character> operands = new Stack<Character>();
    int index = 0;
    int indexOfLastChar = 0;
    String TAG = getClass().getSimpleName();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        input = (EditText) findViewById(R.id.input);
        input.setTypeface(Typeface.createFromAsset(getAssets(), "digital-7.ttf"));
        //<editor-fold desc="Button init">
        Button one = (Button) findViewById(R.id.one);
        one.setOnClickListener(this);
        Button two = (Button) findViewById(R.id.two);
        two.setOnClickListener(this);
        Button three = (Button) findViewById(R.id.three);
        three.setOnClickListener(this);
        Button four = (Button) findViewById(R.id.four);
        four.setOnClickListener(this);
        Button five = (Button) findViewById(R.id.five);
        five.setOnClickListener(this);
        Button six = (Button) findViewById(R.id.six);
        six.setOnClickListener(this);
        Button seven = (Button) findViewById(R.id.seven);
        seven.setOnClickListener(this);
        Button eight = (Button) findViewById(R.id.eight);
        eight.setOnClickListener(this);
        Button nine = (Button) findViewById(R.id.nine);
        nine.setOnClickListener(this);
        Button zero = (Button) findViewById(R.id.zero);
        zero.setOnClickListener(this);
        Button plus = (Button) findViewById(R.id.plus);
        plus.setOnClickListener(this);
        Button minus = (Button) findViewById(R.id.minus);
        minus.setOnClickListener(this);
        Button multiply = (Button) findViewById(R.id.multiply);
        multiply.setOnClickListener(this);
        Button divide = (Button) findViewById(R.id.divide);
        divide.setOnClickListener(this);
        Button equals = (Button) findViewById(R.id.equals);
        equals.setOnClickListener(this);
        Button clear = (Button) findViewById(R.id.clear);
        clear.setOnClickListener(this);
        //</editor-fold>
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculator, menu);
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
        indexOfLastChar = input.length() - 1;
        char lastChar;
        if (input.length() == 0) {
            lastChar = '0';
        } else {
            lastChar = input.getText().charAt(indexOfLastChar);
        }

        switch (v.getId()) {
            //<editor-fold desc="Number click">
            case R.id.one:
                input.append("1");
                break;
            case R.id.two:
                input.append("2");
                break;
            case R.id.three:
                input.append("3");
                break;
            case R.id.four:
                input.append("4");
                break;
            case R.id.five:
                input.append("5");
                break;
            case R.id.six:
                input.append("6");
                break;
            case R.id.seven:
                input.append("7");
                break;
            case R.id.eight:
                input.append("8");
                break;
            case R.id.nine:
                input.append("9");
                break;
            case R.id.zero:
                input.append("0");
                break;
            //</editor-fold>
            //<editor-fold desc="Arithmetic click">
            case R.id.plus:
                onArithmeticClick(lastChar, "+");
                break;
            case R.id.minus:
                onArithmeticClick(lastChar, "-");
                break;
            case R.id.multiply:
                onArithmeticClick(lastChar, "*");
                break;
            case R.id.divide:
                onArithmeticClick(lastChar, "/");
                break;
            //</editor-fold>
            case R.id.clear:
                input.setText("");
                index=0;
                indexOfLastChar=0;
                break;
            case R.id.equals:
                if(isArithmeticChar(lastChar)){
                    operands.pop();
                    String text=input.getText().toString();
                    text=text.substring(0,indexOfLastChar);
                    input.setText(text);
                }
                input.append("=");
                break;
        }
    }

    private void onArithmeticClick(char lastChar, CharSequence arithmeticSymbol) {
        if (!isArithmeticChar(lastChar)) {
            input.append(arithmeticSymbol);
            indexOfLastChar++;
            lastChar = input.getText().charAt(indexOfLastChar);
            operands.push(lastChar);
            int number = Integer.parseInt(input.getText().toString().substring(index, indexOfLastChar));
            Log.wtf(TAG, String.valueOf(number));
            values.push(number);
            index = indexOfLastChar + 1;
        }
    }

    public boolean isArithmeticChar(char c) {
        char[] arithmeticSymbols = {'+', '-', '*', '/'};
        for (char arithmeticSymbol : arithmeticSymbols) {
            if (c == arithmeticSymbol) {
                return true;
            }
        }
        return false;
    }
}