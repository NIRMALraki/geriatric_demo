package com.example.geriatric_demo;

import androidx.appcompat.app.AppCompatActivity;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {
    TextView signup;
    EditText name,password;
    Button login;
    NotificationManagerCompat notificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         signup=findViewById(R.id.register);
         name=findViewById(R.id.name);
         password=findViewById(R.id.login_password);
         login=findViewById(R.id.login_button);
        notificationManager  = NotificationManagerCompat.from(this);


        login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 ParseUser.logInInBackground(name.getText().toString(), password.getText().toString(),(parseUser,e) ->{
                     if(parseUser != null)
                     {
                         Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                         Intent i = new Intent(getApplicationContext(),Home.class);
                         startActivity(i);
                         Notification notification= new NotificationCompat.Builder(getApplicationContext(),App.CHANNEL_1_ID)
                             .setSmallIcon(R.drawable.ic_baseline_notification)
                                 .setContentTitle("alert")
                                 .setContentText("You Have a Login ")
                                 .setPriority(NotificationCompat.PRIORITY_HIGH)
                                 .setCategory(NotificationCompat.CATEGORY_MESSAGE).build();
                         notificationManager.notify(1,notification);

                     }
                     else
                     {
                            ParseUser.logOut();
                         Toast.makeText(MainActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                         Intent i = new Intent(getApplicationContext(),Home.class);
                         startActivity(i);
                         Notification notification= new NotificationCompat.Builder(getApplicationContext(),App.CHANNEL_1_ID)
                                 .setSmallIcon(R.drawable.ic_baseline_notification)
                                 .setContentTitle("alert")
                                 .setContentText("error in login ")
                                 .setPriority(NotificationCompat.PRIORITY_HIGH)
                                 .setCategory(NotificationCompat.CATEGORY_MESSAGE).build();
                         notificationManager.notify(2,notification);
                     }
                 });


             }
         });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Register.class);
                startActivity(i);
            }
        });


    }
}