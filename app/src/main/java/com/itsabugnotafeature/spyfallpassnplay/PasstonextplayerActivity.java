package com.itsabugnotafeature.spyfallpassnplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PasstonextplayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passtonextplayer);

        final String place = getIntent().getStringExtra("place");
        final Integer numPlayers = getIntent().getIntExtra("players", -1);
        final Integer currentplayer = getIntent().getIntExtra("currentplayer", -1);
        final Integer spy = getIntent().getIntExtra("spy", -1);

        final Button button = (Button) findViewById(R.id.buttonNextPlayer);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent = new Intent(PasstonextplayerActivity.this, PlayerRoleActivity.class);
                intent.putExtra("place", place);
                intent.putExtra("players", numPlayers);
                intent.putExtra("currentplayer", currentplayer);
                intent.putExtra("spy", spy);
                startActivity(intent);
            }
        });
    }
}
