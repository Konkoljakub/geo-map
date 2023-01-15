package com.example.myapplication;


import static com.example.myapplication.MainActivity.ciekawostka;
import static com.example.myapplication.MainActivity.g;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;


public class KrajeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kraje);

        ImageView mapki = findViewById(R.id.ImId);
        ImageView flagi = findViewById(R.id.FlId);

        EditText editText1 = findViewById(R.id.input_capital);
        EditText editText2 = findViewById(R.id.input_country);
        Button button = findViewById(R.id.button);
        Button hint = findViewById(R.id.hint);
        Button menuButton = findViewById(R.id.menuButton);

        Intent intent = getIntent();

        String name = intent.getStringExtra(MainActivity.EXTRA_TEXT);
        String capital = intent.getStringExtra(MainActivity.EXTRA_TEXT2);
        int ImId = intent.getIntExtra(MainActivity.EXTRA_NUMBER, R.drawable.albanias);
        int FlId = intent.getIntExtra(MainActivity.EXTRA_NUMBER2, R.drawable.albaniaf);

        mapki.setImageResource(ImId);
        flagi.setImageResource(FlId);

 
        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flagi.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            flagi.setVisibility(View.INVISIBLE);
                        }
                    },3000);
            }
        });

        menuButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KrajeActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kraje = editText2.getText().toString();
                String stolice = editText1.getText().toString();
                if(TextUtils.isEmpty(kraje) || TextUtils.isEmpty(stolice))
                {
                    Toast.makeText(KrajeActivity.this, "Nie wprowadzono danych", Toast.LENGTH_LONG).show();
                }
                else if(kraje.equals(name))  {
                    if(stolice.equals(capital)){
                        Toast.makeText(KrajeActivity.this, "Odblokowano ciekawostkę: "+kraje, Toast.LENGTH_LONG).show();
                        ciekawostka[g] = 1;
                    }else{
                        Toast.makeText(KrajeActivity.this, "Nieprawidlowa stolica", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(KrajeActivity.this, "Spróbuj ponownie", Toast.LENGTH_LONG).show();
                }
            }
        });




    }

}
