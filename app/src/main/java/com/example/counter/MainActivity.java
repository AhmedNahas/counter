package com.example.counter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText p1,p2,p3,p4;
    Button confirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p1=findViewById(R.id.firstPlayerEditText);
        p2=findViewById(R.id.secondPlayerEditText);
        p3=findViewById(R.id.thirdPlayerEditText);
        p4=findViewById(R.id.fourthPlayerEditText);
        confirm=findViewById(R.id.confirmPlayersNames);


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("firstPlayer",p1.getText().toString());
                intent.putExtra("secondPlayer",p2.getText().toString());

                intent.putExtra("thirdPlayer",p3.getText().toString());
                intent.putExtra("fourthPlayer",p4.getText().toString());

                startActivity(intent);
            }
        });

    }

}
