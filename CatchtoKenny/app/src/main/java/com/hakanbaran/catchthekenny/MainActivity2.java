package com.hakanbaran.catchthekenny;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    TextView timeText;
    TextView scoreText;
    int score;
    ImageView kenny1;
    ImageView kenny2;
    ImageView kenny3;
    ImageView kenny4;
    ImageView kenny5;
    ImageView kenny6;
    ImageView kenny7;
    ImageView kenny8;
    ImageView kenny9;
    ImageView[] kennyArray;
    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        timeText = findViewById(R.id.time);
        scoreText = findViewById(R.id.score);
        score = 0;
        kenny1 = findViewById(R.id.kenny);
        kenny2 = findViewById(R.id.kenny2);
        kenny3 = findViewById(R.id.kenny3);
        kenny4 = findViewById(R.id.kenny4);
        kenny5 = findViewById(R.id.kenny5);
        kenny6 = findViewById(R.id.kenny6);
        kenny7 = findViewById(R.id.kenny7);
        kenny8 = findViewById(R.id.kenny8);
        kenny9 = findViewById(R.id.kenny9);
        kennyArray = new ImageView[]{kenny1,kenny2,kenny3,kenny4,kenny5,kenny6,kenny7,kenny8,kenny9};
        Image();


        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long l) {
                timeText.setText("Time: " + l/1000);

            }

            @Override
            public void onFinish() {
                handler.removeCallbacks(runnable);
                for (ImageView kenny : kennyArray){
                    kenny.setVisibility(View.INVISIBLE);
                }

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity2.this);
                alert.setTitle("Restart Game?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent3 = getIntent();
                        finish();
                        startActivity(intent3);

                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent2 = new Intent(MainActivity2.this,MainActivity.class);
                        startActivity(intent2);

                    }
                });
                alert.show();

            }
        }.start();
    }

    public void ScoreKenny(View view){

        score++;
        scoreText.setText("Score: " + score);
    }
    public void Image() {

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView kenny : kennyArray){
                    kenny.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int k = random.nextInt(9);
                kennyArray[k].setVisibility(View.VISIBLE);
                handler.postDelayed(runnable,500);
            }

        };
        handler.post(runnable);

    }


}