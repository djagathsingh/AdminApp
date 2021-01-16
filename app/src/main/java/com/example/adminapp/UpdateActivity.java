
package com.example.adminapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
    }

    public static String DBNAME = "admindb.db";
    public static String TBNAME = "admin";
    public static final int DBVERSION = 1;


    public void update(View view) {
        TextView name = findViewById(R.id.update_username);
        TextView password = findViewById(R.id.update_password);
        TextView password1 = findViewById(R.id.update_password1);
        TextView error = findViewById(R.id.update_error);

        AdminModel input = new AdminModel(name.getText().toString(),password.getText().toString());
        AdminModel input1 = new AdminModel();
        input1.setPassword(password1.getText().toString());
        DBHelper helper = new DBHelper(UpdateActivity.this,DBNAME,null,DBVERSION);

        if(helper.updateUser(input,input1) == -1){
            name.setText("");
            password.setText("");
            password1.setText("");
            error.setText("The agent details entered does not exist!");
        }
        else{
            Toast.makeText(UpdateActivity.this, "Update done!", Toast.LENGTH_LONG).show();
            Intent i = new Intent(UpdateActivity.this, AdminMain.class);
            startActivity(i);
        }
    }
    public void logout(View view) {
        Intent i = new Intent(UpdateActivity.this, login_activity.class);
        startActivity(i);
    }
}