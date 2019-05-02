package com.myapplicationdev.android.p03_ps;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {

    int requestCode = 1;

    Button info, add, email;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Modules> alModules;
    TextView tvWeek, tvGrade, tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        lv = findViewById(R.id.listviewModules);
        tvWeek = findViewById(R.id.tvWeek);
        tvGrade = findViewById(R.id.tvGrade);
        tv = findViewById(R.id.textViewInfo);

        info = findViewById(R.id.buttonInfo);
        add = findViewById(R.id.buttonAdd);
        email = findViewById(R.id.buttonEmail);

        final Intent intent = getIntent();
        String subject = intent.getStringExtra("subject");
        tv.setText("Info for " + subject);

        alModules = new ArrayList<Modules>();

        if (subject.equals("C347")) {
            alModules.add(new Modules("Week 1", "B"));
            alModules.add(new Modules("Week 2", "C"));
            alModules.add(new Modules("Week 3", "A"));
        } else {
            alModules.add(new Modules("Week 1", "A"));
            alModules.add(new Modules("Week 2", "B"));
            alModules.add(new Modules("Week 3", "A"));
        }

        aa = new ModulesAdapter(this, R.layout.row, alModules);
        lv.setAdapter(aa);


        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // The action you want this intent to do;
                // ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT, "Email for Faci");
                email.putExtra(Intent.EXTRA_TEXT, "Hi Faci, I am Elizabeth." + "\n" +
                        "Please see my remarks so far, thank you!");
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer weekNum = alModules.size() + 1;
                String week = "Week " + weekNum.toString();

                Intent intent = new Intent(InfoActivity.this, AddGrade.class);
                intent.putExtra("week", week);
                startActivityForResult(intent, requestCode);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Integer weekNum = alModules.size()+1;

        if(resultCode == RESULT_OK){
            if(data!=null){
                String grade = data.getStringExtra("grade");
                alModules.add(new Modules("Week "+weekNum.toString(),grade));
                aa.notifyDataSetChanged();
            }
        }


    }
}