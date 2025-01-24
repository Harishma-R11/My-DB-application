package com.harishma11.mydbapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        TextView welcome = findViewById(R.id.welcomeText);
        SharedPreferences preferences = getSharedPreferences("DBApp", Context.MODE_PRIVATE);

        String savedName = preferences.getString("name", "no");
        welcome.setText("Hi, Welcome " + savedName);



    }
}