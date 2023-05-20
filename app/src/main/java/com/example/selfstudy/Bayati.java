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
public class Bayati extends AppCompatActivity {
    public static int oneTimeOnly = 0;
    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;
    private TextView textView1;
    private TextView textView2;
    private ToggleButton togglebtn;
    private double startTime = 0.0d;
    private double finalTime = 0.0d;
    private final Handler myHandler = new Handler();
    private final int forwardTime = 5000;
    private final int backwardTime = 5000;
    private final Runnable UpdateSongTime = new Runnable() { // from class: com.example.selfstudy.Bayati.1
        @Override // java.lang.Runnable
        public void run() {
            Bayati bayati = Bayati.this;
            bayati.startTime = bayati.mediaPlayer.getCurrentPosition();
            Bayati.this.textView1.setText(String.format("%d min, %d sec", Long.valueOf(TimeUnit.MILLISECONDS.toMinutes((long) Bayati.this.startTime)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds((long) Bayati.this.startTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) Bayati.this.startTime)))));
            Bayati.this.seekBar.setProgress((int) Bayati.this.startTime);
            Bayati.this.myHandler.postDelayed(this, 100L);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayati);
        this.togglebtn = (ToggleButton) findViewById(R.id.tg1);
        ImageButton nextbutton = (ImageButton) findViewById(R.id.nextbtn);
        ImageButton backbutton = (ImageButton) findViewById(R.id.backbtn);
        this.textView1 = (TextView) findViewById(R.id.txt1);
        this.textView2 = (TextView) findViewById(R.id.txt2);
        this.seekBar = (SeekBar) findViewById(R.id.seek1);
        this.mediaPlayer = MediaPlayer.create(this, (int) R.raw.bayati);
        this.seekBar.setClickable(false);
        this.togglebtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.example.selfstudy.Bayati$$ExternalSyntheticLambda2
            {
                Bayati.this = this;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Bayati.this.m30lambda$onCreate$0$comexampleselfstudyBayati(compoundButton, z);
            }
        });
        nextbutton.setOnClickListener(new View.OnClickListener() { // from class: com.example.selfstudy.Bayati$$ExternalSyntheticLambda0
            {
                Bayati.this = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Bayati.this.m31lambda$onCreate$1$comexampleselfstudyBayati(view);
            }
        });
        backbutton.setOnClickListener(new View.OnClickListener() { // from class: com.example.selfstudy.Bayati$$ExternalSyntheticLambda1
            {
                Bayati.this = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Bayati.this.m32lambda$onCreate$2$comexampleselfstudyBayati(view);
            }
        });
    }

    /* renamed from: lambda$onCreate$0$com-example-selfstudy-Bayati  reason: not valid java name */
    public /* synthetic */ void m30lambda$onCreate$0$comexampleselfstudyBayati(CompoundButton compoundButton, boolean b) {
        if (b) {
            this.togglebtn.setBackgroundResource(R.drawable.ic_baseline_pause_24);
            Toast.makeText(getApplicationContext(), "Playing sound", 0).show();
            this.mediaPlayer.start();
            this.finalTime = this.mediaPlayer.getDuration();
            this.startTime = this.mediaPlayer.getCurrentPosition();
            if (oneTimeOnly == 0) {
                this.seekBar.setMax((int) this.finalTime);
                oneTimeOnly = 1;
            }
            this.textView2.setText(String.format("%d min, %d sec", Long.valueOf(TimeUnit.MILLISECONDS.toMinutes((long) this.finalTime)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds((long) this.finalTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) this.finalTime)))));
            this.textView1.setText(String.format("%d min, %d sec", Long.valueOf(TimeUnit.MILLISECONDS.toMinutes((long) this.startTime)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds((long) this.startTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) this.startTime)))));
            this.seekBar.setProgress((int) this.startTime);
            this.myHandler.postDelayed(this.UpdateSongTime, 100L);
            return;
        }
        this.togglebtn.setBackgroundResource(R.drawable.ic_baseline_play_arrow_24);
        Toast.makeText(getApplicationContext(), "Pausing sound", 0).show();
        this.mediaPlayer.pause();
    }

    /* renamed from: lambda$onCreate$1$com-example-selfstudy-Bayati  reason: not valid java name */
    public /* synthetic */ void m31lambda$onCreate$1$comexampleselfstudyBayati(View v) {
        double d = this.startTime;
        int temp = (int) d;
        if (temp + 5000 <= this.finalTime) {
            double d2 = d + 5000.0d;
            this.startTime = d2;
            this.mediaPlayer.seekTo((int) d2);
            Toast.makeText(getApplicationContext(), "You have Jumped forward 5 seconds", 0).show();
            return;
        }
        Toast.makeText(getApplicationContext(), "Cannot jump forward 5 seconds", 0).show();
    }

    /* renamed from: lambda$onCreate$2$com-example-selfstudy-Bayati  reason: not valid java name */
    public /* synthetic */ void m32lambda$onCreate$2$comexampleselfstudyBayati(View v) {
        double d = this.startTime;
        int temp = (int) d;
        if (temp - 5000 > 0) {
            double d2 = d - 5000.0d;
            this.startTime = d2;
            this.mediaPlayer.seekTo((int) d2);
            Toast.makeText(getApplicationContext(), "You have Jumped backward 5 seconds", 0).show();
            return;
        }
        Toast.makeText(getApplicationContext(), "Cannot jump backward 5 seconds", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
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