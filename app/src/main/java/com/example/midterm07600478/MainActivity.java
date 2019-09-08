package com.example.midterm07600478;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.midterm07600478.Model.Auth;

public class MainActivity extends AppCompatActivity {
    private static final String EMAIL = "bbb";
    private static final String PASSWORD = "222";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast t = Toast.makeText(MainActivity.this, "Welcome Promlert Lovichit", Toast.LENGTH_SHORT);
        t.show();
        Button loginButton = findViewById(R.id.Login_botton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText userEdittext = findViewById(R.id.email_edit_text);
                EditText passwordEdittext = findViewById(R.id.password_edit_text);
                String inputuser = userEdittext.getText().toString();
                String inputpass = passwordEdittext.getText().toString();
                Auth auth = new Auth(inputuser, inputpass);
                final boolean result = auth.check();
                if (result) {
                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                    intent.putExtra("aaa", inputuser);
                    startActivity(intent);
                    finish();
                    Toast.makeText(MainActivity.this, "ยินดีต้อนรับ", Toast.LENGTH_SHORT).show();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("Error");
                    dialog.setMessage("Invalid email or password");
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show();
                }

            });




}
/*
EditText userEdittext = findViewById(R.id.user_edit_text);
                EditText passwordEdittext = findViewById(R.id.password_edit_text);
                String inputuser = userEdittext.getText().toString();
                String inputpass = passwordEdittext.getText().toString();
                Auth auth = new Auth(inputuser,inputpass);
                final boolean result = auth.check();
                if(result){
                    Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
                    intent.putExtra("aaa", inputuser);
                    startActivity(intent);
                    finish();
                    Toast.makeText(MainActivity.this,"ยินดีต้อนรับ",Toast.LENGTH_SHORT).show();
                }
                else {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("Error");
                    dialog.setMessage("Invalid email or password");
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show()
 */