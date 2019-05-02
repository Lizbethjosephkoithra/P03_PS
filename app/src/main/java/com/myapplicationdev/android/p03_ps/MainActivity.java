package com.myapplicationdev.android.p03_ps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvModules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvModules = findViewById(R.id.listviewModules);

        final ArrayList<String> alModules = new ArrayList<String>();
        alModules.add("C347");
        alModules.add("C302");

        ArrayAdapter<String> aaModules = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,alModules);
        lvModules.setAdapter(aaModules);

        lvModules.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String subject = alModules.get(position);

                Intent intent = new Intent(MainActivity.this,InfoActivity.class);
                intent.putExtra("subject",subject);
                startActivity(intent);
            }
        });

    }
}
