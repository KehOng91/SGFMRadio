package com.example.kay.sgfmradio;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;
import java.io.IOException;
import wseemann.media.FFmpegMediaPlayer;

public class Main2Activity extends AppCompatActivity {

    private FFmpegMediaPlayer player;
    private ProgressDialog mProgressDialog;
    private SeekBar volumeSeekbar = null;
    private AudioManager audioManager = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        initControls();

        player = new FFmpegMediaPlayer();
        String url = "http://mediacorp-web.rastream.com/933fm";
        Uri uri = Uri.parse(url);
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            player.setDataSource(this, uri);
        } catch (IOException e) {
            Toast.makeText(this, "Could not set data source", Toast.LENGTH_SHORT).show();
        }

        player.setOnPreparedListener(new FFmpegMediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(FFmpegMediaPlayer mp) {
                hideProgressDialog();
            }
        });

        player.setOnErrorListener(new FFmpegMediaPlayer.OnErrorListener() {

            @Override
            public boolean onError(FFmpegMediaPlayer mp, int what, int extra) {
                mp.release();
                return false;
            }
        });

        Button buttonPlayStop = (Button) findViewById(R.id.buttonPlayStop);
        buttonPlayStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player.isPlaying()) {
                    player.pause();
                } else {
                    player.start();
                }
            }
        });

        Button buttonHome = (Button) findViewById(R.id.buttonHome);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
                player.pause();
            }
        });

        ImageButton SettingButton = (ImageButton) findViewById(R.id.SettingButton);
        SettingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        player.prepareAsync();
        showProgressDialog();

    }

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (player.isPlaying()) {
            super.onPause();
            player.pause();
        }
    }


    private void initControls()
    {
        try
        {
            volumeSeekbar = (SeekBar)findViewById(R.id.seekBar1);
            audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            volumeSeekbar.setMax(audioManager
                    .getStreamMaxVolume(AudioManager.STREAM_MUSIC));
            volumeSeekbar.setProgress(audioManager
                    .getStreamVolume(AudioManager.STREAM_MUSIC));


            volumeSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
            {
                @Override
                public void onStopTrackingTouch(SeekBar arg0)
                {
                }

                @Override
                public void onStartTrackingTouch(SeekBar arg0)
                {
                }

                @Override
                public void onProgressChanged(SeekBar arg0, int progress, boolean arg2)
                {
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                            progress, 0);
                }
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}