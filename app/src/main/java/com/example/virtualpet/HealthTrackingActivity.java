package com.example.virtualpet;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class HealthTrackingActivity extends AppCompatActivity {
    private ProgressBar healthBar;
    private TextView healthStatus;
    private ImageView petHealthImage;
    private MediaPlayer eatingSound, playSound;

    private int petHealth = 80;
    private int petHappiness = 50;
    private int petAge = 2;

    private final Handler handler = new Handler();
    private final Runnable healthDecreaseTask = new Runnable() {

        @Override
        public void run() {
            if (petHealth > 0) {
                petHealth -= 5; // ✅ Decrease health every 10 seconds
                updateHealthStatus();
            }
            handler.postDelayed(this, 10000); // Runs every 10 seconds
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(healthDecreaseTask, 10000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(healthDecreaseTask);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_tracking);

        healthBar = findViewById(R.id.healthBar);
        healthStatus = findViewById(R.id.healthStatus);
        petHealthImage = findViewById(R.id.petHealthImage);

        eatingSound = MediaPlayer.create(this, R.raw.eating_sound);
        playSound = MediaPlayer.create(this, R.raw.play_sound);

        updateHealthStatus();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (eatingSound != null) {
            eatingSound.release();
            eatingSound = null;
        }
        if (playSound != null) {
            playSound.release();
            playSound = null;
        }
    }

    public void feedPet(View view) {
        if (petHealth < 100) {
            petHealth = Math.min(petHealth + 10, 100); // ✅ Ensures max is 100
            petHappiness = Math.min(petHappiness + 5, 100);

            updateHealthStatus();
            eatingSound.start();

            Animation bounce = AnimationUtils.loadAnimation(this, R.anim.bounce);
            petHealthImage.startAnimation(bounce);

            Toast.makeText(this, "Pet is happy after eating!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Pet is already full!", Toast.LENGTH_SHORT).show();
        }
    }

    public void playWithPet(View view) {
        if (petHappiness < 100) {
            petHappiness = Math.min(petHappiness + 10, 100); // ✅ Ensures max is 100
            petHealth = Math.min(petHealth + 5, 100);

            updateHealthStatus();
            playSound.start();

            Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
            petHealthImage.startAnimation(shake);

            Toast.makeText(this, "Pet enjoyed playing!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Pet is already very happy!", Toast.LENGTH_SHORT).show();
        }
    }


    private void updateHealthStatus() {
        healthBar.setProgress(petHealth);

        if (petHealth >= 80) {
            healthStatus.setText("Healthy! (" + petHealth + "%)");
            petHealthImage.setImageResource(R.drawable.healthy_pet);
        } else if (petHealth >= 50) {
            healthStatus.setText("Feeling Okay. (" + petHealth + "%)");
            petHealthImage.setImageResource(R.drawable.normal_pet);
        } else {
            healthStatus.setText("Sick! Take care. (" + petHealth + "%)");
            petHealthImage.setImageResource(R.drawable.sick_pet);
        }
    }

}