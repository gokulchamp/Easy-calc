package com.example.easycalc;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class conversion extends Activity {

    EditText distance_text1,distance_text2,volume_text1,volume_text2,weight_text1,weight_text2;
    Spinner distance1,distance2,weights1,weights2,volume1,volume2;
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);


        distance1=findViewById(R.id.distance1);
        distance2=findViewById(R.id.distance2);
        weights1=findViewById(R.id.weights1);
        weights2=findViewById(R.id.weights2);
        volume1=findViewById(R.id.volume1);
        volume2=findViewById(R.id.volume2);



        distance_text1=findViewById(R.id.distance_text1);
        distance_text2=findViewById(R.id.distance_text2);

        weight_text1=findViewById(R.id.weight_text1);
        weight_text2=findViewById(R.id.weight_text2);

        volume_text1=findViewById(R.id.volume_text1);
        volume_text2=findViewById(R.id.volume_text2);




        distance_text1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               try {

                   String dist=distance_text1.getText().toString();

                   String d_1=distance1.getSelectedItem().toString();
                   String d_2=distance2.getSelectedItem().toString();

                   if(d_1.equals(d_2)){
                       distance_text2.setText(dist);
                   }
                   if(d_1.equals("KM") && d_2.equals("m")){
                       distance_text2.setText(String.valueOf((Integer.parseInt(dist)*1000)));
                   }
                   if(d_1.equals("KM") && d_2.equals("inches")){
                       distance_text2.setText(String.valueOf((Integer.parseInt(dist)*39370.07)));
                   }
                   if(d_1.equals("m") && d_2.equals("KM")) {
                       distance_text2.setText(String.valueOf((Integer.parseInt(dist)/1000.0)));
                   }
                   if(d_1.equals("m") && d_2.equals("inches")) {
                       distance_text2.setText(String.valueOf((Integer.parseInt(dist)*39.37)));

                   }
                   if(d_1.equals("inches") && d_2.equals("KM")) {
                       distance_text2.setText(String.valueOf((Integer.parseInt(dist)/39370.07)));
                   }
                   if(d_1.equals("inches") && d_2.equals("m")) {
                       distance_text2.setText(String.valueOf((Integer.parseInt(dist)/39.37)));
                   }

               }
               catch (Exception npe){
                   distance_text2.setText("");
               }




            }

            @Override
            public void afterTextChanged(Editable s) {


                //Toast.makeText(getApplicationContext(),"converted",Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(),d_1,Toast.LENGTH_LONG).show();
            }
        });

        weight_text1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                try {

                    String weight=weight_text1.getText().toString();

                    String w_1=weights1.getSelectedItem().toString();
                    String w_2=weights2.getSelectedItem().toString();

                    if(w_1.equals(w_2)){
                        weight_text2.setText(weight);
                    }
                    if(w_1.equals("KG") && w_2.equals("g")){
                        weight_text2.setText(String.valueOf((Integer.parseInt(weight)*1000)));
                    }
                    if(w_1.equals("KG") && w_2.equals("pound")){
                        weight_text2.setText(String.valueOf((Integer.parseInt(weight)*2.20)));
                    }
                    if(w_1.equals("g") && w_2.equals("KG")) {
                        weight_text2.setText(String.valueOf((Integer.parseInt(weight)/1000.0)));
                    }
                    if(w_1.equals("g") && w_2.equals("pound")) {
                        weight_text2.setText(String.valueOf((Integer.parseInt(weight)*0.0022)));

                    }
                    if(w_1.equals("pound") && w_2.equals("KG")) {
                        weight_text2.setText(String.valueOf((Integer.parseInt(weight)/2.20)));
                    }
                    if(w_1.equals("pound") && w_2.equals("g")) {
                        weight_text2.setText(String.valueOf((Integer.parseInt(weight)*453.592)));
                    }

                }
                catch (Exception npe){
                    weight_text2.setText("");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                //
            }
        });

        volume_text1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try{
                    String volume=volume_text1.getText().toString();
                    String v_1=volume1.getSelectedItem().toString();
                    String v_2=volume2.getSelectedItem().toString();

                    if(v_1.equals(v_2)){
                        volume_text2.setText(volume);

                    }
                    if(v_1.equals("l") && v_2.equals("ml")){
                        volume_text2.setText(String.valueOf((Integer.parseInt(volume)*1000)));
                    }

                    if(v_1.equals("ml")&& v_2.equals("l")){
                        volume_text2.setText(String.valueOf((Integer.parseInt(volume)/1000.0)));
                    }


                }
                catch (Exception npe){
                    volume_text2.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                //
            }
        });




    }
}
