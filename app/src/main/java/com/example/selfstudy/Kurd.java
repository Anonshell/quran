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
public class Kurd extends AppCompatActivity {
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
    private final Runnable UpdateSongTime = new Runnable() { // from class: com.example.selfstudy.Kurd.1
        @Override // java.lang.Runnable
        public void run() {
            Kurd kurd = Kurd.this;
            kurd.startTime = kurd.mediaPlayer.getCurrentPosition();
            Kurd.this.textView1.setText(String.format("%d min, %d sec", Long.valueOf(TimeUnit.MILLISECONDS.toMinutes((long) Kurd.this.startTime)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds((long) Kurd.this.startTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) Kurd.this.startTime)))));
            Kurd.this.seekBar.setProgress((int) Kurd.this.startTime);
            Kurd.this.myHandler.postDelayed(this, 100L);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kurd);
        this.togglebtn = (ToggleButton) findViewById(R.id.tg1);
        ImageButton nextbutton = (ImageButton) findViewById(R.id.nextbtn);
        ImageButton backbutton = (ImageButton) findViewById(R.id.backbtn);
        this.textView1 = (TextView) findViewById(R.id.txt1);
        this.textView2 = (TextView) findViewById(R.id.txt2);
        this.seekBar = (SeekBar) findViewById(R.id.seek1);
        this.mediaPlayer = MediaPlayer.create(this, (int) R.raw.kurd);
        this.seekBar.setClickable(false);
        this.togglebtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.example.selfstudy.Kurd$$ExternalSyntheticLambda2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Kurd.this.m36lambda$onCreate$0$comexampleselfstudyKurd(compoundButton, z);
            }
        });
        nextbutton.setOnClickListener(new View.OnClickListener() { // from class: com.example.selfstudy.Kurd$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Kurd.this.m37lambda$onCreate$1$comexampleselfstudyKurd(view);
            }
        });
        backbutton.setOnClickListener(new View.OnClickListener() { // from class: com.example.selfstudy.Kurd$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Kurd.this.m38lambda$onCreate$2$comexampleselfstudyKurd(view);
            }
        });
    }

    /* renamed from: lambda$onCreate$0$com-example-selfstudy-Kurd  reason: not valid java name */
    public /* synthetic */ void m36lambda$onCreate$0$comexampleselfstudyKurd(CompoundButton compoundButton, boolean b) {
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

    /* renamed from: lambda$onCreate$1$com-example-selfstudy-Kurd  reason: not valid java name */
    public /* synthetic */ void m37lambda$onCreate$1$comexampleselfstudyKurd(View v) {
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

    /* renamed from: lambda$onCreate$2$com-example-selfstudy-Kurd  reason: not valid java name */
    public /* synthetic */ void m38lambda$onCreate$2$comexampleselfstudyKurd(View v) {
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