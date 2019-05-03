package com.example.nz.expandablelistviewthree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    String[] headerString;
    String[] childString;

    List<String> headerList;
    HashMap<String,List<String>> childSlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doallwork();
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        CustomAdapter customAdapter = new CustomAdapter(this,headerList,childSlist);
        expandableListView.setAdapter(customAdapter);
    }

    public  void doallwork(){
        headerString = getResources().getStringArray(R.array.header_string);
        childString = getResources().getStringArray(R.array.child_string);
        headerList = new ArrayList<>();
        childSlist = new HashMap<>();
        for(int i=0; i<headerString.length;i++){
            headerList.add(headerString[i]);
            List<String> child = new ArrayList<>();
            child.add(childString[i]);
            childSlist.put(headerList.get(i),child);
        }
    }
}
