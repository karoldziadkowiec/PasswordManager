package com.example.passwordmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Account> accounts = prepareData();
    Button goToListActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToListActivityButton = findViewById(R.id.button);

        // Dodaj obsługę kliknięcia przycisku
        goToListActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Przeniesienie do nowej aktywności (ListActivity)
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
    }

    public static List<Account> prepareData() {
        List<Account> newAccounts = new ArrayList<>();

        Account acc1 = new Account(1, "Facebook", "xyz@gmail.com", "password123");
        Account acc2 = new Account(2, "Instagram", "xyz@gmail.com", "pass456");
        Account acc3 = new Account(3, "Gmail", "xyz@gmail.com", "secretPass");

        newAccounts.add(acc1);
        newAccounts.add(acc2);
        newAccounts.add(acc3);

        return newAccounts;
    }
}