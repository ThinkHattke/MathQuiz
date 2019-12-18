package com.gauravrai.mathquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView points, timer, question, answer1, answer2, answer3, answer4;
    private CountDownTimer countdownTimer;
    private int ans, randomset, pts=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        points = findViewById(R.id.points);
        timer = findViewById(R.id.timer);
        question = findViewById(R.id.question);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);

        timer.setText("00:20");
        points.setText("0 pts");

        countdownTimer = new CountDownTimer(20000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText("00:"+millisUntilFinished/1000);
            }

            public void onFinish() {

            }

        }.start();

        loadGame();

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(randomset==0) {

                    rightAnswer();

                } else {

                    wrongAnswer();

                }

            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(randomset==1) {

                    rightAnswer();

                } else {

                    wrongAnswer();

                }

            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(randomset==2) {

                    rightAnswer();

                } else {

                    wrongAnswer();

                }

            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(randomset==3) {

                    rightAnswer();

                } else {

                    wrongAnswer();

                }

            }
        });

    }

    private void wrongAnswer() {

        Toast.makeText(this, "Wrong answer, better luck next time", Toast.LENGTH_LONG).show();
        pts=0;
        points.setText("0 pts");
        countdownTimer.cancel();
        countdownTimer = new CountDownTimer(20000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText("00:"+millisUntilFinished/1000);
            }

            public void onFinish() {

            }

        }.start();
        loadGame();

    }

    private void rightAnswer() {

        pts++;
        countdownTimer.cancel();
        countdownTimer = new CountDownTimer(20000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText("00:"+millisUntilFinished/1000);
            }

            public void onFinish() {

            }

        }.start();
        points.setText(pts +" pts");
        loadGame();

    }

    private void loadGame() {

        Random random = new Random();
        int value1 = random.nextInt(10);
        int value2 = random.nextInt(10);
        int operate = random.nextInt(3);
        randomset = random.nextInt(3);
        int fakeAns1 = random.nextInt(10);
        int fakeAns2 = random.nextInt(10);
        int fakeAns3 = random.nextInt(10);

        if(operate==0){
            ans = value1+value2;
            question.setText(value1+" + "+value2);
        } else if(operate==1) {
            ans = value1-value2;
            question.setText(value1+" - "+value2);
        } else if(operate==2) {
            ans = value1*value2;
            question.setText(value1+" * "+value2);
        } else {
            ans = value1/value2;
            question.setText(value1+" / "+value2);
        }

        if(randomset==0) {
            answer1.setText(String.valueOf(ans));
            answer2.setText(String.valueOf(fakeAns1));
            answer3.setText(String.valueOf(fakeAns2));
            answer4.setText(String.valueOf(fakeAns3));
        } else if(randomset==1) {
            answer1.setText(String.valueOf(fakeAns1));
            answer2.setText(String.valueOf(ans));
            answer3.setText(String.valueOf(fakeAns2));
            answer4.setText(String.valueOf(fakeAns3));
        } else if(randomset==2) {
            answer1.setText(String.valueOf(fakeAns1));
            answer2.setText(String.valueOf(fakeAns2));
            answer3.setText(String.valueOf(ans));
            answer4.setText(String.valueOf(fakeAns3));
        } else {
            answer1.setText(String.valueOf(fakeAns1));
            answer2.setText(String.valueOf(fakeAns2));
            answer3.setText(String.valueOf(fakeAns3));
            answer4.setText(String.valueOf(ans));
        }

    }

}
