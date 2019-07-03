package com.cscr.cscr.my;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.List;


public class Main3Activity extends AppCompatActivity {
    private ListView listView;
    SearchView searchView;
    // VideoView videoView;
    //ArrayList<String> videoList;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        final List<String> quotes;
        Bundle bundle = getIntent().getExtras();
        final int typeOfList = bundle.getInt("typeOfList");
        final int Flag = bundle.getInt("Flag");
        this.listView = (ListView) findViewById(R.id.listView);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        if ( typeOfList == 999) {
            if (Flag == 1) {
                quotes = databaseAccess.getWord(typeOfList);
            } else if (Flag == 2) {
                quotes = databaseAccess.getNumber(typeOfList);
            } else if (Flag == 3) {
                quotes = databaseAccess.getColors(typeOfList);
            } else if (Flag == 4) {
                quotes = databaseAccess.getAnimal(typeOfList);
            } else if (Flag == 5) {
                quotes = databaseAccess.getBodyPart(typeOfList);
            } else if (Flag == 6) {
                quotes = databaseAccess.getDays(typeOfList);
            } else if (Flag == 7) {
                quotes = databaseAccess.getMonths(typeOfList);
            } else if (Flag == 8) {
                quotes = databaseAccess.getFestivals(typeOfList);
            } else if (Flag == 9) {
                quotes = databaseAccess.getFood(typeOfList);
            } else if (Flag == 10) {
                quotes = databaseAccess.getVehicles(typeOfList);
            } else if (Flag == 11) {
                quotes = databaseAccess.getSports(typeOfList);
            } else if (Flag == 12) {
                quotes = databaseAccess.getCricketTerms(typeOfList);
            } else if (Flag == 13) {
                quotes = databaseAccess.getcCCommonTerms(typeOfList);
            } else if (Flag == 14) {
                quotes = databaseAccess.getIndiaOtherCities(typeOfList);
            } else if (Flag == 15) {
                quotes = databaseAccess.getIndiaStatesCaps(typeOfList);
            } else if (Flag == 16) {
                quotes = databaseAccess.getSomeFamousPlaces(typeOfList);
            } else if (Flag == 17) {
                quotes = databaseAccess.getWorldCountriesCities(typeOfList);
            } else if (Flag == 18) {
                quotes = databaseAccess.getJobs(typeOfList);
            } else if (Flag == 19) {
                quotes = databaseAccess.getRelationships(typeOfList);
            } else if (Flag == 20) {
                quotes = databaseAccess.getFamousPeople(typeOfList);
            } else if (Flag == 21) {
                quotes = databaseAccess.getBrands(typeOfList);
            } else if (Flag == 22) {
                quotes = databaseAccess.getClothes(typeOfList);
            } else if (Flag == 23) {
                quotes = databaseAccess.getBasicPhrases(typeOfList);
            }else {
                quotes = databaseAccess.getEnglishIdioms(typeOfList);
            }
        }
        else if ( typeOfList== 998 || typeOfList == 997)
        {
            quotes = databaseAccess.getPair(typeOfList);
        }
        else if ( typeOfList == 996)
        {
            if ( Flag == 1)
            {
                quotes = databaseAccess.getMath();
            }
            else if ( Flag == 2)
            {
                quotes = databaseAccess.getScience();
            }
            else if ( Flag == 3)
            {
                quotes = databaseAccess.getGeography();
            }
            else
            {
                quotes = databaseAccess.getHistory();
            }
        }
        else
        {
            quotes = databaseAccess.getWord(typeOfList);
        }
        //  final List<String> videoall = databaseAccess.videoall();
        databaseAccess.close();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, quotes);
        this.listView.setAdapter(adapter);
        //videoView = (VideoView) findViewById(R.id.videoView);
        searchView=(SearchView)findViewById(R.id.searchView);
        // final MediaController m;
        // m = new MediaController(this);

/////////////////////////////////////////////////////////////////////
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                // if(list.contains(query)){
             /*   if (videoList.contains(s)) {
                    //adapter.getFilter().filter(query);
                    adapter.getFilter().filter(s);
                } else {
                    Toast.makeText(Main3Activity.this, "No Match found", Toast.LENGTH_LONG).show();
                }
             */

                return false;
            }


            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }


        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String selecteditem=(String)parent.getItemAtPosition(position);
                int t= quotes.indexOf(selecteditem);

                Bundle bundle = new Bundle();
                bundle.putInt("position",t);
                bundle.putInt("typeOfList",typeOfList);
                bundle.putInt("Flag",Flag);
                Intent i;
                if ( typeOfList == 3)
                    i = new Intent(Main3Activity.this,Main4Activity.class);
                else if ( typeOfList == 998 || typeOfList == 997)
                    i = new Intent(Main3Activity.this, MainWordAntonymsPairActivity.class);
                else
                    i= new Intent( Main3Activity.this,Main4Activity_alt.class);
                i.putExtras(bundle);
                startActivity(i);


                //     videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/raw/" + videoall.get(t)));

                //   videoView.setMediaController(new MediaController(Main3Activity.this));
                //  videoView.requestFocus();
                //   videoView.start();
            }
        });

    }

}