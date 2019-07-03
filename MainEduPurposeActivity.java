package com.cscr.cscr.my;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainEduPurposeActivity extends AppCompatActivity {
    Button math, science, geography, history;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_edu_purpose);
        math = findViewById(R.id.buttonM);
        science = findViewById(R.id.buttonS);
        geography = findViewById(R.id.buttonG);
        history = findViewById(R.id.buttonH);
        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("typeOfList", 996);
                bundle.putInt("Flag",1);
                Intent i= new Intent(MainEduPurposeActivity.this,Main3Activity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("typeOfList", 996);
                bundle.putInt("Flag",2);
                Intent i= new Intent(MainEduPurposeActivity.this,Main3Activity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        geography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("typeOfList", 996);
                bundle.putInt("Flag",3);
                Intent i= new Intent(MainEduPurposeActivity.this,Main3Activity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("typeOfList", 996);
                bundle.putInt("Flag",4);
                Intent i= new Intent(MainEduPurposeActivity.this,Main3Activity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
}
