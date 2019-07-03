package com.cscr.cscr.my;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.Uri;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.VideoView;
import java.util.ArrayList;
import java.util.List;

public class Main4Activity_alt extends AppCompatActivity {
    VideoView videoView;
    TextView wordTextView;
    ScrollView scrollView;
    ImageButton start_stop;
    ArrayList<String> videoList;

    private void initializeViews(){
        videoView = findViewById(R.id.videoView);
        start_stop = findViewById(R.id.startButton);
        scrollView = findViewById(R.id.scrollView);
        wordTextView = findViewById(R.id.wordTextView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4_alt);
        initializeViews();
        final List<String> word;
        final List<String> video;
        Bundle bundle = getIntent().getExtras();
        int position = bundle.getInt("position");
        int typeofList=bundle.getInt("typeOfList");
        int Flag = bundle.getInt("Flag");
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        if ( typeofList == 999) {
            if (Flag == 1) {
                word = databaseAccess.getWord(typeofList);
                video = databaseAccess.videoall();
            } else if (Flag == 2) {
                word = databaseAccess.getNumber(typeofList);
                video = databaseAccess.videoNumber(typeofList);
            } else if (Flag == 3) {
                word = databaseAccess.getColors(typeofList);
                video = databaseAccess.videoColours(typeofList);
            } else if (Flag == 4) {
                word = databaseAccess.getAnimal(typeofList);
                video = databaseAccess.videoAnimals(typeofList);
            } else if (Flag == 5) {
                word = databaseAccess.getBodyPart(typeofList);
                video = databaseAccess.videoBodyPart(typeofList);
            } else if (Flag == 6) {
                word = databaseAccess.getDays(typeofList);
                video = databaseAccess.videoDays(typeofList);
            } else if (Flag == 7) {
                word = databaseAccess.getMonths(typeofList);
                video = databaseAccess.videoMonths(typeofList);
            } else if (Flag == 8) {
                word = databaseAccess.getFestivals(typeofList);
                video = databaseAccess.videoFestivals(typeofList);
            } else if (Flag == 9) {
                word = databaseAccess.getFood(typeofList);
                video = databaseAccess.videoFood(typeofList);
            } else if (Flag == 10) {
                word = databaseAccess.getVehicles(typeofList);
                video = databaseAccess.videoVehicles(typeofList);
            } else if (Flag == 11) {
                word = databaseAccess.getSports(typeofList);
                video = databaseAccess.videoSports(typeofList);
            } else if (Flag == 12) {
                word = databaseAccess.getCricketTerms(typeofList);
                video = databaseAccess.videoCricketTerms(typeofList);
            } else if (Flag == 13) {
                word = databaseAccess.getcCCommonTerms(typeofList);
                video = databaseAccess.videoCCommonTerms(typeofList);
            } else if (Flag == 14) {
                word = databaseAccess.getIndiaOtherCities(typeofList);
                video = databaseAccess.videoCOtherCities(typeofList);
            } else if (Flag == 15) {
                word = databaseAccess.getIndiaStatesCaps(typeofList);
                video = databaseAccess.videoIndiaStatesCaps(typeofList);
            } else if (Flag == 16) {
                word = databaseAccess.getSomeFamousPlaces(typeofList);
                video = databaseAccess.videoSomeFamousPlaces(typeofList);
            } else if (Flag == 17) {
                word = databaseAccess.getWorldCountriesCities(typeofList);
                video = databaseAccess.videoWorldCountries(typeofList);
            } else if (Flag == 18) {
                word = databaseAccess.getJobs(typeofList);
                video = databaseAccess.videoJobs(typeofList);
            } else if (Flag == 19) {
                word = databaseAccess.getRelationships(typeofList);
                video = databaseAccess.videoRelationships(typeofList);
            } else if (Flag == 20) {
                word = databaseAccess.getFamousPeople(typeofList);
                video = databaseAccess.videoFamousPeople(typeofList);
            } else if (Flag == 21) {
                word = databaseAccess.getBrands(typeofList);
                video = databaseAccess.videoBrands(typeofList);
            } else if (Flag == 22) {
                word = databaseAccess.getClothes(typeofList);
                video = databaseAccess.videoClothes(typeofList);
            } else if (Flag == 23) {
                word = databaseAccess.getBasicPhrases(typeofList);
                video = databaseAccess.videoBasicPhrases(typeofList);
            }else {
                word = databaseAccess.getEnglishIdioms(typeofList);
                video = databaseAccess.videoEnglishIdioms(typeofList);
            }
        }
        else if ( typeofList == 996)
        {
            if ( Flag == 1)
            {
                word = databaseAccess.getMath();
                video = databaseAccess.videoMath();
            }
            else if ( Flag == 2)
            {
                word = databaseAccess.getScience();
                video = databaseAccess.videoScience();
            }
            else if ( Flag == 3)
            {
                word = databaseAccess.getGeography();
                video = databaseAccess.videoGeography();
            }
            else
            {
                word = databaseAccess.getHistory();
                video = databaseAccess.videoHistory();
            }
        }
        else
        {
            word = databaseAccess.getWord(typeofList);
            video = databaseAccess.videoall();
        }

        //final List<String> word = databaseAccess.getWord(typeofList);

        wordTextView.setText(word.get(position));


        //final List<String> video = databaseAccess.videoall();
        databaseAccess.close();

        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/raw/" + video.get(position)));
        videoView.setMediaController(new MediaController(Main4Activity_alt.this));
        videoView.requestFocus();
        videoView.start();
        start_stop.setImageResource(R.mipmap.pause_video_button);
        start_stop.setOnClickListener(new View.OnClickListener() {

            public void onClick( View v) {
                if(videoView.isPlaying()){
                    videoView.pause();
                    start_stop.setImageResource(R.mipmap.play_video_button);
                }
                else {
                    videoView.start();
                    start_stop.setImageResource(R.mipmap.pause_video_button);
                }
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                start_stop.setImageResource(R.mipmap.play_video_button);
            }
        });
    }
}
