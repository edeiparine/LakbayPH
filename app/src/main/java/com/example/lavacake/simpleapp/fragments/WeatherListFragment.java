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
import com.example.lavacake.simpleapp.adapters.WeatherAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by lavacake on 7/5/2015.
 */
public class WeatherListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_weather_list, container, false);
        setupRecyclerView(recyclerView);
        return recyclerView;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new WeatherAdapter(getActivity(),
                getRandomSublist(Cheeses.sCheeseStrings, 30)));
    }

    private List<String> getRandomSublist(String[] array, int amount) {
        ArrayList<String> list = new ArrayList<>(amount);
        Random random = new Random();

        for (int i = 0; i < amount; i++) {
            list.add(array[random.nextInt(array.length)]);
        }
        return list;
    }
}