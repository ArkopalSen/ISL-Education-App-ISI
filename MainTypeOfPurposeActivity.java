package com.cscr.cscr.my;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainTypeOfPurposeActivity extends AppCompatActivity {

    Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_type_of_purpose);
        b1 = findViewById(R.id.buttonGenPur);
        b2 = findViewById(R.id.buttonEduPur);
        b3 = findViewById(R.id.buttonAntonyms);
        b4 = findViewById(R.id.buttonMathsRelated);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent(MainTypeOfPurposeActivity.this,MainGenPurposeActivity.class);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent(MainTypeOfPurposeActivity.this,MainEduPurposeActivity.class);
                startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                bundle.putInt("typeOfList", 998);
                Intent i= new Intent(MainTypeOfPurposeActivity.this,Main3Activity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                bundle.putInt("typeOfList", 997);
                Intent i= new Intent(MainTypeOfPurposeActivity.this,Main3Activity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
}
