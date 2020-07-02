package com.example.applylistview.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.applylistview.R;
import com.example.applylistview.ui.family.FamilyActivity;
import com.example.applylistview.ui.numbers.NumbersActivity;
import com.example.applylistview.ui.phrases.PhraseAvtivity;
import com.example.applylistview.ui.play.PlayActivity;

public class MainActivity extends AppCompatActivity {

    Button numbers, phrase, play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numbers = findViewById(R.id.number_activity);
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(intent);
            }
        });

        phrase = findViewById(R.id.phrase_activity);
        phrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, PhraseAvtivity.class);
                startActivity(intent);
            }
        });

        play = findViewById(R.id.play_activity);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(intent);
            }
        });
    }
}