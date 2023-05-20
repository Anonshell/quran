package com.example.selfstudy;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class Sobah extends AppCompatActivity {
    public static int oneTimeOnly = 0;
    private ImageButton backbutton;
    private MediaPlayer mediaPlayer;
    private ImageButton nextbutton;
    private SeekBar seekBar;
    private TextView textView1;
    private TextView textView2;
    private ToggleButton togglebtn;
    private double startTime = 0.0d;
    private double finalTime = 0.0d;
    private Handler myHandler = new Handler();
    private int forwardTime = 5000;
    private int backwardTime = 5000;
    private Runnable UpdateSongTime = new Runnable() { // from class: com.example.selfstudy.Sobah.4
        @Override // java.lang.Runnable
        public void run() {
            Sobah sobah = Sobah.this;
            sobah.startTime = sobah.mediaPlayer.getCurrentPosition();
            Sobah.this.textView1.setText(String.format("%d min, %d sec", Long.valueOf(TimeUnit.MILLISECONDS.toMinutes((long) Sobah.this.startTime)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds((long) Sobah.this.startTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) Sobah.this.startTime)))));
            Sobah.this.seekBar.setProgress((int) Sobah.this.startTime);
            Sobah.this.myHandler.postDelayed(this, 100L);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobah);
        this.togglebtn = (ToggleButton) findViewById(R.id.tg1);
        this.nextbutton = (ImageButton) findViewById(R.id.nextbtn);
        this.backbutton = (ImageButton) findViewById(R.id.backbtn);
        this.textView1 = (TextView) findViewById(R.id.txt1);
        this.textView2 = (TextView) findViewById(R.id.txt2);
        this.seekBar = (SeekBar) findViewById(R.id.seek1);
        this.mediaPlayer = MediaPlayer.create(this, (int) R.raw.sabah);
        this.seekBar.setClickable(false);
        this.togglebtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.example.selfstudy.Sobah.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Sobah.this.togglebtn.setBackgroundResource(R.drawable.ic_baseline_pause_24);
                    Toast.makeText(Sobah.this.getApplicationContext(), "Playing sound", 0).show();
                    Sobah.this.mediaPlayer.start();
                    Sobah sobah = Sobah.this;
                    sobah.finalTime = sobah.mediaPlayer.getDuration();
                    Sobah sobah2 = Sobah.this;
                    sobah2.startTime = sobah2.mediaPlayer.getCurrentPosition();
                    if (Sobah.oneTimeOnly == 0) {
                        Sobah.this.seekBar.setMax((int) Sobah.this.finalTime);
                        Sobah.oneTimeOnly = 1;
                    }
                    Sobah.this.textView2.setText(String.format("%d min, %d sec", Long.valueOf(TimeUnit.MILLISECONDS.toMinutes((long) Sobah.this.finalTime)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds((long) Sobah.this.finalTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) Sobah.this.finalTime)))));
                    Sobah.this.textView1.setText(String.format("%d min, %d sec", Long.valueOf(TimeUnit.MILLISECONDS.toMinutes((long) Sobah.this.startTime)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds((long) Sobah.this.startTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) Sobah.this.startTime)))));
                    Sobah.this.seekBar.setProgress((int) Sobah.this.startTime);
                    Sobah.this.myHandler.postDelayed(Sobah.this.UpdateSongTime, 100L);
                    return;
                }
                Sobah.this.togglebtn.setBackgroundResource(R.drawable.ic_baseline_play_arrow_24);
                Toast.makeText(Sobah.this.getApplicationContext(), "Pausing sound", 0).show();
                Sobah.this.mediaPlayer.pause();
            }
        });
        this.nextbutton.setOnClickListener(new View.OnClickListener() { // from class: com.example.selfstudy.Sobah.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int temp = (int) Sobah.this.startTime;
                if (Sobah.this.forwardTime + temp <= Sobah.this.finalTime) {
                    Sobah.this.startTime += Sobah.this.forwardTime;
                    Sobah.this.mediaPlayer.seekTo((int) Sobah.this.startTime);
                    Toast.makeText(Sobah.this.getApplicationContext(), "You have Jumped forward 5 seconds", 0).show();
                    return;
                }
                Toast.makeText(Sobah.this.getApplicationContext(), "Cannot jump forward 5 seconds", 0).show();
            }
        });
        this.backbutton.setOnClickListener(new View.OnClickListener() { // from class: com.example.selfstudy.Sobah.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int temp = (int) Sobah.this.startTime;
                if (temp - Sobah.this.backwardTime > 0) {
                    Sobah.this.startTime -= Sobah.this.backwardTime;
                    Sobah.this.mediaPlayer.seekTo((int) Sobah.this.startTime);
                    Toast.makeText(Sobah.this.getApplicationContext(), "You have Jumped backward 5 seconds", 0).show();
                    return;
                }
                Toast.makeText(Sobah.this.getApplicationContext(), "Cannot jump backward 5 seconds", 0).show();
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.mediaPlayer.stop();
            this.mediaPlayer.release();
            this.mediaPlayer = null;
        }
        super.onDestroy();
    }
}