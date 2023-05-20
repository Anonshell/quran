package com.example.selfstudy;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

/* loaded from: classes3.dex */
public class Tajweed extends AppCompatActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        showAlert();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tajweed);
        ImageView img1 = (ImageView) findViewById(R.id.iv1);
        ImageView img2 = (ImageView) findViewById(R.id.iv2);
        ImageView img3 = (ImageView) findViewById(R.id.iv3);
        ImageView img4 = (ImageView) findViewById(R.id.iv4);
        img4.setOnClickListener(new View.OnClickListener() { // from class: com.example.selfstudy.Tajweed.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Uri uri = Uri.parse("https://youtube.com/playlist?list=PLVuW1ITWYFXoa8boHg-D7zoJUGl4qjOtD");
                Intent intent = new Intent("android.intent.action.VIEW", uri);
                Tajweed.this.startActivity(intent);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() { // from class: com.example.selfstudy.Tajweed.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Uri uri = Uri.parse("https://youtube.com/playlist?list=PLjpdvaZNXSyrLsN_opwHpVJ6px5nZLskY");
                Intent intent = new Intent("android.intent.action.VIEW", uri);
                Tajweed.this.startActivity(intent);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() { // from class: com.example.selfstudy.Tajweed.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Uri uri = Uri.parse("https://youtube.com/playlist?list=PLxpAkjlGauHfMFWX22VZWOKpzjr-vH_BM");
                Intent intent = new Intent("android.intent.action.VIEW", uri);
                Tajweed.this.startActivity(intent);
            }
        });
        img1.setOnClickListener(new View.OnClickListener() { // from class: com.example.selfstudy.Tajweed.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Uri uri = Uri.parse("https://youtube.com/playlist?list=PLzcOvhTH2jnHWkFkV5XlCV5Ger5vNYbEw");
                Intent intent = new Intent("android.intent.action.VIEW", uri);
                Tajweed.this.startActivity(intent);
            }
        });
        Button button1 = (Button) findViewById(R.id.btn1);
        Button button2 = (Button) findViewById(R.id.btn2);
        Button button3 = (Button) findViewById(R.id.btn3);
        Button button4 = (Button) findViewById(R.id.btn4);
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.example.selfstudy.Tajweed.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Uri uri = Uri.parse("https://youtube.com/playlist?list=PLVuW1ITWYFXoa8boHg-D7zoJUGl4qjOtD");
                Intent intent = new Intent("android.intent.action.VIEW", uri);
                Tajweed.this.startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.example.selfstudy.Tajweed.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Uri uri = Uri.parse("https://youtube.com/playlist?list=PLjpdvaZNXSyrLsN_opwHpVJ6px5nZLskY");
                Intent intent = new Intent("android.intent.action.VIEW", uri);
                Tajweed.this.startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.example.selfstudy.Tajweed.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Uri uri = Uri.parse("https://youtube.com/playlist?list=PLxpAkjlGauHfMFWX22VZWOKpzjr-vH_BM");
                Intent intent = new Intent("android.intent.action.VIEW", uri);
                Tajweed.this.startActivity(intent);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() { // from class: com.example.selfstudy.Tajweed.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Uri uri = Uri.parse("https://youtube.com/playlist?list=PLzcOvhTH2jnHWkFkV5XlCV5Ger5vNYbEw");
                Intent intent = new Intent("android.intent.action.VIEW", uri);
                Tajweed.this.startActivity(intent);
            }
        });
    }

    public boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext().getSystemService("connectivity");
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();
        if (netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()) {
            Toast.makeText(this, "No Internet connection!", 1).show();
            return false;
        }
        return true;
    }

    public void showAlert() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Hello Friend!");
        alert.setIcon(R.drawable.warning);
        alert.setMessage("Must Turn On Internet!");
        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() { // from class: com.example.selfstudy.Tajweed.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Tajweed.this, "Ok Done", 0).show();
            }
        });
        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }
}