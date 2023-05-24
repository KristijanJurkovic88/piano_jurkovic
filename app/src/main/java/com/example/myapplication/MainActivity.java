package com.example.myapplication;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MediaPlayer[] mediaPlayers;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize MediaPlayer array with 8 sounds
        mediaPlayers = new MediaPlayer[8];
        mediaPlayers[0] = MediaPlayer.create(this, R.raw.sound1);
        mediaPlayers[1] = MediaPlayer.create(this, R.raw.sound2);
        mediaPlayers[2] = MediaPlayer.create(this, R.raw.sound3);
        mediaPlayers[3] = MediaPlayer.create(this, R.raw.sound4);
        mediaPlayers[4] = MediaPlayer.create(this, R.raw.sound5);
        mediaPlayers[5] = MediaPlayer.create(this, R.raw.sound6);
        mediaPlayers[6] = MediaPlayer.create(this, R.raw.sound7);
        mediaPlayers[7] = MediaPlayer.create(this, R.raw.sound8);

        // Set click listeners for each button
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(this);

        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(this);

        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(this);

        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(this);

        Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                playSound(0);
                break;
            case R.id.button2:
                playSound(1);
                break;
            case R.id.button3:
                playSound(2);
                break;
            case R.id.button4:
                playSound(3);
                break;
            case R.id.button5:
                playSound(4);
                break;
            case R.id.button6:
                playSound(5);
                break;
            case R.id.button7:
                playSound(6);
                break;
            case R.id.button8:
                playSound(7);
                break;
            default:
                break;
        }
    }

    private void playSound(int index) {
        if (mediaPlayers[index] != null) {
            mediaPlayers[index].seekTo(0);
            mediaPlayers[index].start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Release MediaPlayer resources
        for (MediaPlayer mediaPlayer : mediaPlayers) {
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
        }
    }
}
