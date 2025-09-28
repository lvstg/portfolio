package be.flipperdev.bichonbirthday;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity implements View.OnClickListener {

    TextView questionTextView;
    Button ansA, ansB, ansC;
    Button submitBtn;

    boolean correction = false;
    int totalQuestion = QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        submitBtn = findViewById(R.id.submit_btn);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        loadNewQuestion();
    }

    public void openActivity3() {
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;

        if (clickedButton.getId() == R.id.submit_btn) {
            correction = selectedAnswer.equals(QuestionAnswer.correctAnswer[currentQuestionIndex]);
            int saveCurrentQuestionIndex = currentQuestionIndex++;
            result(correction, saveCurrentQuestionIndex);
            loadNewQuestion();
        } else {
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.LTGRAY);
        }
    }

    void loadNewQuestion() {
        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
        ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
    }


    void result(boolean correction, int n) {
        String passStatus = "";
        StringBuilder message = new StringBuilder("");
        if (correction) {
            passStatus = "Correct";
            message.append(QuestionAnswer.clues[n]);

        } else {
            passStatus = "Failed";
            message.append(QuestionAnswer.clash[n]);
        }


        if (currentQuestionIndex == totalQuestion) {
            new AlertDialog.Builder(this)
                    .setTitle(passStatus)
                    .setMessage(message)
                    .setPositiveButton("Next", ((dialogInterface, i) -> openActivity3()))
                    .setCancelable(false)
                    .show();
            currentQuestionIndex = 0;

        } else {
            new AlertDialog.Builder(this)
                    .setTitle(passStatus)
                    .setMessage(message)
                    .setPositiveButton("Next", null)
                    .setCancelable(false)
                    .show();
        }

    }

}