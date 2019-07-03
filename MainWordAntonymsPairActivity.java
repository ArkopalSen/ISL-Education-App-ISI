package com.cscr.cscr.my;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.List;

public class MainWordAntonymsPairActivity extends AppCompatActivity {
    Button  w, anto;
    TextView tword, tantonym;
    ImageButton start_stop;
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_word_antonyms_pair);
        w = findViewById(R.id.wordButton);
        anto = findViewById(R.id.antButton);
        videoView = findViewById(R.id.videoViewWAP);
        start_stop = findViewById(R.id.startWAPButton);
        tword = findViewById(R.id.wordPairTextView);
        tantonym = findViewById(R.id.antPairTextView);
        final List<String> word, antonym;
        Bundle bundle = getIntent().getExtras();
        final int position = bundle.getInt("position");
        final int typeOfList = bundle.getInt("typeOfList");
        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        final List<String> videoword = databaseAccess.videoWord(typeOfList);
        final List<String> videoAnto = databaseAccess.videoAnto(typeOfList);
        word = databaseAccess.getWordPair(typeOfList);
        antonym = databaseAccess.getAntoPair(typeOfList);
        tword.setText("Word:\n" + word.get(position));
        tantonym.setText("Antonym:\n" + antonym.get(position));
        databaseAccess.close();
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/raw/" + videoword.get(position)));
        videoView.setMediaController(new MediaController(MainWordAntonymsPairActivity.this));
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
        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                start_stop.setImageResource(R.mipmap.pause_video_button);
                videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/raw/" + videoword.get(position)));
                videoView.start();

            }
        });

        anto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                start_stop.setImageResource(R.mipmap.pause_video_button);
                videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/raw/" + videoAnto.get(position)));
                videoView.start();

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
