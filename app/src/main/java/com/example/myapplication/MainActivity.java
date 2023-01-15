package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myapplication.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_TEXT = "com.example.myapplication.example.EXTRA_TEXT";
    public static final String EXTRA_TEXT2 = "com.example.myapplication.example.EXTRA_TEXT2";
    public static final String EXTRA_NUMBER = "com.example.myapplication.example.EXTRA_NUMBER";
    public static final String EXTRA_NUMBER2 = "com.example.myapplication.example.EXTRA_NUMBER2";


    ActivityMainBinding binding;
    public static int g;
    public static int[] ciekawostka = {0,0,0,0,0,0,0};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);



        ImageView iV1 = findViewById(R.id.albania);
        ImageView iV2 = findViewById(R.id.france);
        ImageView iV3 = findViewById(R.id.germany);
        ImageView iV4 = findViewById(R.id.italy);
        ImageView iV5 = findViewById(R.id.poland);
        ImageView iV6 = findViewById(R.id.romania);
        ImageView iV7 = findViewById(R.id.spain);

        iV1.setOnClickListener(this);
        iV2.setOnClickListener(this);
        iV3.setOnClickListener(this);
        iV4.setOnClickListener(this);
        iV5.setOnClickListener(this);
        iV6.setOnClickListener(this);
        iV7.setOnClickListener(this);

        Button menuButton = findViewById(R.id.menuButton);

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

    }



    public void onClick(View v) {

        int i = 100;
        String name = null;
        String capital = null;
        int ImId = 0;
        int FlId = 0;
        boolean trivia = false;

        int[] ImageId = {R.drawable.albanias, R.drawable.francess, R.drawable.germanyss,
                R.drawable.italyss, R.drawable.polandss, R.drawable.romaniass,
                R.drawable.spains};
        int[] FlagId = {R.drawable.albaniaf, R.drawable.francef, R.drawable.germanyf,
                R.drawable.italyf, R.drawable.polandf, R.drawable.romaniaf,
                R.drawable.spainf};
        String[] nazwa = {"Albania", "Francja", "Niemcy", "Wlochy", "Polska", "Rumunia", "Hiszpania"};
        String[] stolica = {"Tirana", "Paryz", "Berlin", "Rzym", "Warszawa", "Bukareszt", "Madryt"};

        Intent intent = new Intent(this, KrajeActivity.class);


        switch (v.getId()) {
            case R.id.albania:
                i = 0;
                break;
            case R.id.france:
                i = 1;
                break;
            case R.id.germany:
                i = 2;
                break;
            case R.id.italy:
                i = 3;
                break;
            case R.id.poland:
                i = 4;
                break;
            case R.id.romania:
                i = 5;
                break;
            case R.id.spain:
                i = 6;
                break;
        }

        name = nazwa[i];
        capital = stolica[i];
        ImId = ImageId[i];
        FlId = FlagId[i];
        g = i;
        intent.putExtra(EXTRA_TEXT, name);
        intent.putExtra(EXTRA_TEXT2, capital);
        intent.putExtra(EXTRA_NUMBER, ImId);
        intent.putExtra(EXTRA_NUMBER2, FlId);
        startActivity(intent);
    }
}


