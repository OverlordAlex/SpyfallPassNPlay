package com.itsabugnotafeature.spyfallpassnplay;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameTimerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_timer);

        final Button button = (Button) findViewById(R.id.buttonDone);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent = new Intent(GameTimerActivity.this, MainMenuActivity.class);
                startActivity(intent);
            }
        });

        final TextView countdown = (TextView) findViewById(R.id.textViewCountdown);
        new CountDownTimer(480001, 1000) {

            public void onTick(long millisUntilFinished) {
                Integer minutes = (int) ((millisUntilFinished / 1000) / 60);
                Integer seconds = (int) ((millisUntilFinished / 1000) % 60);

                countdown.setText(Integer.toString(minutes) + ":" + Integer.toString(seconds));
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                countdown.setText("DONE");
            }

        }.start();
    }


}
