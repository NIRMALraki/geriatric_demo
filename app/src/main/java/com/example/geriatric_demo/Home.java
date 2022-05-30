package com.example.geriatric_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseUser;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TextView map = findViewById(R.id.map) ;

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Map.class);
                startActivity(i);

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ParseUser.logOut();
        Toast.makeText(getApplicationContext(), "Logged out", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }
}