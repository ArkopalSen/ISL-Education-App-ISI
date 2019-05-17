package com.cscr.cscr.my;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;


public class Safe extends AppCompatActivity {
    private ListView listView;
    SearchView searchView;
    VideoView videoView;
    ArrayList<String> videoList;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Bundle bundle = getIntent().getExtras();
        int typeOfList = bundle.getInt("typeOfList");
        /*Intent i=getIntent();
        Bundle b= i.getExtras();
        int typeOfList = b.getInt("typeOfList");*/


        this.listView = (ListView) findViewById(R.id.listView);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<String> quotes = databaseAccess.getWord(typeOfList);
        final List<String> videoall = databaseAccess.videoall();
        databaseAccess.close();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, quotes);
        this.listView.setAdapter(adapter);
        videoView = (VideoView) findViewById(R.id.videoView);
        searchView=(SearchView)findViewById(R.id.searchView);
        final MediaController m;
        m = new MediaController(this);

/////////////////////////////////////////////////////////////////////
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextSubmit(String s) {
                // if(list.contains(query)){
                if (videoList.contains(s)) {
                    //adapter.getFilter().filter(query);
                    adapter.getFilter().filter(s);
                } else {
                    Toast.makeText(Safe.this, "No Match found", Toast.LENGTH_LONG).show();
                }


                return false;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/raw/" + videoall.get(position)));

                videoView.setMediaController(new MediaController(Safe.this));
                videoView.requestFocus();
                videoView.start();
            }
        });
        //                return true;
        //
        //                        searchManager.getSearchableInfo(getComponentName()));
        //                searchView.setSearchableInfo(
        //                        (SearchView) menu.findItem(R.id.search).getActionView();
        //                SearchView searchView =
        //                        (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        //                SearchManager searchManager =
        //                // Associate searchable configuration with the SearchView
        //
        //                inflater.inflate(R.id.options_menu, menu);
        //                MenuInflater inflater = getMenuInflater();
        //            public boolean onCreateOptionsMenu(Menu menu) {
//            @Override

//            }


//
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//                adapter.getFilter().filter(s);
//                // Result.values = Filtered_Names;
//                //            Result.count = Filtered_Names.size();
//
//                //return new filter(s);
//                //return videoView;
//                return false;
//            }
//        });

////////////////////////////////////////////////////////////////////////////////
    }

}