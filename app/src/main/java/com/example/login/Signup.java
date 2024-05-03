package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.login.DB.Database;


public class  Signup extends AppCompatActivity {
    EditText fullname,email,phone,passwordd;
    Database o;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        Database o = new Database(this);
        findViewById(R.id.signup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Signup.this, Login.class);
                fullname=(EditText)findViewById(R.id.fname);
                email=(EditText)findViewById(R.id.emaile);
                phone=(EditText)findViewById(R.id.Ph);
                passwordd=(EditText)findViewById(R.id.mdp);
                String n= o.insert_data(fullname.getText().toString(),email.getText().toString(), Integer.parseInt(phone.getText().toString()),passwordd.getText().toString());

               startActivity(intent);




            }
        });
        }





    }
