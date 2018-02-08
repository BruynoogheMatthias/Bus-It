package be.ehb.elviraiskhakova.application1.challenges;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import be.ehb.elviraiskhakova.application1.MyDemoStoryLineDBHelper;
import be.ehb.elviraiskhakova.application1.R;
import cz.mendelu.busItWeek.library.SimplePuzzle;
import cz.mendelu.busItWeek.library.StoryLine;
import cz.mendelu.busItWeek.library.Task;

/**
 * Created by elvira.iskhakova on 08-Feb-18.
 */

public class QrSimplePuzzleActivity extends AppCompatActivity {

    private EditText answer;
    private TextView question;

    private StoryLine storyLine;
    private Task currentTask;
    private SimplePuzzle puzzle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_puzzle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        answer = findViewById(R.id.answer_qr);
        question = findViewById(R.id.question_qr);

        storyLine = StoryLine.open(this, MyDemoStoryLineDBHelper.class);
        currentTask = storyLine.currentTask();
        puzzle = (SimplePuzzle) currentTask.getPuzzle();
        question.setText(puzzle.getQuestion());

    }


    public void answerQuestion(View view) {
        String userAnswer = answer.getText().toString();
        String correctAnswer = puzzle.getAnswer();

        if (userAnswer.equalsIgnoreCase(correctAnswer)) {
            // correct answer
            storyLine.currentTask().finish(true);
            Intent intent = new Intent(this, QRpuzzleActivity.class);
            startActivity(intent);
        } else {
            storyLine.currentTask().finish(false);
            Toast.makeText(this, "Wrong answer", Toast.LENGTH_SHORT).show();
            finish();
            // wrong answer
        }
    }


}
