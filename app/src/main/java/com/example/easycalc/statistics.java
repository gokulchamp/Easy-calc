package com.example.easycalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class statistics extends Activity {

    EditText inputText;
    TextView mean,median,mode,deviation;
    Button calculate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        inputText = findViewById(R.id.stats_editView);
        calculate = findViewById(R.id.calculate_button);
        mean = findViewById(R.id.mean);
        median = findViewById(R.id.median);
        mode = findViewById(R.id.mode);
        deviation=findViewById(R.id.deviation);

        inputText.requestFocus();




        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String input=inputText.getText().toString();
                    List<String> inputArray;
                    String delimiter="\n";
                    final ArrayList<Double> intArray= new ArrayList<>();

                    inputArray= Arrays.asList(input.split(delimiter));

                    for (String element:inputArray){

                        intArray.add(Double.parseDouble(element));

                    }
                    final double mean_Value=mean_function(intArray);
                    double median_Value=median_function(intArray);
                    double mode_value=mode_function(intArray);
                    double standrad_deviation=deviation_function(intArray,mean_Value);



                    mean.setText(Double.toString(mean_Value));
                    Collections.sort(intArray);
                    median.setText(Double.toString(median_Value));
                    mode.setText(Double.toString(mode_value));
                    deviation.setText(Double.toString(standrad_deviation));
                }
                catch (NullPointerException npe) {
                    //
                }
            }

        });





    }

    public double mean_function(ArrayList<Double> intArray){
            double sum=0;
            for(Double element :intArray){
                sum+=element;
            }
            int size=intArray.size();
            return Math.round((sum/size)*100.0)/100.0;
    }

    public double median_function(ArrayList<Double> intarray){
        int middle = intarray.size()/2;
        if (intarray.size()%2 == 1) {
            return Math.round(intarray.get(middle)*100.0)/100.0;
        } else {

            return Math.round(((intarray.get(middle-1) + intarray.get(middle)) / 2.0)*100.0)/100.0;
        }
    }

    public double mode_function(ArrayList<Double> intArray){
        int maxCount=0,count;
        double maxValue=0;

        for (double element1 :intArray){
            count=0;
            for (double element2:intArray){
                if (element1==element2){
                    count++;
                }
            }

            if (count>maxCount){
                maxValue=element1;
                maxCount=count;
            }
        }

        return  maxValue;
    }

    public double deviation_function(ArrayList<Double> intarray,double mean){
        double standard_deviation=0;
        for(double element:intarray){
            standard_deviation+=Math.pow(element-mean,2);
        }

        return Math.round(Math.sqrt(standard_deviation)*100.0)/100.0;
    }


}
