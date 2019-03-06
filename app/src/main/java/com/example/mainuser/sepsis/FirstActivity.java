package com.example.mainuser.sepsis;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class FirstActivity extends AppCompatActivity {
    /*
    Number
    EditText Name;
    EditText randomNumber;
    */
    TextView text;
    Button btn;
    Random rand;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        text= findViewById(R.id.textView);
        btn= findViewById(R.id.button);



//Random number generator
        btn.setOnClickListener(new View.OnClickListener() {
                                   @SuppressLint("SetTextI18n")
                                   @Override
                                   public void onClick(View v) {
                                       {
                                           Random rand = new Random();
                                           int n = rand.nextInt(5555555);
                                           String val = String.valueOf(n);
                                           text.setText(val);
                                       }
                                   }
                               });
        Button btn = findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       Log.i("App", "sepsis");
                                       Toast.makeText(getApplicationContext(), "New Patient file created", Toast.LENGTH_LONG)
                                               .show();
                                   }
                               });




        Button btn2 = findViewById(R.id.btnEnter);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("App", "sepsis");
                Toast.makeText(getApplicationContext(), "Enter Parameters", Toast.LENGTH_SHORT)
                        .show();
                startActivity(new Intent(FirstActivity.this,SecondActivity.class));
            }
        });
    }
}
