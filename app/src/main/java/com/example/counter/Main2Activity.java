package com.example.counter;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.counter.R.id.*;

public class Main2Activity extends AppCompatActivity {




    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final Button firstFrag;
        firstFrag = findViewById(btn_first_frag);
        Button secondFrag;
        secondFrag = findViewById(btn_second_frag);
        Button thirdFrag;
        thirdFrag = findViewById(btn_third_frag);
        Button fourthFrag;
        fourthFrag = findViewById(btn_fourth_frag);


        firstFrag.setText(getIntent().getExtras().getString("firstPlayer"));
        secondFrag.setText(getIntent().getExtras().getString("secondPlayer"));
        thirdFrag.setText(getIntent().getExtras().getString("thirdPlayer"));
        fourthFrag.setText(getIntent().getExtras().getString("fourthPlayer"));




        firstFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipeFragments(new FirstFragment());






            }
        });
        secondFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                swipeFragments(new SecondFragment());
            }
        });
        thirdFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                swipeFragments(new ThirdFragment());


            }
        });
        fourthFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                swipeFragments(new FourthFragment());
            }
        });


    }

    public void swipeFragments(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.container,fragment).commit();


    }

}

