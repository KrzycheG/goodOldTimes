package com.example.goodoldtimes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {

    public static final int peasant = R.raw.peasantquotes;
    public static final int witchDoctor = R.raw.witchdoctor;
    public static final int peon = R.raw.peonquotes;
    public static final int dreadLord = R.raw.dreadlord;
    public static final int acolyte = R.raw.acolytequotes;
    public static final int knight = R.raw.knightquotes;

    Button Peasant;
    Button WitchDoctor;
    Button Peon;
    Button DreadLord;
    Button Acolyte;
    Button Knight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Peasant = (Button) findViewById(R.id.Peasant);
        WitchDoctor = (Button) findViewById(R.id.WitchDoctor);
        Peon = (Button) findViewById(R.id.Peon);
        DreadLord = (Button) findViewById(R.id.DreadLord);
        Acolyte = (Button) findViewById(R.id.Acolyte);
        Knight = (Button) findViewById(R.id.Knight);

    }
    public void playSound(Context context, Integer soundId){

        MediaPlayer player = MediaPlayer.create( context, soundId );
        player.start();

    }
    public void sound(View view){

        int counter = 0 ;

        if(Peasant.getId() == view.getId()){

            counter = peasant;

        }else if(WitchDoctor.getId() == view.getId()){

            counter = witchDoctor;

        }else if(Peon.getId() == view.getId()){

            counter = peon;

        }else if(DreadLord.getId() == view.getId()){

            counter = dreadLord;

        }else if(Acolyte.getId() == view.getId()){

            counter = acolyte;
        }else if(Knight.getId() == view.getId()){

            counter = knight;
        }

        playSound(this, counter );


    }
}