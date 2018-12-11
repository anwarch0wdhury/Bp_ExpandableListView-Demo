package com.anwar.bp_expandablelistview;


import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private List<String> expandableListNames;
    private HashMap<String, Information> listInformations;
    private int lastExpandedPosition = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if(lastExpandedPosition != -1 && groupPosition != lastExpandedPosition){
                    expandableListView.collapseGroup(lastExpandedPosition);

                }
                lastExpandedPosition = groupPosition;
            }
        });




    }

    private void init() {
        this.expandableListView = findViewById(R.id.expandableListView);
        this.listInformations = getInformations();
        this.expandableListNames = new ArrayList<>(listInformations.keySet());
        this.expandableListAdapter = new CustomExpandableListAdapter(this,
                expandableListNames, listInformations);

    }


    private HashMap<String, Information> getInformations() {
        HashMap<String, Information> list = new HashMap<>();

        list.put("Lucky", new Information("01715058645", "5-10-2018", "Walton12345","walton x5"));
        list.put("Sara", new Information("01682197497", "8-1-2000", "Walton25865","walton g3"));
        list.put("Anwar", new Information("01611771666", "22-6-2016", "Walton95126","walton s3"));


        return list;
    }

}
