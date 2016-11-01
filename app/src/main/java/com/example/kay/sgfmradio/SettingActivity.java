package com.example.kay.sgfmradio;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {
    private static TextView countdownTimerText;
    private static EditText minutes;
    private static Button startTimer, resetTimer;
    private static CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        countdownTimerText = (TextView) findViewById(R.id.countdownText);
        minutes = (EditText) findViewById(R.id.enterMinutes);
        startTimer = (Button) findViewById(R.id.startTimer);
        resetTimer = (Button) findViewById(R.id.resetTimer);

        setListeners();

    }

    private void setListeners() {
        startTimer.setOnClickListener(this);
        resetTimer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.startTimer:
                if (countDownTimer == null) {
                    String getMinutes = minutes.getText().toString();

                    if (!getMinutes.equals("") && getMinutes.length() > 0) {
                        int noOfMinutes = Integer.parseInt(getMinutes) * 60 * 1000;

                        startTimer(noOfMinutes);
                        startTimer.setText(getString(R.string.stop_timer));

                    } else
                        Toast.makeText(SettingActivity.this, "Please enter no. of Minutes.", Toast.LENGTH_SHORT).show();
                } else {
                    stopCountdown();
                    startTimer.setText(getString(R.string.start_timer));
                }
                break;
            case R.id.resetTimer:
                stopCountdown();
                startTimer.setText(getString(R.string.start_timer));
                countdownTimerText.setText(getString(R.string.timer));
                break;
        }
    }

    private void stopCountdown() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
            countDownTimer = null;
        }
    }

    private void startTimer(int noOfMinutes) {
        countDownTimer = new CountDownTimer(noOfMinutes, 1000) {
            public void onTick(long millisUntilFinished) {
                long millis = millisUntilFinished;
                String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis), TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
                countdownTimerText.setText(hms);
            }

            public void onFinish() {

                countdownTimerText.setText("SEE YOU !!");
                countDownTimer = null;
                startTimer.setText(getString(R.string.start_timer));
                finishAffinity();
                System.exit(0);
            }
        }.start();
    }
}