package com.example.virtualpet;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PetAdventureActivity extends AppCompatActivity {
    private TextView adventureResult;
    private int petHappiness = 50; // Default happiness (without database)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_adventure);

        adventureResult = findViewById(R.id.adventureResult);
    }

    public void goToForest(View view) {
        petHappiness += 10; // Increase happiness
        adventureResult.setText("Your pet explored the forest and found a magical fruit!");
        Toast.makeText(this, "Happiness +10", Toast.LENGTH_SHORT).show();
    }

    public void goToBeach(View view) {
        petHappiness += 15;
        adventureResult.setText("Your pet played in the waves and made a sandcastle!");
        Toast.makeText(this, "Happiness +15", Toast.LENGTH_SHORT).show();
    }

    public void goToMountains(View view) {
        petHappiness += 20;
        adventureResult.setText("Your pet climbed the mountains and enjoyed the view!");
        Toast.makeText(this, "Happiness +20", Toast.LENGTH_SHORT).show();
    }
}
