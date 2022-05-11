package com.example.geriatric_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class Register extends AppCompatActivity {
    EditText username,password,phone,email;
    Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username=findViewById(R.id.user_name);
        password=findViewById(R.id.login_password);
        phone=findViewById(R.id.phone);
        email=findViewById(R.id.email);
        register=findViewById(R.id.register_btn);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser user= new ParseUser();
                user.setUsername(username.getText().toString());
                user.setPassword(password.getText().toString());
                user.setEmail(email.getText().toString());
                user.put("Phone", phone.getText().toString());
                user.signUpInBackground(new SignUpCallback()
                {
                    @Override
                    public void done(ParseException e) {
                        if(e==null)
                        {
                            Toast.makeText(Register.this, "REGISTERED", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            ParseUser.logOut();
                            Toast.makeText(Register.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });



    }
}