package com.hari.musicplayerassignment;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MusicPlayer extends AppCompatActivity implements View.OnClickListener,SeekBar.OnSeekBarChangeListener  {
    Button b1,b2,b3;
    int i1,i2,i3;
    SeekBar sb;

    android.os.Handler seekHandler;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        getInitialized();
        seekUpdation();
        player();
        Intent songs=getIntent();
        i1=songs.getIntExtra("first",0);
        i2=songs.getIntExtra("second",0);
        i3=songs.getIntExtra("third",0);

    }
    public void   getInitialized()
    {

            b1 = (Button) findViewById(R.id.buttonPause);
            b2 = (Button) findViewById(R.id.buttonPlay);
            b3 = (Button) findViewById(R.id.buttonStop);
            b1.setOnClickListener(this);
            b2.setOnClickListener(this);
            b3.setOnClickListener(this);


    }
    public void player()
    {
        if(i1==1) {

            mp = MediaPlayer.create(this, R.raw.sleepaway);
            sb = (SeekBar) findViewById(R.id.seekBar);
            sb.setMax(mp.getDuration());
            sb.setOnSeekBarChangeListener(this);
        }else if (i2==2)
        {
            mp = MediaPlayer.create(this, R.raw.kalimba);
            sb = (SeekBar) findViewById(R.id.seekBar);
            sb.setMax(mp.getDuration());
            sb.setOnSeekBarChangeListener(this);
        }
        else if (i3==3)
        {
            mp = MediaPlayer.create(this, R.raw.maidwiththeflaxenhair);
            sb = (SeekBar) findViewById(R.id.seekBar);
            sb.setMax(mp.getDuration());
            sb.setOnSeekBarChangeListener(this);
        }
    }
    Runnable run=new Runnable() {
        @Override
        public void run() {
            seekUpdation();
        }
    } ;
    public void seekUpdation()
    {
        sb.setProgress(mp.getCurrentPosition());
        seekHandler.postDelayed(run, 1000);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.buttonPause)
        {
            mp.pause();
        }
        else if(v.getId()==R.id.buttonPlay)
        {
            mp.start();
        }
        else if(v.getId()==R.id.buttonStop)
        {
            mp.stop();
            getInitialized();
            seekUpdation();
        }

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        try
        {
            if(mp.isPlaying() || mp != null) {
                if (fromUser)
                    mp.seekTo(progress);
            }
            else  if (mp==null) {

                seekBar.setProgress(0);

            }
        }catch (Exception e)
        {
            seekBar.setEnabled(false);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

}
