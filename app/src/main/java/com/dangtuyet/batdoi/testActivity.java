package com.dangtuyet.batdoi;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.Date;

public class testActivity extends AppCompatActivity {
    ScrollView scrollView;
    ListView listViewMatch;
    ArrayList<Match> matchArrayList;
    MatchAdapter matchAdapter;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        scrollView = (ScrollView) findViewById(R.id.scrollView);

        anhxa();
        listViewMatch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Intent intent = new Intent(MainActivity.this, ViewMatchActivity.class);
                Intent intent = new Intent(testActivity.this, ViewMatchActivity.class);
                Match match = matchArrayList.get(position);
                intent.putExtra("matchIsChosen", match);
                startActivity(intent);
            }
        });
        // dung nay ne :))))
        scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                System.out.println(scrollX+" "+scrollY);
                if(scrollY==300){
                    //hien button
                }
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
        setListViewHeightBasedOnChildren(matchAdapter, listViewMatch);
    }

    public static void setListViewHeightBasedOnChildren(MatchAdapter matchAdapter, ListView listView) {
        if (matchAdapter == null) {
            return;
        }

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < matchAdapter.getCount(); i++) {
            view = matchAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (matchAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}


