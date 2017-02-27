package com.deqode.android.geoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private Button mShowAnswer;
    private TextView mAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        final boolean isAnswer = getIntent().getBooleanExtra("answer",false);
        mShowAnswer = (Button) findViewById(R.id.show_answer_button);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAnswer = (TextView)findViewById(R.id.answer_text_view);
                mAnswer.setText("answer is "+isAnswer);
                setAnswerShownResult(true);
            }
        });



    }


    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra("isAnwerShown", isAnswerShown);
        setResult(RESULT_OK, data);
    }
}
