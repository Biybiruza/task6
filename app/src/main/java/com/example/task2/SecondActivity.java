package com.example.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvDescription;
    RatingBar ratingBar;
    Button btnNext;
    Button btnPlayAgain;
    int currentAnswerCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        currentAnswerCount = getIntent().getIntExtra("key", 0);

        UI();
        displayData();

        btnNext.setOnClickListener(this);
        btnPlayAgain.setOnClickListener(this);
    }

    public void UI() {
        tvDescription = findViewById(R.id.tv_description);
        ratingBar = findViewById(R.id.rb_ratingAnswer);
        btnNext = findViewById(R.id.btn_next);
        btnPlayAgain = findViewById(R.id.btn_playAgain);
    }

    public void displayData() {
        if (currentAnswerCount <= currentAnswerCount/2){
            tvDescription.setText("Nice Work");
        } else {
            tvDescription.setText("Bad Work");
        }
        ratingBar.setRating(currentAnswerCount);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if(id == R.id.btn_next){
            btnNext.setBackgroundColor(R.drawable.btn_style);
            Toast.makeText(this, "No add next stage",Toast.LENGTH_LONG).show();
        } else if (id == R.id.btn_playAgain){
            btnPlayAgain.setBackgroundColor(R.drawable.btn_style);
            currentAnswerCount = 0;
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }
}