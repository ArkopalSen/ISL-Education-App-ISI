package com.cscr.cscr.my;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import java.util.ArrayList;
import java.util.List;


public class Main4Activity extends AppCompatActivity {
    VideoView videoView;
    TextView wordTextView, typeTextView, synTextView, antTextView, exampleTextView,exampleAntTextView;
    ScrollView scrollView;
    ImageButton start_stop;
    ArrayList<String> videoList;

    private void initializeViews(){
        videoView = findViewById(R.id.videoView);
        start_stop = findViewById(R.id.startButton);
        scrollView = findViewById(R.id.scrollView);
        wordTextView = findViewById(R.id.wordTextView);
        typeTextView = findViewById(R.id.typeTextView);
        synTextView = findViewById(R.id.synTextView);
        antTextView = findViewById(R.id.antTextView);
        exampleTextView = findViewById(R.id.exampleTextView);
        exampleAntTextView=findViewById(R.id.exampleAntTextView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        initializeViews();

        Bundle bundle = getIntent().getExtras();
        int position = bundle.getInt("position");
        int typeofList=bundle.getInt("typeOfList");
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        final List<String> word = databaseAccess.getWord(typeofList);
        final List<String> BenType = databaseAccess.getWord(16);
        final List<String> BenSyn= databaseAccess.getWord(13);
        final List<String> BenAnt= databaseAccess.getWord(14);
        final List<String> BenExa= databaseAccess.getWord(15);
        final List<String> BenAntExa= databaseAccess.getWord(17);

        wordTextView.setText(word.get(position));
        typeTextView.setText("Type:\n" + BenType.get(position));
        synTextView.setText("Synonyms:\n" + BenSyn.get(position));
        antTextView.setText("Antonyms:\n" + BenAnt.get(position));
        exampleTextView.setText("Examples-Synonyms:\n" + BenExa.get(position));
        exampleAntTextView.setText("Examples-Antonyms:\n" + BenAntExa.get(position));

        final List<String> videoall = databaseAccess.videoall();
        databaseAccess.close();

        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/raw/" + videoall.get(position)));
        videoView.setMediaController(new MediaController(Main4Activity.this));
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
