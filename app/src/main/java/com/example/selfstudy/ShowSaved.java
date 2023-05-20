package com.example.selfstudy;

import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ShowSaved extends AppCompatActivity {
    private CustomAdapter adapter;
    DatabaseReference databaseReference;
    List<DetailsEx> detailsExList;
    ListView listview;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        showAlert();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_saved);
        isOnline();
        this.detailsExList = new ArrayList();
        Log.d("TAG", "onCreate: wjkrghbehgvbfghvfbvefnb ");
        this.adapter = new CustomAdapter(this, this.detailsExList);
        this.listview = (ListView) findViewById(R.id.list1);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("DetailsEx").addValueEventListener(new ValueEventListener() { // from class: com.example.selfstudy.ShowSaved.1
            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot snapshot) {
                ShowSaved.this.detailsExList.clear();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    Log.d("TAG", "onDataChange: " + snapshot1.child("data").getValue());
                    ShowSaved.this.detailsExList.add(new DetailsEx((String) snapshot1.child("data").getValue(String.class)));
                }
                ShowSaved showSaved = ShowSaved.this;
                ShowSaved showSaved2 = ShowSaved.this;
                showSaved.adapter = new CustomAdapter(showSaved2, showSaved2.detailsExList);
                ShowSaved.this.listview.setAdapter((ListAdapter) ShowSaved.this.adapter);
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError error) {
                error.toException().printStackTrace();
                Log.d("TAG", "onDataChange: ");
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
        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() { // from class: com.example.selfstudy.ShowSaved.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(ShowSaved.this, "Ok Done", 0).show();
            }
        });
        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }
}