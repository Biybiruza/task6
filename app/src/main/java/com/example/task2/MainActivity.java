package com.example.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.data.Question;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvQuestionTitle;
    ImageView img;
    Button btnA;
    Button btnB;
    Button btnC;
    List<Question> question;
    int currentPosition = 0;
    int currentAnswerCount = 0;
    int currentAnswer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        displayQuestions();

        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
    }

    public void displayQuestions() {
        initQuestion();
        if (currentPosition <= question.size()-1){
            img.setImageResource(question.get(currentPosition).getImg());
            btnA.setText(question.get(currentPosition).getA());
            btnB.setText(question.get(currentPosition).getB());
            btnC.setText(question.get(currentPosition).getC());
            tvQuestionTitle.setText("Question: "+currentPosition);
        } else {
            Toast.makeText(this,"Sorawlar tawsildi",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,SecondActivity.class);
            intent.putExtra("key",currentAnswerCount);
            startActivity(intent);
        }
    }

    public void initUI() {
        img = findViewById(R.id.im_question);
        btnA = findViewById(R.id.btn_a);
        btnB = findViewById(R.id.btn_b);
        btnC = findViewById(R.id.btn_c);
    }

    public void initQuestion(){
        question = new ArrayList<Question>();

        question.add(new Question(
                R.drawable.basketball_ball, "basketball ball", "football ball","cricket ball",1));
        currentAnswer = question.get(0).getTrueAnswer();
        Toast.makeText(this,"currentPosition: "+currentPosition+"\ncurrentAnswer: "+currentAnswer,Toast.LENGTH_LONG).show();
        question.add(new Question(
                R.drawable.bycicle, "scooter", "motorbike","bycicle",3));
        currentAnswer = question.get(1).getTrueAnswer();
        Toast.makeText(this,"currentPosition: "+currentPosition+"\ncurrentAnswer: "+currentAnswer,Toast.LENGTH_LONG).show();
        question.add(new Question(
                R.drawable.pencil, "pen", "book","pencil",3));
        currentAnswer = question.get(2).getTrueAnswer();
        Toast.makeText(this,"currentPosition: "+currentPosition+"\ncurrentAnswer: "+currentAnswer,Toast.LENGTH_LONG).show();

        btnA.setBackgroundColor(R.drawable.btn_style1);
        btnB.setBackgroundColor(R.drawable.btn_style1);
        btnC.setBackgroundColor(R.drawable.btn_style1);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if(id == R.id.btn_a){
            btnA.setBackgroundColor(R.drawable.btn_style);
            actionWhenClickButton();
        }
        if(id == R.id.btn_b){
            btnB.setBackgroundColor(R.drawable.btn_style);
            actionWhenClickButton();
        }
        if(id == R.id.btn_c){
            btnC.setBackgroundColor(R.drawable.btn_style);
            actionWhenClickButton();
        }
    }

    public void actionWhenClickButton(){
        if (currentAnswer == question.get(currentPosition).getTrueAnswer()) currentAnswerCount++;
        currentPosition++;
        Toast.makeText(this,"currentPosition: "+currentPosition,Toast.LENGTH_LONG).show();
        displayQuestions();
    }
}