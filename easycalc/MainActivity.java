package com.example.easycalc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class MainActivity extends AppCompatActivity {

    GridLayout gridLayout;
    CardView card1,card2,card3,card4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridLayout=findViewById(R.id.index_grid);

        card1=(CardView) findViewById(R.id.card1);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent simpleCalculator= new Intent(v.getContext(),simple_activity.class);
                startActivity(simpleCalculator);
            }
        });

        card2=findViewById(R.id.card2);
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent statistics =new Intent(v.getContext(), com.example.easycalc.statistics.class);
                startActivity(statistics);
            }
        });

        card3=findViewById(R.id.card3);
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent linerAlgebra= new Intent(v.getContext(),algebra.class);
                startActivity(linerAlgebra);
            }
        });


        card4=findViewById(R.id.card4);
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent conversion= new Intent(v.getContext(),conversion.class);
                startActivity(conversion);
            }
        });







//        setSingleEvent(gridLayout);



    }

//    private void setSingleEvent(GridLayout gridLayout) {
////        for(int i = 0; i<gridLayout.getChildCount();i++){
////            CardView cardView=(CardView)gridLayout.getChildAt(i);
////            final int finalI= i;
////            cardView.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View view) {
////                    Toast.makeText(MainActivity.this,"Clicked at index "+ finalI,Toast.LENGTH_SHORT).show();
////                }
////            });
////        }
//
////        CardView card=(CardView)gridLayout.getChildAt(1);
////        card.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View card) {
////                Intent simple_calculator=new Intent(this,simple_activity.class);
////                startActivity(simple_calculator);
////
////
////            }
////        });
//
//
//
//    }



}
