package com.zzisoo.recyclerviewexam;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // (A) Create Data ArrayList
        ArrayList<MyData> arrMyDatas = new ArrayList<>();

        // (A) Add Data Item
        arrMyDatas.add(new MyData(100,100,"One","#FF0000"));
        arrMyDatas.add(new MyData(200,200,"One","#00FF00"));
        arrMyDatas.add(new MyData(100,100,"One","#0000FF"));
        arrMyDatas.add(new MyData(200,150,"One","#FFFF00"));
        arrMyDatas.add(new MyData(100,150,"One","#FF00FF"));
        arrMyDatas.add(new MyData(130, 130, "One", "#00FFFF"));


        // inflate Xml(fragment_main.xml)
        View inflate = inflater.inflate(R.layout.fragment_main, container, false);

        // RecyclerView Object
        RecyclerView rv = (RecyclerView)inflate.findViewById(R.id.recyclerView);

        // (B) Set LayoutManager to RecyclerView object
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        // (C) Create MyRecyclerViewAdaper
        MyRecyclerViewAdaper myRecyclerViewAdaper = new MyRecyclerViewAdaper();

        // (C) Set Data ArrayList to MyRecyclerViewAdapter
        myRecyclerViewAdaper.setMyDatas(arrMyDatas);

        // Set myRecyclerViewAdaper to RecyclerView object
        rv.setAdapter(myRecyclerViewAdaper);

        return inflate;
    }
}
