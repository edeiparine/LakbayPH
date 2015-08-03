package com.example.lavacake.simpleapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lavacake.simpleapp.R;
import com.example.lavacake.simpleapp.adapters.WeatherAdapter;
import com.example.lavacake.simpleapp.data.FetchWeatherTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by lavacake on 7/5/2015.
 */
public class WeatherFragment extends Fragment {

    static final String location = "Manila, PH";

    public static ArrayList<String> list = new ArrayList<String>();
    public static WeatherAdapter weatherAdapter;
    public WeatherFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

//        String[] data = {
//                "Mon",
//                "Tue",
//                "Wed",
//                "Thurs",
//                "Fri",
//                "Sat",
//                "Sun"
//        };
//
//        List<String> weekForecast = new ArrayList<String>(Arrays.asList(data));
//
//        mForecastAdapter = new ArrayAdapter<String>(
//                getActivity(),
//                R.layout.list_item_forecast,
//                R.id.list_item_forecast_textview,
//                weekForecast
//        );
//
//        View rootView = inflater.inflate(R.layout.fragment_weather_list, container, false);
//
//        ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
//        listView.setAdapter(mForecastAdapter);

        RecyclerView rootView = (RecyclerView) inflater.inflate(R.layout.fragment_weather_list, container, false);
        setupRecyclerView(rootView);

        return rootView;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {

        String a = "a";

        weatherAdapter = new WeatherAdapter(getActivity(), list);

        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(weatherAdapter);
    }

    private List<String> getRandomSublist(String[] array, int amount) {
        ArrayList<String> list = new ArrayList<>(amount);
        Random random = new Random();

        for (int i = 0; i < amount; i++) {
            list.add(array[i]);
        }
        return list;
    }

    private void updateWeather() {
        FetchWeatherTask weatherTask = new FetchWeatherTask();
        weatherTask.execute(location);
    }

    @Override
    public void onStart() {
        super.onStart();
        updateWeather();
    }
}