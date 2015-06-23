package com.example.devchandan.stormie.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Parcelable;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.devchandan.stormie.R;
import com.example.devchandan.stormie.adapters.DayAdapter;
import com.example.devchandan.stormie.weather.Day;

import java.util.Arrays;


public class DailyForecastActivity extends ListActivity {

    private Day[] mDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);

        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.DAILY_FORECAST);
        mDays = Arrays.copyOf(parcelables,parcelables.length,Day[].class);

        DayAdapter adapter = new DayAdapter(this, mDays);
        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);


        String dayOfTheWeek = mDays[position].getDayOfTheWeek();
        String conditions = mDays[position].getSummary();
        String highTemeperature = mDays[position].getTemperatureMax()+"";
        String message = String.format("On %s the high will be %s and the day will be %s",
                dayOfTheWeek,highTemeperature,conditions);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
