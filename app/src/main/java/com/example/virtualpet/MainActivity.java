package com.example.virtualpet;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openStore(View view) {
        startActivity(new Intent(this, PetStoreActivity.class));
    }
    public void openCustomization(View view) {
        startActivity(new Intent(this, PetAdventureActivity.class));
    }
    public void openHealthTracking(View view) {
        startActivity(new Intent(this, HealthTrackingActivity.class));
    }
}
