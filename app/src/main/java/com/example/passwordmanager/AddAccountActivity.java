package com.example.passwordmanager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AddAccountActivity extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);

        Button addButton = findViewById(R.id.addButton);
        Button backButton = findViewById(R.id.backButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obsługa kliknięcia przycisku "Add"
                Intent intent = new Intent(AddAccountActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obsługa kliknięcia przycisku "Back"
                Intent intent = new Intent(AddAccountActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
    }
}
