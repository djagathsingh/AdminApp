package com.example.adminapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class login_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
    }

    public static String DBNAME = "admindb.db";
    public static String TBNAME = "admin";
    public static final int DBVERSION = 1;

    String col1 = "username";
    String col2 = "password";

    public void loginFunc(View view) {
        TextView name =  findViewById(R.id.username);
        TextView password = findViewById(R.id.password);
        TextView wrong = findViewById(R.id.wrong);
        AdminModel input = new AdminModel(name.getText().toString(),password.getText().toString());
        DBHelper helper = new DBHelper(login_activity.this,DBNAME,null,DBVERSION);
        if(helper.checkUser(input) == 0){
            Intent i = new Intent(login_activity.this, AdminMain.class);
            startActivity(i);
        }
        else{
            name.setText("");
            password.setText("");
            wrong.setText(R.string.wrong_credentials);
        }
    }

    public void registerFunc(View view){
        Intent i = new Intent(login_activity.this, Register.class);
        startActivity(i);
    }
}