package com.example.easycalc;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class simple_activity extends Activity {


    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9,buttondot, buttonAdd, buttonSub, buttonDivision,
            buttonMul, buttonC, buttonEqual;
    EditText bEditText;

    float mValueOne, mValueTwo;

    boolean bAddition, mSubtract, bMultiplication, bDivision;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceSpace){
        super.onCreate(savedInstanceSpace);
        setContentView(R.layout.activity_simple);

        button0 = findViewById(R.id.btn0);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);
        buttondot = findViewById(R.id.btndot);
        buttonAdd = findViewById(R.id.btnadd);
        buttonSub = findViewById(R.id.btnsub);
        buttonMul = findViewById(R.id.btnmul);
        buttonDivision =  findViewById(R.id.btndiv);
        buttonC =  findViewById(R.id.btnac);
        buttonEqual = findViewById(R.id.btnequal);
        bEditText = findViewById(R.id.edit);


        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                bEditText.setText(bEditText.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                bEditText.setText(bEditText.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                bEditText.setText(bEditText.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                bEditText.setText(bEditText.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                bEditText.setText(bEditText.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                bEditText.setText(bEditText.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                bEditText.setText(bEditText.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bEditText.setText(bEditText.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bEditText.setText(bEditText.getText() + "9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                bEditText.setText(bEditText.getText() + "0");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {

                if (bEditText == null) {
                    try{
                        bEditText.setText("");
                    }
                    catch (NullPointerException npe){
                        //
                    }
                } else
                    {
                        try{
                            mValueOne = Float.parseFloat(bEditText.getText() + "");
                            bAddition = true;
                            bEditText.setText(null);
                        }
                        catch(NullPointerException MPE){
                            //
                        }


                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                mValueOne = Float.parseFloat(bEditText.getText() + "");
                mSubtract = true;
                bEditText.setText(null);
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mValueOne = Float.parseFloat(bEditText.getText() + "");
                bMultiplication = true;
                bEditText.setText(null);
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mValueOne = Float.parseFloat(bEditText.getText() + "");
                bDivision = true;
                bEditText.setText(null);
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mValueTwo = Float.parseFloat(bEditText.getText() + "");

                if (bAddition) {
                    bEditText.setText(mValueOne + mValueTwo + "");
                    bAddition = false;
                }

                if (mSubtract) {
                    bEditText.setText(mValueOne - mValueTwo + "");
                    mSubtract = false;
                }

                if (bMultiplication) {
                    bEditText.setText(mValueOne * mValueTwo + "");
                    bMultiplication = false;
                }

                if (bDivision) {
                    bEditText.setText(mValueOne / mValueTwo + "");
                    bDivision = false;
                }
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bEditText.setText("");
            }
        });

        buttondot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bEditText.setText(bEditText.getText() + ".");
            }
        });



    }

}
