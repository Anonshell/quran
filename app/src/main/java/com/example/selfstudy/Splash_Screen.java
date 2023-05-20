package com.example.selfstudy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;

/* loaded from: classes3.dex */
public class Splash_Screen extends AppCompatActivity {
    int progress;
    private ProgressBar progressBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_splash_screen);
        this.progressBar = (ProgressBar) findViewById(R.id.progressBarId);
        Thread thread = new Thread(new Runnable() { // from class: com.example.selfstudy.Splash_Screen.1
            @Override // java.lang.Runnable
            public void run() {
                Splash_Screen.this.dowork();
                Splash_Screen.this.startApp();
            }
        });
        thread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startApp() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dowork() {
        int i = 50;
        while (true) {
            this.progress = i;
            if (this.progress < 100) {
                try {
                    Thread.sleep(1000L);
                    this.progressBar.setProgress(this.progress);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i = this.progress + 25;
            } else {
                return;
            }
        }
    }
}