package com.example.adminapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AdminMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
    }

    public void insertfunc(View view) {
        Intent i = new Intent(AdminMain.this, InsertActivity.class);
        startActivity(i);
    }

    public void updatefunc(View view) {
        Intent i = new Intent(AdminMain.this, UpdateActivity.class);
        startActivity(i);
    }

    public void deletefunc(View view) {
        Intent i = new Intent(AdminMain.this, DeleteActivity.class);
        startActivity(i);
    }

    public void showfunc(View view) {
        Intent i = new Intent(AdminMain.this, ShowActivity.class);
        startActivity(i);
    }

    public void logout(View view) {
        Intent i = new Intent(AdminMain.this, login_activity.class);
        startActivity(i);
    }
}