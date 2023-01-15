package com.example.myapplication;

import static com.example.myapplication.MainActivity.ciekawostka;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class CiekawActivity extends AppCompatActivity {


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciekaw);
        int[] ciekaw = {R.id.albania, R.id.francja, R.id.niemcy, R.id.wlochy, R.id.polska, R.id.rumunia, R.id.hiszpania};

        for (int i = 0; i < ciekaw.length; i++) {
            if(ciekawostka[i]==1) {
                findViewById(ciekaw[i]).setVisibility(View.VISIBLE);
            }
        }

    }

}


