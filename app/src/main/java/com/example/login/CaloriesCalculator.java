package com.example.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class CaloriesCalculator extends AppCompatActivity {
    Button C;
    EditText t1,t2,t3,t4;

    TextView result;
    int Calories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calories_calculator);
        C=(Button)findViewById(R.id.calcul);
        t1=(EditText)findViewById(R.id.age);
        t2=(EditText)findViewById(R.id.taille);
        t3=(EditText)findViewById(R.id.poids);
        t4=(EditText)findViewById(R.id.sex);
        result=(TextView)findViewById(R.id.result);

        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sex=t4.getText().toString();

                int age=Integer.parseInt(t1.getText().toString());
                int height =Integer.parseInt(t2.getText().toString());
                int poids=Integer.parseInt(t3.getText().toString());
                    if (sex.equals("m")){
                        Calories= (int) ((10* poids) + (6.25 *height) -(5 * age) + 5);
                        result.setText("You should eat "+Calories+"Kcal a day");

                    } else if (sex.equals("f")) {
                        Calories= (int) ((10* poids) + (6.25 *height) -(5 * age) -161);
                        result.setText("You should eat "+Calories+"Kcal a day");

                    }else{
                        Toast.makeText(CaloriesCalculator.this, "Invalid Input !!", Toast.LENGTH_SHORT).show();
                    }
                }








        });


    }
}