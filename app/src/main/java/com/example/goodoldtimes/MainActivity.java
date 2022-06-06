package com.example.goodoldtimes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity  {

    public static final int peasant = R.raw.peasantquotes;
    public static final int witchDoctor = R.raw.witchdoctor;
    public static final int peon = R.raw.peonquotes;
    public static final int dreadLord = R.raw.dreadlord;
    public static final int acolyte = R.raw.acolytequotes;
    public static final int knight = R.raw.knightquotes;

    static final int readBlockSize = 100;
    private static final String fileName= "nazwaPliku.txt";
    public EditText editText;

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
        editText = findViewById(R.id.editTextTextPersonName2);

    }
    public void playSound(Context context, Integer soundId){

        MediaPlayer player = MediaPlayer.create( context, soundId );
        player.start();

    }

    public void Save(View v) {
        String text = editText.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(fileName, MODE_PRIVATE);
            fos.write(text.getBytes());
            editText.getText().clear();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void Read(View v) {
        try {
            FileInputStream fis = openFileInput(fileName);
            InputStreamReader isr = new InputStreamReader((fis));
            char[] inputBuffer = new char[readBlockSize];
            String s = "";
            int charRead;
            while ((charRead = isr.read(inputBuffer)) > 0) {

                String readString = String.copyValueOf(inputBuffer, 0, charRead);
                s += readString;
            }
            isr.close();
            Toast.makeText(getBaseContext(), s, Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sequence(View v) {
        try {
            FileInputStream fis = openFileInput(fileName);
            InputStreamReader isr = new InputStreamReader((fis));
            char[] inputBuffer = new char[readBlockSize];
            String s = "";
            int charRead;
            while ((charRead = isr.read(inputBuffer)) > 0) {

                String readString = String.copyValueOf(inputBuffer, 0, charRead);
                s += readString;

            }
            char chars[]=s.toUpperCase().toCharArray();
            for (char ch : chars) {
                if (ch == 'A') {
                    playSound(this, peasant);
                    Thread.sleep(40000 );
                }
                if (ch == 'B') {
                    playSound(this, witchDoctor);
                    Thread.sleep(40000 );
                }
                if (ch == 'C') {
                    playSound(this, peon);
                    Thread.sleep(40000);
                }
                if (ch == 'D') {
                    playSound(this, dreadLord);
                    Thread.sleep(40000);
                }
                if (ch == 'E') {
                    playSound(this, acolyte);
                    Thread.sleep(40000);
                }
                if (ch == 'F') {
                    playSound(this, knight);
                    Thread.sleep(40000);
                }
            }
            isr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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