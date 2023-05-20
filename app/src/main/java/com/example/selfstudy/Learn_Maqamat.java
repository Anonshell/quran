package com.example.selfstudy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

/* loaded from: classes3.dex */
public class Learn_Maqamat extends AppCompatActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_maqamat);
        Button button1 = (Button) findViewById(R.id.btn1);
        Button button2 = (Button) findViewById(R.id.btn2);
        Button button3 = (Button) findViewById(R.id.btn3);
        Button button4 = (Button) findViewById(R.id.btn4);
        Button button5 = (Button) findViewById(R.id.btn5);
        Button button6 = (Button) findViewById(R.id.btn6);
        Button button7 = (Button) findViewById(R.id.btn7);
        Button button8 = (Button) findViewById(R.id.btn8);
        button8.setOnClickListener(new View.OnClickListener() { // from class: com.example.selfstudy.Learn_Maqamat.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Intent intent = new Intent(Learn_Maqamat.this, Nahawand.class);
                Learn_Maqamat.this.startActivity(intent);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() { // from class: com.example.selfstudy.Learn_Maqamat$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Learn_Maqamat.this.m39lambda$onCreate$0$comexampleselfstudyLearn_Maqamat(view);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() { // from class: com.example.selfstudy.Learn_Maqamat$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Learn_Maqamat.this.m40lambda$onCreate$1$comexampleselfstudyLearn_Maqamat(view);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() { // from class: com.example.selfstudy.Learn_Maqamat$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Learn_Maqamat.this.m41lambda$onCreate$2$comexampleselfstudyLearn_Maqamat(view);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.example.selfstudy.Learn_Maqamat$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Learn_Maqamat.this.m42lambda$onCreate$3$comexampleselfstudyLearn_Maqamat(view);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.example.selfstudy.Learn_Maqamat$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Learn_Maqamat.this.m43lambda$onCreate$4$comexampleselfstudyLearn_Maqamat(view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.example.selfstudy.Learn_Maqamat$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Learn_Maqamat.this.m44lambda$onCreate$5$comexampleselfstudyLearn_Maqamat(view);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() { // from class: com.example.selfstudy.Learn_Maqamat$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Learn_Maqamat.this.m45lambda$onCreate$6$comexampleselfstudyLearn_Maqamat(view);
            }
        });
    }

    /* renamed from: lambda$onCreate$0$com-example-selfstudy-Learn_Maqamat  reason: not valid java name */
    public /* synthetic */ void m39lambda$onCreate$0$comexampleselfstudyLearn_Maqamat(View view) {
        Intent intent = new Intent(this, Kurd.class);
        startActivity(intent);
    }

    /* renamed from: lambda$onCreate$1$com-example-selfstudy-Learn_Maqamat  reason: not valid java name */
    public /* synthetic */ void m40lambda$onCreate$1$comexampleselfstudyLearn_Maqamat(View view) {
        Intent intent = new Intent(this, Rast.class);
        startActivity(intent);
    }

    /* renamed from: lambda$onCreate$2$com-example-selfstudy-Learn_Maqamat  reason: not valid java name */
    public /* synthetic */ void m41lambda$onCreate$2$comexampleselfstudyLearn_Maqamat(View view) {
        Intent intent = new Intent(this, Sikah.class);
        startActivity(intent);
    }

    /* renamed from: lambda$onCreate$3$com-example-selfstudy-Learn_Maqamat  reason: not valid java name */
    public /* synthetic */ void m42lambda$onCreate$3$comexampleselfstudyLearn_Maqamat(View view) {
        Intent intent = new Intent(this, Ziharka.class);
        startActivity(intent);
    }

    /* renamed from: lambda$onCreate$4$com-example-selfstudy-Learn_Maqamat  reason: not valid java name */
    public /* synthetic */ void m43lambda$onCreate$4$comexampleselfstudyLearn_Maqamat(View view) {
        Intent intent = new Intent(this, Hijaz.class);
        startActivity(intent);
    }

    /* renamed from: lambda$onCreate$5$com-example-selfstudy-Learn_Maqamat  reason: not valid java name */
    public /* synthetic */ void m44lambda$onCreate$5$comexampleselfstudyLearn_Maqamat(View view) {
        Intent intent = new Intent(this, Sobah.class);
        startActivity(intent);
    }

    /* renamed from: lambda$onCreate$6$com-example-selfstudy-Learn_Maqamat  reason: not valid java name */
    public /* synthetic */ void m45lambda$onCreate$6$comexampleselfstudyLearn_Maqamat(View view) {
        Intent intent = new Intent(this, Bayati.class);
        startActivity(intent);
    }
}