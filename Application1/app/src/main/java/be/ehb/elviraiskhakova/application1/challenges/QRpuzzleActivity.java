package be.ehb.elviraiskhakova.application1.challenges;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import be.ehb.elviraiskhakova.application1.R;
import cz.mendelu.busItWeek.library.CodeTask;
import cz.mendelu.busItWeek.library.StoryLine;
import cz.mendelu.busItWeek.library.Task;
import cz.mendelu.busItWeek.library.qrcode.QRCodeUtil;

public class QRpuzzleActivity extends AppCompatActivity {

    private StoryLine storyLine;
    private Task currentTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrpuzzle);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void scanForQRCode(View view) {
        QRCodeUtil.startQRScan(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        currentTask = storyLine.currentTask();
        if (currentTask != null && currentTask instanceof CodeTask) {
            String result = QRCodeUtil.onScanResult(this, requestCode, resultCode, data);
            CodeTask codeTask = (CodeTask) currentTask;
            if (codeTask.getQR().equals(result)) {
                storyLine.currentTask().finish(true);
                finish();
            } else if (!codeTask.getQR().equals(result)) {
                storyLine.currentTask().finish(false);
                finish();
            }
        }

    }
}
