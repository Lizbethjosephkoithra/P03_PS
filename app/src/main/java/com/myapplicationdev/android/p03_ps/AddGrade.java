package com.myapplicationdev.android.p03_ps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AddGrade extends AppCompatActivity {

    TextView tvWeek;
    RadioGroup rg;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grade);

        rg = findViewById(R.id.rg);
        submit = findViewById(R.id.btnSubmit);
        tvWeek = findViewById(R.id.tvWeek);

        Intent i = getIntent();
        String week = i.getStringExtra("week");
        tvWeek.setText(week);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int rgID = rg.getCheckedRadioButtonId();
                RadioButton rb = findViewById(rgID);
                final String grade = rb.getText().toString();

                Intent i = new Intent();
                i.putExtra("grade", grade);
                setResult(RESULT_OK, i);
                finish();

            }
        });
    }
}
