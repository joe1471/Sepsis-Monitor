package com.example.mainuser.sepsis;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.annotation.Retention;
import java.lang.reflect.Field;


public class SecondActivity extends AppCompatActivity {
    int editText8;
    int o2Score;
    int bpScore;
    int resRate;
    int heartScore;
    int temp;
    int cLevel;
    String[] list;

    public static int totalScore;

    private void updateScore(int o2Score, int bpScore, int resRate, int heartScore, int temp, int cLevel){
        TextView score = findViewById(R.id.textView11);
        totalScore = o2Score + bpScore + resRate + heartScore + temp + cLevel;
        score.setText("Score: " + totalScore);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Spinner dropdown=findViewById(R.id.spinner1);
        list=new String[]{"Alert","Voice","Pain","Unresponsive"};

        ArrayAdapter<String> adapter=new ArrayAdapter <>(this,android.R.layout.simple_spinner_dropdown_item,list);
        dropdown.setAdapter(adapter);





        //if and else statements OXYGEN SATURATION
        final TextView o2 = findViewById(R.id.editText8);
        o2.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int res = Integer.parseInt(o2.getText().toString());
                ImageView o2Color = findViewById(R.id.imageView10);
                //TextView t2 = findViewById(R.id.textView4);
                //t2.setText(Integer.toString(res));

                if(res>=96){
                    o2Color.setColorFilter(Color.WHITE);
                    o2Score =0;
                    updateScore(o2Score, bpScore, resRate, heartScore, temp, cLevel);
                }else if(res<=96&&res==94){
                    o2Color.setColorFilter(Color.YELLOW);
                    o2Score =1;
                    updateScore(o2Score, bpScore, resRate, heartScore, temp, cLevel);
                }else if(res<94&&res>=92){
                    o2Color.setColorFilter(Color.rgb(242,109,0));
                    o2Score =2;
                    updateScore(o2Score, bpScore, resRate, heartScore, temp, cLevel);
                }else{
                    o2Color.setColorFilter(Color.RED);
                    o2Score =3;
                    updateScore(o2Score, bpScore, resRate, heartScore, temp, cLevel);
                }
            }
        });

        //if and else statements BLOOD PRESSURE
        final TextView Blood = findViewById(R.id.editText9);
        Blood.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int res = Integer.parseInt(Blood.getText().toString());
                ImageView BloodColor = findViewById(R.id.imageView2);
                //TextView t2 = findViewById(R.id.textView4);
                //t2.setText(Integer.toString(res));

                if(res>=90&&res<=120){
                    BloodColor.setColorFilter(Color.WHITE);
                    bpScore =0;
                    updateScore(o2Score, bpScore, resRate, heartScore, temp, cLevel);
                }else if(res<130&&res>=80){
                    BloodColor.setColorFilter(Color.YELLOW);
                    bpScore =1;
                    updateScore(o2Score, bpScore, resRate, heartScore, temp, cLevel);
                }else if(res<140&&res>=130){
                    BloodColor.setColorFilter(Color.rgb(242,109,0));
                    bpScore=2;
                    updateScore(o2Score, bpScore, resRate, heartScore, temp, cLevel);
                }else{
                    BloodColor.setColorFilter(Color.RED);
                    bpScore =3;
                    updateScore(o2Score, bpScore, resRate, heartScore, temp, cLevel);
                }
            }
        });


        //if and else statements RESPIRATION RATE
        final TextView Respiration = findViewById(R.id.editText10);
        Respiration.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (Respiration.getText()!=null) {
                    int res = Integer.parseInt(Respiration.getText().toString());
                    ImageView Respirationcolor = findViewById(R.id.imageView3);
                    //TextView t2 = findViewById(R.id.textView4);
                    //t2.setText(Integer.toString(res));

                    if (res >= 15 && res <= 30) {
                        Respirationcolor.setColorFilter(Color.WHITE);
                        resRate = 0;
                        updateScore(o2Score, bpScore, resRate, heartScore, temp, cLevel);
                    } else if (res >= 10 && res <= 40) {
                        Respirationcolor.setColorFilter(Color.YELLOW);
                        resRate = 1;
                        updateScore(o2Score, bpScore, resRate, heartScore, temp, cLevel);
                    } else if (res < 50 && res >= 40) {
                        Respirationcolor.setColorFilter(Color.rgb(242, 109, 0));
                        resRate = 2;
                        updateScore(o2Score, bpScore, resRate, heartScore, temp, cLevel);
                    } else {
                        Respirationcolor.setColorFilter(Color.RED);
                        resRate = 3;
                        updateScore(o2Score, bpScore, resRate, heartScore, temp, cLevel);
                    }
                }
            }

        });

        //if and else statements HEART RATE
        final TextView Heartrate = findViewById(R.id.editText11);
        Heartrate.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int res = Integer.parseInt(Heartrate.getText().toString());
                ImageView Heartratecolor = findViewById(R.id.imageView4);
                //TextView t2 = findViewById(R.id.textView4);
                //t2.setText(Integer.toString(res));

                if(res>=70&&res<=110){
                    Heartratecolor.setColorFilter(Color.WHITE);
                    heartScore =0;
                    updateScore(o2Score, bpScore, resRate, heartScore, temp, cLevel);
                }else if(res>=50&&res<=130){
                    Heartratecolor.setColorFilter(Color.YELLOW);
                    heartScore =1;
                    updateScore(o2Score, bpScore, resRate, heartScore, temp, cLevel);
                }else if(res<150&&res>=130){
                    Heartratecolor.setColorFilter(Color.rgb(242,109,0));
                    heartScore=2;
                    updateScore(o2Score, bpScore, resRate, heartScore, temp, cLevel);
                }else{
                    Heartratecolor.setColorFilter(Color.RED);
                    heartScore=3;
                    updateScore(o2Score, bpScore, resRate, heartScore, temp, cLevel);
                }
            }
        });
 //
        //if and else statements TEMPERATURE
        final TextView Temperature = findViewById(R.id.editText12);
        Temperature.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int res = Integer.parseInt(Temperature.getText().toString());
                ImageView Temperaturecolor = findViewById(R.id.imageView5);
                //TextView t2 = findViewById(R.id.textView4);
                //t2.setText(Integer.toString(res));

                if(res>=36.1&&res<=38){
                    Temperaturecolor.setColorFilter(Color.WHITE);
                    temp =0;
                    updateScore(o2Score, bpScore, resRate, heartScore, temp, cLevel);
                }else if(res>=35.1&&res<=39){
                    Temperaturecolor.setColorFilter(Color.YELLOW);
                    temp =1;
                    updateScore(o2Score, bpScore, resRate, heartScore, temp, cLevel);
                }else if(res>=39.1){
                    Temperaturecolor.setColorFilter(Color.rgb(242,109,0));
                    temp=2;
                    updateScore(o2Score, bpScore, resRate, heartScore, temp, cLevel);
                }else{
                    Temperaturecolor.setColorFilter(Color.RED);
                    temp =3;
                    updateScore(o2Score, bpScore, resRate, heartScore, temp, cLevel);
                }
            }
        });

        //INSERT SPINNER FOR THIS INSTEAD
        //if and else statements CONSCIOUSNESS LEVEL

       final Spinner Clevel = findViewById(R.id.spinner1);
        Clevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView <?> parent, View view, int position, long id) {
                ImageView Clevelcolor = findViewById(R.id.imageView6);
                //TextView t2 = findViewById(R.id.textView4);
                //t2.setText(Integer.toString(res));

                if(position==0){
                    Clevelcolor.setColorFilter(Color.WHITE);
                    cLevel=0;
                    updateScore(o2Score, bpScore, resRate, heartScore, temp, cLevel);
                }else if(position==1){
                    Clevelcolor.setColorFilter(Color.YELLOW);
                    cLevel=1;
                    updateScore(o2Score, bpScore, resRate, heartScore, temp, cLevel);
                }else{
                    Clevelcolor.setColorFilter(Color.RED);
                    cLevel =3;
                    updateScore(o2Score, bpScore, resRate, heartScore, temp, cLevel);
                }
            }

            @Override
            public void onNothingSelected(AdapterView <?> parent) {

            }

        });










//IF ELSE STATEMENTS NEEDED HERE IN ORDER TO SWITCH TO THE RIGHT PAGE DEPENDING ON WHAT STAGE OF SEPSIS THEY'RE IN
        Button btn = findViewById(R.id.btnNext);//button to get to the next page
        btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i("App", "sepsis");
                        Toast.makeText(getApplicationContext(), "Results", Toast.LENGTH_LONG)
                                .show();

                        Intent i = new Intent(SecondActivity.this, ThirdActivity.class);
                        i.putExtra("totalScore", Integer.toString(totalScore));
                       startActivity(i);//moves to the last page






        }

        });
    }
}














