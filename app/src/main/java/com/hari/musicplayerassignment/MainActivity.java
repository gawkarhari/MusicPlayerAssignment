package com.hari.musicplayerassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
Button b1,b2,b3;
    int fs=1;
    int ss=2;
    int ts=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getinitialize();

    }
public void getinitialize()
{
    b1=(Button)findViewById(R.id.buttonSong1);
    b2=(Button)findViewById(R.id.buttonSong2);
    b3=(Button)findViewById(R.id.buttonSong3);
    b1.setOnClickListener(this);
    b2.setOnClickListener(this);
    b3.setOnClickListener(this);

}
Intent i;
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonSong1:
            {
                i=new Intent(getApplicationContext(),MusicPlayer.class);
                i.putExtra("first",fs);
                startActivity(i);
            }
            case R.id.buttonSong2:
            {
                i=new Intent(getApplicationContext(),MusicPlayer.class);
                i.putExtra("second",ss);
                startActivity(i);
            }
            case R.id.buttonSong3:
            {
                i=new Intent(getApplicationContext(),MusicPlayer.class);
                i.putExtra("third",ts);
                startActivity(i);
            }
        }
    }
}
