package com.cscr.cscr.my;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainSportsbuttonActivity extends AppCompatActivity {
    Button comSports, cricket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sportsbutton);
        comSports = findViewById(R.id.buttonCSports);
        cricket = findViewById(R.id.buttonCricketRelated);
        comSports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("typeOfList", 999);
                bundle.putInt("Flag",11);
                Intent i= new Intent(MainSportsbuttonActivity.this,Main3Activity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        cricket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("typeOfList", 999);
                bundle.putInt("Flag",12);
                Intent i= new Intent(MainSportsbuttonActivity.this,Main3Activity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
}
