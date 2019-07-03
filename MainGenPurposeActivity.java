package com.cscr.cscr.my;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainGenPurposeActivity extends AppCompatActivity {

    Button azbasic, numbers, colours, aniBirIns, bodyParts, calTime, foodBev, vehicles, sports, countriesCities, job, family, persona, brands, clothes, basicPhr, engIdioms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_gen_purpose);
        azbasic = findViewById(R.id.buttonAZ);
        bodyParts = findViewById(R.id.buttonBP);
        numbers = findViewById(R.id.buttonNum);
        colours = findViewById(R.id.buttonCol);
        aniBirIns = findViewById(R.id.buttonABI);
        calTime = findViewById(R.id.buttonCalTime);
        foodBev = findViewById(R.id.buttonFood);
        vehicles = findViewById(R.id.buttonVehi);
        sports = findViewById(R.id.buttonSpGa);
        countriesCities = findViewById(R.id.buttonCC);
        job = findViewById(R.id.buttonJob);
        family = findViewById(R.id.buttonRel);
        persona = findViewById(R.id.buttonPerson);
        brands = findViewById(R.id.buttonBrands);
        clothes = findViewById(R.id.buttonClo);
        basicPhr = findViewById(R.id.buttonPhrases);
        engIdioms = findViewById(R.id.buttonIdioms);
        azbasic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("typeOfList", 2);
                bundle.putInt("Flag",1);
                Intent i= new Intent(MainGenPurposeActivity.this,Main3Activity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("typeOfList", 999);
                bundle.putInt("Flag",2);
                Intent i= new Intent(MainGenPurposeActivity.this,Main3Activity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        colours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("typeOfList", 999);
                bundle.putInt("Flag",3);
                Intent i= new Intent(MainGenPurposeActivity.this,Main3Activity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        aniBirIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("typeOfList", 999);
                bundle.putInt("Flag",4);
                Intent i= new Intent(MainGenPurposeActivity.this,Main3Activity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        bodyParts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("typeOfList", 999);
                bundle.putInt("Flag",5);
                Intent i= new Intent(MainGenPurposeActivity.this,Main3Activity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        calTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent(MainGenPurposeActivity.this,MainCalendarbuttonActivity.class);
                startActivity(i);
            }
        });
        foodBev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("typeOfList", 999);
                bundle.putInt("Flag",9);
                Intent i= new Intent(MainGenPurposeActivity.this,Main3Activity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        vehicles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("typeOfList", 999);
                bundle.putInt("Flag",10);
                Intent i= new Intent(MainGenPurposeActivity.this,Main3Activity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent(MainGenPurposeActivity.this,MainSportsbuttonActivity.class);
                startActivity(i);
            }
        });
        countriesCities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent(MainGenPurposeActivity.this,MainCountriesCitiesActivity.class);
                startActivity(i);
            }
        });
        job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("typeOfList", 999);
                bundle.putInt("Flag",18);
                Intent i= new Intent(MainGenPurposeActivity.this,Main3Activity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("typeOfList", 999);
                bundle.putInt("Flag",19);
                Intent i= new Intent(MainGenPurposeActivity.this,Main3Activity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        persona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("typeOfList", 999);
                bundle.putInt("Flag",20);
                Intent i= new Intent(MainGenPurposeActivity.this,Main3Activity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        brands.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("typeOfList", 999);
                bundle.putInt("Flag",21);
                Intent i= new Intent(MainGenPurposeActivity.this,Main3Activity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        clothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("typeOfList", 999);
                bundle.putInt("Flag",22);
                Intent i= new Intent(MainGenPurposeActivity.this,Main3Activity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        basicPhr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("typeOfList", 999);
                bundle.putInt("Flag",23);
                Intent i= new Intent(MainGenPurposeActivity.this,Main3Activity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        engIdioms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("typeOfList", 999);
                bundle.putInt("Flag",24);
                Intent i= new Intent(MainGenPurposeActivity.this,Main3Activity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

    }
}
