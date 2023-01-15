package com.example.myapplication;

import static com.example.myapplication.MainActivity.ciekawostka;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button europaB = findViewById(R.id.Eu_button);
        Button amerykaB = findViewById(R.id.Am_button);
        Button ciekawB = findViewById(R.id.Ciek_button);
        Button wrocB = findViewById(R.id.ES_button);
        Button resetB = findViewById(R.id.Reset_button);


        europaB.setOnClickListener(this);
        amerykaB.setOnClickListener(this);
        ciekawB.setOnClickListener(this);
        wrocB.setOnClickListener(this);
        resetB.setOnClickListener(this);

    }

    public void onClick(View view){
        Intent intent = null;

        switch (view.getId()) {
            case R.id.Eu_button:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.Am_button:
                intent = new Intent(this, AmActivity.class);
                startActivity(intent);
                break;

            case R.id.Ciek_button:
                intent = new Intent(this, CiekawActivity.class);
                startActivity(intent);
                break;

            case R.id.ES_button:
                intent = new Intent(this, EkranStartActivity.class);
                startActivity(intent);
                break;

            case R.id.Reset_button:
                Arrays.fill(ciekawostka, 0);
                Toast.makeText(MenuActivity.this, "Zresetowano postęp" , Toast.LENGTH_LONG).show();

                break;
        }

    }
}