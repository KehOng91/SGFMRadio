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

public class Main111Activity extends AppCompatActivity {

    private Swipe swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main111);

        ImageButton button1003 = (ImageButton) findViewById(R.id.button1003);
        button1003.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main111Activity.this, Main11Activity.class);
                startActivity(intent);
            }
        });

        ImageButton button913 = (ImageButton) findViewById(R.id.button913);
        button913.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main111Activity.this, Main12Activity.class);
                startActivity(intent);
            }
        });

        ImageButton button924 = (ImageButton) findViewById(R.id.button924);
        button924.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main111Activity.this, Main13Activity.class);
                startActivity(intent);
            }
        });

        ImageButton button92 = (ImageButton) findViewById(R.id.button92);
        button92.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main111Activity.this, Main14Activity.class);
                startActivity(intent);
            }
        });

        ImageButton button897 = (ImageButton) findViewById(R.id.button897);
        button897.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main111Activity.this, Main15Activity.class);
                startActivity(intent);
            }
        });

        ImageButton button968 = (ImageButton) findViewById(R.id.button968);
        button968.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main111Activity.this, Main16Activity.class);
                startActivity(intent);
            }
        });

        ImageButton button942 = (ImageButton) findViewById(R.id.button942);
        button942.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main111Activity.this, Main17Activity.class);
                startActivity(intent);
            }
        });

        ImageButton button883 = (ImageButton) findViewById(R.id.button883);
        button883.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main111Activity.this, Main18Activity.class);
                startActivity(intent);
            }
        });

        swipe = new Swipe();
        swipe.addListener(new SwipeListener() {
            @Override public void onSwipingLeft(final MotionEvent event) {
            }

            @Override public void onSwipedLeft(final MotionEvent event) {
            }

            @Override public void onSwipingRight(final MotionEvent event) {
            }

            @Override public void onSwipedRight(final MotionEvent event) {
                Toast.makeText(Main111Activity.this, "Swiped", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Main111Activity.this, MainActivity.class);
                startActivity(intent);
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
