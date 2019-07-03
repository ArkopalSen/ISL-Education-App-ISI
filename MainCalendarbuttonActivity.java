package com.cscr.cscr.my;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainCalendarbuttonActivity extends AppCompatActivity {
    Button days, months, festivals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calendarbutton);
        days = findViewById(R.id.buttonDays);
        months = findViewById(R.id.buttonMonths);
        festivals = findViewById(R.id.buttonFestival);
        days.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("typeOfList", 999);
                bundle.putInt("Flag",6);
                Intent i= new Intent(MainCalendarbuttonActivity.this,Main3Activity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        months.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("typeOfList", 999);
                bundle.putInt("Flag",7);
                Intent i= new Intent(MainCalendarbuttonActivity.this,Main3Activity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        festivals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("typeOfList", 999);
                bundle.putInt("Flag",8);
                Intent i= new Intent(MainCalendarbuttonActivity.this,Main3Activity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
}
