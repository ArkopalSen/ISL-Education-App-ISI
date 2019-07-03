package com.cscr.cscr.my;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainCountriesCitiesActivity extends AppCompatActivity {
    Button commonTerms, otherCities, indStatesCaps, famousPlaces, worldCountries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_countries_cities);
        commonTerms = findViewById(R.id.buttonCommonTerms);
        otherCities = findViewById(R.id.buttonOtherC);
        indStatesCaps = findViewById(R.id.buttonIndStatesCaps);
        famousPlaces = findViewById(R.id.buttonFamousPlaces);
        worldCountries = findViewById(R.id.buttonWorldCC);
        commonTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("typeOfList", 999);
                bundle.putInt("Flag",13);
                Intent i= new Intent(MainCountriesCitiesActivity.this,Main3Activity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        otherCities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("typeOfList", 999);
                bundle.putInt("Flag",14);
                Intent i= new Intent(MainCountriesCitiesActivity.this,Main3Activity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        indStatesCaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("typeOfList", 999);
                bundle.putInt("Flag",15);
                Intent i= new Intent(MainCountriesCitiesActivity.this,Main3Activity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        famousPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("typeOfList", 999);
                bundle.putInt("Flag",16);
                Intent i= new Intent(MainCountriesCitiesActivity.this,Main3Activity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        worldCountries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("typeOfList", 999);
                bundle.putInt("Flag", 17);
                Intent i= new Intent(MainCountriesCitiesActivity.this,Main3Activity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
}
