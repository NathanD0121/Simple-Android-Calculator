package com.example.ex1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView mCalculatorDisplay;
    private Boolean userIsTyping = false;
    private Calculator mCalculator;
    private static final String DIGITS = "0123456789";

    DecimalFormat df = new DecimalFormat("@###########");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCalculator = new Calculator();
        mCalculatorDisplay = (TextView) findViewById(R.id.textview);

        df.setMinimumFractionDigits(0);
        df.setMinimumIntegerDigits(1);
        df.setMaximumIntegerDigits(8);

        findViewById(R.id.button0).setOnClickListener(this);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);
        findViewById(R.id.buttonAdd).setOnClickListener(this);
        findViewById(R.id.buttonSubtract).setOnClickListener(this);
        findViewById(R.id.buttonMultiply).setOnClickListener(this);
        findViewById(R.id.buttonDivide).setOnClickListener(this);
        findViewById(R.id.buttonAddSubtract).setOnClickListener(this);
        findViewById(R.id.buttonDecimal).setOnClickListener(this);
        findViewById(R.id.buttonEquals).setOnClickListener(this);
        findViewById(R.id.buttonClear).setOnClickListener(this);
    }

        @Override
        public void onClick(View v) {
            String buttonPressed = ((Button) v).getText().toString();
            if (DIGITS.contains(buttonPressed)) {
                // digit was pressed
                if (userIsTyping) {
                    if (buttonPressed.equals(".") &&
                            mCalculatorDisplay.getText().toString().contains(".")) {
                        // Don't allow multiple decimal points, ignore this one
                    } else {
                        mCalculatorDisplay.append(buttonPressed);
                    }
                } else {
                    if (buttonPressed.equals(".")) {
                        mCalculatorDisplay.setText(0 + buttonPressed);
                    } else {
                        mCalculatorDisplay.setText(buttonPressed);
                    }
                    userIsTyping = true;
                }
            } else {
                // operation was pressed
                if (userIsTyping) {

                    mCalculator.setOperand(Double.parseDouble(mCalculatorDisplay.getText().toString()))
                    ;
                    userIsTyping= false;
                }
                mCalculator.performOperation(buttonPressed);
                mCalculatorDisplay.setText(df.format(mCalculator.getResult()));
            }
        }
    }


