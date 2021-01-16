package com.example.adminapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowActivity extends AppCompatActivity {

    public static String DBNAME = "admindb.db";
    public static String TBNAME = "admin";
    public static final int DBVERSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        TextView t = findViewById(R.id.display_text);
        DBHelper helper = new DBHelper(ShowActivity.this,DBNAME,null,DBVERSION);
        String op = helper.display();
        t.setText(op);
    }
    public void logout(View view) {
        Intent i = new Intent(ShowActivity.this, login_activity.class);
        startActivity(i);
    }
}