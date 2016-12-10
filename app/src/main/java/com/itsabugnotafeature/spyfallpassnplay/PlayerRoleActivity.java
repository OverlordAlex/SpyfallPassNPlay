package com.itsabugnotafeature.spyfallpassnplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlayerRoleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_role);

        final String place = getIntent().getStringExtra("place");
        final Integer numPlayers = getIntent().getIntExtra("players", -1);
        final Integer currentplayer = getIntent().getIntExtra("currentplayer", -1);
        final Integer spy = getIntent().getIntExtra("spy", -1);

        final TextView role = (TextView) findViewById(R.id.textPlayerRole);

        if (currentplayer == spy) {
            role.setText("SPY!");
        } else {
            role.setText(place);
        }


        final Button button = (Button) findViewById(R.id.buttonOK);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent;
                if (currentplayer == numPlayers - 1) {
                    intent = new Intent(PlayerRoleActivity.this, GameTimerActivity.class);
                } else {
                    intent = new Intent(PlayerRoleActivity.this, PasstonextplayerActivity.class);
                }



                intent.putExtra("place", place);
                intent.putExtra("players", numPlayers);
                intent.putExtra("currentplayer", currentplayer+1);
                intent.putExtra("spy", spy);
                startActivity(intent);
            }
        });
    }
}
