package be.ehb.elviraiskhakova.application1.challenges;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import be.ehb.elviraiskhakova.application1.MyDemoStoryLineDBHelper;
import be.ehb.elviraiskhakova.application1.R;
import cz.mendelu.busItWeek.library.Puzzle;
import cz.mendelu.busItWeek.library.SimplePuzzle;
import cz.mendelu.busItWeek.library.StoryLine;
import cz.mendelu.busItWeek.library.Task;

public class SimplePuzzleActivity extends AppCompatActivity {

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

        answer = findViewById(R.id.answer);
        question = findViewById(R.id.question);

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
            finish();
        } else {
            Toast.makeText(this, "Wrong answer", Toast.LENGTH_SHORT).show();
            // wrong answer
        }
    }


}
