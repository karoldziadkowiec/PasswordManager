package com.example.passwordmanager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.List;

public class AddAccountActivity extends AppCompatActivity {
    List<Account> accounts;
    EditText pageNameEditText;
    EditText loginEditText;
    EditText passwordEditText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);

        accounts = (List<Account>) getIntent().getSerializableExtra("accounts");

        Button addButton = findViewById(R.id.addButton);
        Button backButton = findViewById(R.id.backButton);
        pageNameEditText = findViewById(R.id.pageNameEditText);
        loginEditText = findViewById(R.id.loginEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pageName = pageNameEditText.getText().toString();
                String login = loginEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (!pageName.isEmpty() && !login.isEmpty() && !password.isEmpty()) {
                    Account newAccount = new Account(accounts.size() + 1, pageName, login, password);
                    accounts.add(newAccount);

                    Intent intent = new Intent(AddAccountActivity.this, ListActivity.class);
                    intent.putExtra("accounts", (Serializable) accounts);
                    startActivity(intent);

                    showMessage("The " + newAccount.getPageName() + " account has been added.");
                } else {
                    showMessage("Please fill in all fields.");
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddAccountActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showMessage(String message) {
        Toast.makeText(AddAccountActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
