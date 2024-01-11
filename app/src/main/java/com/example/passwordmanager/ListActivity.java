package com.example.passwordmanager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ListActivity extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Button addAccountButton = findViewById(R.id.addAccountButton);

        addAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obsługa kliknięcia przycisku "Add Account"
                Intent intent = new Intent(ListActivity.this, AddAccountActivity.class);
                startActivity(intent);
            }
        });
    }
}
