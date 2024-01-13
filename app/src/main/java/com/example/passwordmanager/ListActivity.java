package com.example.passwordmanager;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private static final String KEY_ACCOUNTS = "key_accounts";
    private List<Account> accounts;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        if (savedInstanceState != null) {
            accounts = (List<Account>) savedInstanceState.getSerializable(KEY_ACCOUNTS);
        } else {
            accounts = (List<Account>) getIntent().getSerializableExtra("accounts");
        }

        Button addAccountButton = findViewById(R.id.addAccountButton);
        Button logOutButton = findViewById(R.id.logOutButton);
        ListView accountsListView = findViewById(R.id.accountsListView);

        CustomAdapter adapter = new CustomAdapter();
        accountsListView.setAdapter(adapter);

        accountsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Account selectedAccount = accounts.get(position);
                showMessage("Login: " + selectedAccount.getLogin() + "\nPassword: " + selectedAccount.getPassword());
            }
        });

        addAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, AddAccountActivity.class);
                intent.putExtra("accounts", (Serializable) accounts);
                startActivity(intent);
            }
        });

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                showMessage("Log out successfully.");
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(KEY_ACCOUNTS, (Serializable) accounts);
    }

    private void showMessage(String message) {
        Toast.makeText(ListActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return accounts.size();
        }

        @Override
        public Object getItem(int position) {
            return accounts.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(ListActivity.this).inflate(R.layout.activity_item_list, parent, false);
            }

            TextView accountTextView = convertView.findViewById(R.id.accountTextView);
            ImageButton deleteButton = convertView.findViewById(R.id.deleteButton);

            Account account = accounts.get(position);
            accountTextView.setText(account.getPageName());

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    accounts.remove(position);
                    notifyDataSetChanged();
                }
            });

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Account selectedAccount = accounts.get(position);
                    showMessage("Login: " + selectedAccount.getLogin() + "\nPassword: " + selectedAccount.getPassword());
                }
            });

            return convertView;
        }
    }
}
