package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.login.DB.Database;
import com.example.login.DB.users;

import java.util.ArrayList;

public class Login extends AppCompatActivity {
    EditText fullname,password;
    Database obj;
    int ok=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        obj=new Database(this);

       findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<users> arrayList=obj.get_data();

                Intent intent=new Intent();
                fullname=(EditText)findViewById(R.id.user);
                password=(EditText)findViewById(R.id.mdpp);
                for(int i=0;i<arrayList.size();i++)
                {

                    if(arrayList.get(i).getFname().equals(fullname.getText().toString())) {
                        if(arrayList.get(i).getPassword().equals(password.getText().toString()))
                        {
                            ok=0;
                            Intent a = new Intent(Login.this,Home.class);

                            startActivity(a);
                            Toast.makeText(Login.this, "login succefully", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
                if(ok==-1)
                {
                    Toast.makeText(Login.this, "fullname or password is wrong ", Toast.LENGTH_SHORT).show();
                }



            }
        });
        findViewById(R.id.supp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Login.this,Signup.class);
                startActivity(i);
            }
        });

    }
}