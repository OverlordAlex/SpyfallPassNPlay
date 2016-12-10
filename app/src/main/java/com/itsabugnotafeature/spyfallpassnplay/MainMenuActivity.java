package com.itsabugnotafeature.spyfallpassnplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        String[] places = getResources().getStringArray(R.array.places);
        Random r = new Random();
        int choice = r.nextInt(places.length);
        final String place = places[choice];
        final EditText numberofPlayer = (EditText) findViewById(R.id.inputNumber);


        final Button button = (Button) findViewById(R.id.buttonStart);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final int numPlayers = Integer.parseInt(numberofPlayer.getText().toString());

                Random r = new Random();
                final int spy = r.nextInt(numPlayers);

                // Perform action on click
                Intent intent = new Intent(MainMenuActivity.this, PasstonextplayerActivity.class);
                intent.putExtra("place", place);
                intent.putExtra("players", numPlayers);
                intent.putExtra("currentplayer", 0);
                intent.putExtra("spy", spy);
                startActivity(intent);
            }
        });
    }
}
