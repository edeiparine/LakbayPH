package com.example.lavacake.simpleapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lavacake.simpleapp.Cheeses;
import com.example.lavacake.simpleapp.R;
import com.example.lavacake.simpleapp.adapters.CheeseAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class CheeseListFragment extends Fragment {


    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView rv = (RecyclerView) inflater.inflate(R.layout.fragment_cheese_list, container, false);
        setupRecyclerView(rv);
        return rv;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        CheeseAdapter cheeseAdapter = new CheeseAdapter(getActivity(), getRandomSublist(Cheeses.sCheeseStrings, 30));

        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(cheeseAdapter);
    }

    private List<String> getRandomSublist(String[] array, int amount) {
        ArrayList<String> list = new ArrayList<>(amount);
        Random random = new Random();
        while (list.size() < amount) {
            list.add(array[random.nextInt(array.length)]);
        }
        return list;
    }

}