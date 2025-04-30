package com.example.virtualpet;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class PetStoreActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_store);
    }
    public void buyItem(View view) {
        Toast.makeText(this, "Item purchased!", Toast.LENGTH_SHORT).show();
    }
}
