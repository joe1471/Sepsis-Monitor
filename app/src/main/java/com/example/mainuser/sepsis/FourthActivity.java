package com.example.mainuser.sepsis;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.LogRecord;

public class FourthActivity extends Activity {


    private int seconds = 0;

    public Button btn;
    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");

        }

        Timer();


        Button btn = findViewById(R.id.btnFinish);//button to get to the first page
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("App", "sepsis");
                Toast.makeText(getApplicationContext(), "NEW", Toast.LENGTH_LONG)
                        .show();
                startActivity(new Intent(FourthActivity.this, FirstActivity.class));

            }
        });
    }


    public void onSaveInstanceState(Bundle saveInstanceState) {
        saveInstanceState.putInt("seconds", seconds);

    }



    private void Timer() {
        final TextView time_view = findViewById(R.id.textView20);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                String time = String.format("%02d:%02d:%02d", hours, minutes, secs);

                time_view.setText(time);


                    seconds++;


                handler.postDelayed(this, 100);
            }
        });
   /* public void onSaveInstanceState(Bundle saveInstanceState){
        saveInstanceState.putInt("seconds", seconds);
        saveInstanceState.putBoolean("startRun", startRun);
    }

    public void onClickstart (View view){ startRun=true; }

    public void onClickstop(View view){
        startRun=false;
    }

    public void onClickreset(View view){
        startRun=false;
        seconds=0;
    }

    private void Timer(){
        final TextView time_view = findViewById(R.id.textView15);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;

                String time = String.format("%02d:%02d:%02d", hours, minutes, secs);

                time_view.setText(time);

                if(startRun){
                    seconds++;
                }

                handler.postDelayed(this, 100);
            }
        });
        {
            Button btn = findViewById(R.id.btnFinish);//button to get to the first page
            btn.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v) {
                    Log.i("App", "sepsis");
                    Toast.makeText(getApplicationContext(), "NEW", Toast.LENGTH_LONG)
                            .show();
                    startActivity(new Intent(FourthActivity.this, FirstActivity.class));

                })
            });

       /* public final void dialogbox(View View);{

                Button btn = findViewById(R.id.btnFinish);
                btn.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder= new AlertDialog.Builder(ThirdActivity.this);
                        AlertDialog.setMessage("Are you sure you want to exit?").setCancelable(false)
                                .setPositiveButton("Yes",new DialogInterface.OnClickListener(){
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener(){

                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alert = AlertDialog.create();
                    }
                });

        }

    } */


    }
}





