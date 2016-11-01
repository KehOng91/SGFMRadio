package com.example.kay.sgfmradio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import com.github.pwittchen.swipe.library.Swipe;
import com.github.pwittchen.swipe.library.SwipeListener;

public class MainActivity extends AppCompatActivity {

    private Swipe swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageButton button933 = (ImageButton) findViewById(R.id.button933);
        button933.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        ImageButton button958 = (ImageButton) findViewById(R.id.button958);
        button958.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(intent);
            }
        });

        ImageButton button972 = (ImageButton) findViewById(R.id.button972);
        button972.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main4Activity.class);
                startActivity(intent);
            }
        });

        ImageButton button987 = (ImageButton) findViewById(R.id.button987);
        button987.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main5Activity.class);
                startActivity(intent);
            }
        });

        ImageButton button938 = (ImageButton) findViewById(R.id.button938);
        button938.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main6Activity.class);
                startActivity(intent);
            }
        });

        ImageButton button98 = (ImageButton) findViewById(R.id.button98);
        button98.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main7Activity.class);
                startActivity(intent);
            }
        });

        ImageButton button905 = (ImageButton) findViewById(R.id.button905);
        button905.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main8Activity.class);
                startActivity(intent);
            }
        });

        ImageButton button95 = (ImageButton) findViewById(R.id.button95);
        button95.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main9Activity.class);
                startActivity(intent);
            }
        });

        ImageButton button995 = (ImageButton) findViewById(R.id.button995);
        button995.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main10Activity.class);
                startActivity(intent);
            }
        });

            swipe = new Swipe();
            swipe.addListener(new SwipeListener() {
                @Override public void onSwipingLeft(final MotionEvent event) {
                }

                @Override public void onSwipedLeft(final MotionEvent event) {
                    Toast.makeText(MainActivity.this, "Swiped", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Main111Activity.class);
                    startActivity(intent);
                }

                @Override public void onSwipingRight(final MotionEvent event) {
                }

                @Override public void onSwipedRight(final MotionEvent event) {
                }

                @Override public void onSwipingUp(final MotionEvent event) {
                }

                @Override public void onSwipedUp(final MotionEvent event) {
                }

                @Override public void onSwipingDown(final MotionEvent event) {
                }

                @Override public void onSwipedDown(final MotionEvent event) {
                }
            });
        }

        @Override public boolean dispatchTouchEvent(MotionEvent event) {
            swipe.dispatchTouchEvent(event);
            return super.dispatchTouchEvent(event);
        }
    }




