package com.example.adminapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DeleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
    }

    public static String DBNAME = "admindb.db";
    public static String TBNAME = "admin";
    public static final int DBVERSION = 1;

    String col1 = "username";
    String col2 = "password";

    public void delete(View view) {
        TextView name = findViewById(R.id.delete_username);
        TextView password = findViewById(R.id.delete_password);
        TextView error = findViewById(R.id.delete_error);
        AdminModel input = new AdminModel(name.getText().toString(),password.getText().toString());
        DBHelper helper = new DBHelper(DeleteActivity.this,DBNAME,null,DBVERSION);
        if(helper.deleteUser(input) == -1){
            name.setText("");
            password.setText("");
            error.setText("Could not find your agent.");
        }
        else{
            Toast.makeText(DeleteActivity.this, "Agent deleted!!", Toast.LENGTH_LONG).show();
            Intent i = new Intent(DeleteActivity.this, AdminMain.class);
            startActivity(i);
        }
    }

    public void logout(View view) {
        Intent i = new Intent(DeleteActivity.this, login_activity.class);
        startActivity(i);
    }
}