package be.ehb.elviraiskhakova.application1.challenges;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import be.ehb.elviraiskhakova.application1.MyDemoStoryLineDBHelper;
import be.ehb.elviraiskhakova.application1.R;
import cz.mendelu.busItWeek.library.ChoicePuzzle;
import cz.mendelu.busItWeek.library.StoryLine;
import cz.mendelu.busItWeek.library.Task;

public class TextSelectActivity extends AppCompatActivity {

    private TextView question;
    private RecyclerView answersList;
    private List<String> answers;
    private StoryLine storyLine;
    private Task currentTask;
    private ChoicePuzzle puzzle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_select);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        question = findViewById(R.id.question);

        storyLine = StoryLine.open(this, MyDemoStoryLineDBHelper.class);
        currentTask = storyLine.currentTask();
        puzzle = (ChoicePuzzle) currentTask.getPuzzle();
        question.setText(puzzle.getQuestion());

        answersList = findViewById(R.id.answers_list);
        AnswersAdapter adapter = new AnswersAdapter();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        answersList.setLayoutManager(layoutManager);
        answersList.setAdapter(adapter);

        answers = new ArrayList<>();
        // answers.add("trezrh");
        for (Map.Entry<String, Boolean> entry : puzzle.getChoices().entrySet()) {
            answers.add(entry.getKey());
        }
        adapter.notifyDataSetChanged();


    }


    public void answerQuestion(View view) {

    }

    public class AnswerViewHolder extends RecyclerView.ViewHolder {

        public TextView answer;

        public AnswerViewHolder(View itemView) {
            super(itemView);
            answer = itemView.findViewById(R.id.answer);
        }
    }

    public class AnswersAdapter extends RecyclerView.Adapter<AnswerViewHolder> {

        @Override
        public AnswerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_text_choice, parent, false);
            return new AnswerViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final AnswerViewHolder holder, final int position) {
            final String answer = answers.get(position);
            holder.answer.setText(answer);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (puzzle.getAnswerForChoice(holder.getAdapterPosition())) {
                        //correct answer
                        currentTask.finish(true);
                        Toast.makeText(TextSelectActivity.this, "Correct answer", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        // wrong answer
                        Toast.makeText(TextSelectActivity.this, "Wrong answer"
                                + "", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }

        @Override
        public int getItemCount() {
            return answers.size();
        }
    }

}
