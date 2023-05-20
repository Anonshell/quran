package com.example.selfstudy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

/* loaded from: classes3.dex */
public class Maqamat extends AppCompatActivity {
    private Button button;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maqamat);
        Button button = (Button) findViewById(R.id.btn1);
        this.button = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.example.selfstudy.Maqamat.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(Maqamat.this, Learn_Maqamat.class);
                Maqamat.this.startActivity(intent);
            }
        });
    }
}