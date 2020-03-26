package com.dangtuyet.batdoi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ListView listViewMatch;
    ArrayList<Match> matchArrayList;
    MatchAdapter matchAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhxa();

        // su kien click vao listView
        listViewMatch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ViewMatchActivity.class);
                Match match = matchArrayList.get(position);
                intent.putExtra("matchIsChosen", match);
                startActivity(intent);
            }
        });
    }

    private void anhxa(){
        listViewMatch = (ListView) findViewById(R.id.listViewMatch);

        matchArrayList = new ArrayList<>();
        matchArrayList.add(new Match("1", "FC Red", "", new Date(), "3 : 4",  "San My Dinh", "Trung binh", "Chua co doi thu"));
        matchArrayList.add(new Match("2", "FC White", "", new Date(), "3 : 4",  "San My Dinh", "Trung binh", "Chua co doi thu"));
        matchArrayList.add(new Match("3", "FC 22", "", new Date(), "3 : 4",  "San My Dinh", "Trung binh", "Chua co doi thu"));
        matchArrayList.add(new Match("4", "FC Apple", "Samsung", new Date(), "3 : 4",  "San Thanh Long", "Trung binh", "Da co doi thu"));
        matchArrayList.add(new Match("5", "FC Samsung", "", new Date(), "3 : 4",  "San My Dinh", "Trung binh", "Chua co doi thu"));
        matchArrayList.add(new Match("6", "FC Xiaomi", "", new Date(), "3 : 4",  "San Chau Trinh Tri", "Trung binh", "Chua co doi thu"));
        matchArrayList.add(new Match("7", "FC Blue", "Green", new Date(), "3 : 4",  "San My Dinh", "Trung binh", "Da co doi thu"));

        matchAdapter = new MatchAdapter(this, R.layout._match, matchArrayList);
        listViewMatch.setAdapter(matchAdapter);

    }
}
