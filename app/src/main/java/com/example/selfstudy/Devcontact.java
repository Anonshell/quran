package com.example.selfstudy;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

/* loaded from: classes3.dex */
public class Devcontact extends AppCompatActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        showAlert();
        isConnectingToInternet();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev_contact);
        isOnline();
        ImageView img1 = (ImageView) findViewById(R.id.iv1);
        ImageView img2 = (ImageView) findViewById(R.id.iv2);
        ImageView img3 = (ImageView) findViewById(R.id.iv3);
        img2.setOnClickListener(new View.OnClickListener() { // from class: com.example.selfstudy.Devcontact.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Uri uri = Uri.parse("https://api.whatsapp.com/send?phone=101883128299&text=contact%20with%20me");
                Intent intent = new Intent("android.intent.action.VIEW", uri);
                Devcontact.this.startActivity(intent);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() { // from class: com.example.selfstudy.Devcontact.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Uri uri = Uri.parse("https://t.me/AmmmarAslam");
                    Intent intent = new Intent("android.intent.action.VIEW", uri);
                    Devcontact.this.startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(Devcontact.this, "Please Turn On Internet!!", 1).show();
                }
            }
        });
        img1.setOnClickListener(new View.OnClickListener() { // from class: com.example.selfstudy.Devcontact.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Uri uri = Uri.parse("https://www.facebook.com/profile.php?id=100009010327778");
                    Intent intent = new Intent("android.intent.action.VIEW", uri);
                    Devcontact.this.startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(Devcontact.this, "Please Turn On Internet!!", 1).show();
                }
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
        alert.setMessage("Must Turn On Internet!");
        alert.setIcon(R.drawable.warning);
        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() { // from class: com.example.selfstudy.Devcontact.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                Devcontact.this.isConnectingToInternet();
                Toast.makeText(Devcontact.this, "Ok Done", 0).show();
            }
        });
        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }

    public boolean isConnectingToInternet() {
        NetworkInfo[] info;
        ConnectivityManager connectivity = (ConnectivityManager) getSystemService("connectivity");
        if (connectivity != null && (info = connectivity.getAllNetworkInfo()) != null) {
            for (NetworkInfo networkInfo : info) {
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}