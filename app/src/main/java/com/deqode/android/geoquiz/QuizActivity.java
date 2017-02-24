package com.deqode.android.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;


public class QuizActivity extends AppCompatActivity {



    private TextView questionText;
    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private final String TAG = "QuizActivity";
    private int quesNum =0;
    Questions[] mQuestionsBank = new Questions[]{new Questions(R.string.q1,true),
                                                 new Questions(R.string.q2,true),
                                                 new Questions(R.string.q3,false)};



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d(TAG,"Method OnCreate() sudah dijalankan");

        super.onCreate(savedInstanceState);

        if(savedInstanceState != null){
            quesNum = savedInstanceState.getInt("index");
        }




        setContentView(R.layout.activity_quiz);

        questionText = (TextView) findViewById(R.id.question_text);
        questionText.setText(mQuestionsBank[quesNum].getTextResId());

        trueButton = (Button) findViewById(R.id.true_button);
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true,mQuestionsBank[quesNum].isAnswer());
            }
        });

        falseButton = (Button) findViewById(R.id.false_button);
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false,mQuestionsBank[quesNum].isAnswer());
            }
        });


        nextButton = (Button) findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateQuestion();
            }
        });

    }


    private void checkAnswer(boolean answer,boolean key){
        if(answer&&key){
            Toast.makeText(this,"Jawaban anda benar",Toast.LENGTH_LONG).show();
        }    else{
            Toast.makeText(this,"Jawaban anda salah",Toast.LENGTH_SHORT).show();
        }
    }

    private void updateQuestion(){
        quesNum++;
        questionText = (TextView) findViewById(R.id.question_text);
        questionText.setText(mQuestionsBank[quesNum].getTextResId());
    }


    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG,"OnStart() sudah dijalankan");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG,"onPause() sudah dijalankan");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG,"onStop() sudah dijalankan");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"onDestroy() sudah dijalankan");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"onResume() sudah dijalakan");
    }


    @Override
    public void onSaveInstanceState(Bundle savedState) {

        super.onSaveInstanceState(savedState);
        Log.d(TAG,"onSaveInstanceState() telah dipanggil");
        savedState.putInt("index",quesNum);

    }
}
