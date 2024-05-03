package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class prog extends AppCompatActivity {
    Button chris,dead,gi,lat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progm);
        chris=findViewById(R.id.chrisimg);
        dead=findViewById(R.id.deadimg);
        gi=findViewById(R.id.giimg);
        lat=findViewById(R.id.latimg);

        lat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(prog.this,pushpull.class);
                startActivity(i);
            }
        });
        gi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(prog.this,brosplit.class);
                startActivity(i);
            }
        });
        dead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(prog.this,fullbody.class);
                startActivity(i);
            }
        });
        chris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(prog.this,upperlower.class);
                startActivity(i);
            }
        });
    }
}