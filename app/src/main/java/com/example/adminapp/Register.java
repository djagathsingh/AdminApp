package com.example.adminapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public static String DBNAME = "admindb.db";
    public static String TBNAME = "admin";
    public static final int DBVERSION = 1;

    String col1 = "username";
    String col2 = "password";


    public void registerFunc1(View view) {
        TextView name = findViewById(R.id.register_username);
        TextView password = findViewById(R.id.register_password);
        TextView error = findViewById(R.id.register_error);
        AdminModel input = new AdminModel(name.getText().toString(),password.getText().toString());
        DBHelper helper = new DBHelper(Register.this,DBNAME,null,DBVERSION);
        if(helper.insertUser(input) == -1){
            name.setText("");
            password.setText("");
            error.setText(R.string.register_failed);
        }
        else{
            Toast.makeText(Register.this, "Entry done!", Toast.LENGTH_LONG).show();
            Intent i = new Intent(Register.this,login_activity.class);
            startActivity(i);
        }
    }

}