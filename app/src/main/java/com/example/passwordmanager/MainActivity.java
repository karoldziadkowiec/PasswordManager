package com.example.passwordmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Account> accounts = prepareData();
    Button goToListActivityButton;
    Button exitButton;
    EditText pinEditText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToListActivityButton = findViewById(R.id.logInButton);
        exitButton = findViewById(R.id.exitButton);
        pinEditText = findViewById(R.id.pinEditText);

        goToListActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredPin = pinEditText.getText().toString();
                if (enteredPin.equals("")) {
                    Intent intent = new Intent(MainActivity.this, ListActivity.class);
                    intent.putExtra("accounts", (Serializable) accounts);
                    startActivity(intent);
                    showMessage("Welcome to Password Manager!");
                } else {
                    showMessage("Incorrect PIN. Try again.");
                }
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessage("See you soon!");
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
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

    private void showMessage(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}