package com.myapplicationdev.android.p03_ps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ModulesAdapter extends ArrayAdapter {

    private ArrayList<Modules> alModules;
    private Context context;
    private TextView tvWeek;
    private TextView tvGrade;

    public ModulesAdapter(Context context, int resource, ArrayList<Modules> objects){
        super(context, resource, objects);
        alModules = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvWeek = rowView.findViewById(R.id.tvWeek);
        tvGrade = rowView.findViewById(R.id.tvGrade);

        Modules currentInfo = alModules.get(position);

        tvWeek.setText(currentInfo.getWeek());
        tvGrade.setText(currentInfo.getGrade());

        return rowView;
    }

}
