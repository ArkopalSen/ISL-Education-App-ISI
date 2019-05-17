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

        Bundle bundle = getIntent().getExtras();
        final int typeOfList = bundle.getInt("typeOfList");
        this.listView = (ListView) findViewById(R.id.listView);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        final List<String> quotes = databaseAccess.getWord(typeOfList);
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
                Intent i= new Intent(Main3Activity.this,Main4Activity.class);
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