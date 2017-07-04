package com.thedeveloperworldisyours.headerrecycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity implements MultipleRecyclerViewAdapter.MultipleClickListener {

    List<MultipleData> mList;
    MultipleRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.multiple_fragment_recycler_view);

        MultipleData hendrix = new MultipleData("0", false);
        MultipleData bowie = new MultipleData("1", false);
        MultipleData morrison = new MultipleData("2", false);

        MultipleData presley = new MultipleData("3", false);
        MultipleData jagger = new MultipleData("4", false);
        MultipleData cobain = new MultipleData("5", false);

        MultipleData dylan = new MultipleData("Bob Dylan", false);
        MultipleData lennon = new MultipleData("John Lennon", false);
        MultipleData mercury = new MultipleData("Freddie Mercury", false);

        MultipleData elton = new MultipleData("Elton John", false);
        MultipleData clapton = new MultipleData("Eric Clapton", false);


        mList = new ArrayList<>();
        mList.add(0, hendrix);
        mList.add(1, bowie);
        mList.add(2, morrison);

        mList.add(3, presley);
        mList.add(4, jagger);
        mList.add(5, cobain);


        mAdapter = new MultipleRecyclerViewAdapter(mList);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(int position, View v) {

        List<MultipleData> listSection = new ArrayList<>();
        if (mList.get(position).isBoolean()) {
            mList.get(position).setBoolean(false);
        } else {
            mList.get(position).setBoolean(true);
            if (mList.get(0).ismSection()) {
                listSection.add(1, mList.get(position));
                listSection=orderRest(listSection, position);
            } else {
            listSection.add(0, new MultipleData("Favorite", false, true));
            listSection.add(1, mList.get(position));
                listSection.add(2, new MultipleData("No Favorite", false, true));
        listSection=orderNoFavorite(listSection, position);
            }
        }

        mAdapter.changedData(listSection);
        mList.clear();
        mList = listSection;
        listSection.clear();
    }

    public List<MultipleData> orderNoFavorite(List<MultipleData> listSection, int position) {
        for (int i = 0; i < mList.size(); i++) {
            if (position > i) {
                listSection.add(i + 3, mList.get(i));
            } else if (position < i) {
                listSection.add(i + 2, mList.get(i));
            }
        }
        return listSection;
    }

    public List<MultipleData> orderRest(List<MultipleData> listSection, int position) {
        for (int i = 1; i < mList.size(); i++) {
            if (position > i) {
                listSection.add(i + 2, mList.get(i));
            } else if (position < i) {
                listSection.add(i + 1, mList.get(i));
            }
        }
        return listSection;
    }

}
