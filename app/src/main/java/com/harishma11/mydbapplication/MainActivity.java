package com.harishma11.mydbapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EditText userName = findViewById(R.id.et_username);
        EditText password = findViewById(R.id.et_password);
        EditText mobNum = findViewById(R.id.et_mobNum);
        Button signButton = findViewById(R.id.Sign);
        TextView text = findViewById(R.id.textWel);
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("DBApp", Context.MODE_PRIVATE);

        signButton.setOnClickListener(v ->{
            String name = userName.getText().toString();
            String passWord = password.getText().toString();
            String number = mobNum.getText().toString();
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("name", name);
            editor.putString("passWord", passWord);
            editor.putString("number", number);
            editor.apply();

        });
        String savedName = preferences.getString("name","no");
        String savedPassword = preferences.getString("passWord","no");
        String savedNumber= preferences.getString("number","no");
        text.setText("Welcome");
        if(!savedName.equals("no") && !savedPassword.equals("no")
         && !savedNumber.equals("no")){
            startActivity(new Intent(getApplicationContext(), MainActivity2.class));
        }

    }
}