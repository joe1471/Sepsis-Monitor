package com.example.mainuser.sepsis;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends Activity {

    private int seconds = 0;

    public Button btn;
    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;
    private boolean alarm=false;
    MediaPlayer mp;

    private void alarm(){
        mp.start();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        mp =MediaPlayer.create(this, R.raw.alarm);

        Intent i = getIntent();
        if (Integer.parseInt((String)i.getExtras().get("totalScore")) < 2) {
            TextView t = findViewById(R.id.textView10);
            t.setText("Check up on patient in 12 hours");
        }else if (Integer.parseInt((String)i.getExtras().get("totalScore")) == 2) {
            TextView t = findViewById(R.id.textView10);
            t.setText("Check up on patient in 6 Hours");
        }else if(Integer.parseInt((String)i.getExtras().get("totalScore")) == 3) {
            TextView t = findViewById(R.id.textView10);
            t.setText("Check up on patient in 4 Hours");
        }else if(Integer.parseInt((String)i.getExtras().get("totalScore"))> 4 && Integer.parseInt((String)i.getExtras().get("totalScore"))<=6) {
            TextView t = findViewById(R.id.textView10);
            t.setText("Check up on patient in 1 Hour");
        }else{
            TextView t = findViewById(R.id.textView10);
            t.setText("Check up on patient in 30 minutes");
        }

        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");

        }

        Timer();


            Button btn = findViewById(R.id.btnFinish);//button to get to the first page
            btn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                    Log.i("App", "sepsis");
                    Toast.makeText(getApplicationContext(), "NEW", Toast.LENGTH_LONG)
                            .show();
                    mp.stop();
                    startActivity(new Intent(ThirdActivity.this, FirstActivity.class));

                }
            });
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
        mp.stop();
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
                Intent i = getIntent();
                if (Integer.parseInt((String)i.getExtras().get("totalScore")) < 2 && hours>=12 && alarm==false) {
                    alarm();
                    alarm=true;
                }else if (Integer.parseInt((String)i.getExtras().get("totalScore")) == 2 && hours>=6 && alarm==false) {
                    alarm();
                    alarm=true;
                }else if(Integer.parseInt((String)i.getExtras().get("totalScore")) == 3 && hours>=4 && alarm==false) {
                    alarm();
                    alarm=true;
                }else if(Integer.parseInt((String)i.getExtras().get("totalScore"))> 4 && Integer.parseInt((String)i.getExtras().get("totalScore"))<=6 && hours>=1 && alarm==false) {
                    alarm();
                    alarm=true;
                }
                else if (seconds>=30 && alarm==false){
                    alarm();
                    alarm=true;
                }

                time_view.setText(time);


                    seconds++;


                handler.postDelayed(this, 1000);
            }
        });

//Try to get the alarm to work once the set time has been reached
        /*Context context;
        alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmManager.class);
        alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        alarmMgr.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                AlarmClock.ACTION_SET_ALARM(+));
                        60 * 1000, alarmIntent);*/



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
                }); */


    }

    ;
}



























