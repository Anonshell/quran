package com.example.selfstudy;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

/* loaded from: classes3.dex */
public class CustomAdapter extends ArrayAdapter<DetailsEx> {
    private final Activity context;
    private final List<DetailsEx> detailsExList;

    public CustomAdapter(Activity context, List<DetailsEx> detailsExList) {
        super(context, (int) R.layout.sample_layout, detailsExList);
        this.context = context;
        this.detailsExList = detailsExList;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.sample_layout, (ViewGroup) null, true);
        DetailsEx detailsEx = this.detailsExList.get(position);
        TextView t1 = (TextView) view.findViewById(R.id.tv1);
        t1.setText(detailsEx.getData());
        return view;
    }
}