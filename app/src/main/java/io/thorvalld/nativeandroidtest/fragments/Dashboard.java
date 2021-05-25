package io.thorvalld.nativeandroidtest.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import java.util.ArrayList;

import io.thorvalld.nativeandroidtest.R;

public class Dashboard extends Fragment {

    BarChart barChart, barChart2;
    BarData barData, barData2;
    BarDataSet barDataSet, barDataSet2;
    ArrayList<BarEntry> barEntries, barEntries2;

    AppCompatRadioButton rbDay, rbWeek, rbMonth;

    public Dashboard() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView =  inflater.inflate(R.layout.fragment_dashboard, container, false);



        barChart = mView.findViewById(R.id.mental_chart);
        barChart2 = mView.findViewById(R.id.sleep_chart);

        rbDay = mView.findViewById(R.id.rbDay);
        rbWeek = mView.findViewById(R.id.rbWeek);
        rbMonth = mView.findViewById(R.id.rbMonth);

        populateSamples();
        populateSamples2();

        barDataSet = new BarDataSet(barEntries, "Mental state chart");
        barData = new BarData(barDataSet);
        barChart.setData(barData);
        barDataSet.setColor(0xff3F63A9);

        barDataSet2 = new BarDataSet(barEntries2, "Sleep duration chart");
        barData2 = new BarData(barDataSet2);
        barChart2.setData(barData2);
        barDataSet2.setColor(0xff3F63A9);

        barChart.setPinchZoom(false);
        barChart.setDrawGridBackground(false);
        barChart.setDrawValueAboveBar(false);
        barChart.setDrawBarShadow(false);
        barChart.getDescription().setEnabled(false);

        barChart2.setPinchZoom(false);
        barChart2.setDrawGridBackground(false);
        barChart2.setDrawValueAboveBar(false);
        barChart2.setDrawBarShadow(false);
        barChart2.getDescription().setEnabled(false);

        barChart2.animate();
        barChart2.invalidate();

        barChart.animate();
        barChart.invalidate();

        rbDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rbDay.setChecked(true);
                rbMonth.setChecked(false);
                rbWeek.setChecked(false);
                rbDay.setTextColor(Color.BLUE);
                rbWeek.setTextColor(Color.WHITE);
                rbMonth.setTextColor(Color.WHITE);
            }
        });

        rbWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rbWeek.setChecked(true);
                rbDay.setChecked(false);
                rbMonth.setChecked(false);
                rbDay.setTextColor(Color.WHITE);
                rbWeek.setTextColor(Color.BLUE);
                rbMonth.setTextColor(Color.WHITE);
            }
        });

        rbMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rbMonth.setChecked(true);
                rbDay.setChecked(false);
                rbWeek.setChecked(false);
                rbDay.setTextColor(Color.WHITE);
                rbWeek.setTextColor(Color.WHITE);
                rbMonth.setTextColor(Color.BLUE);
            }
        });

        return mView;
    }

    private void populateSamples(){
        barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(0, 1));
        barEntries.add(new BarEntry(1, 4));
        barEntries.add(new BarEntry(2, 0));
        barEntries.add(new BarEntry(3, 6));
        barEntries.add(new BarEntry(4, 1));
        barEntries.add(new BarEntry(5, 7));
        barEntries.add(new BarEntry(6, 3));
    }

    private void populateSamples2(){
        barEntries2 = new ArrayList<>();
        barEntries2.add(new BarEntry(0, 6));
        barEntries2.add(new BarEntry(1, 4));
        barEntries2.add(new BarEntry(2, 2));
        barEntries2.add(new BarEntry(3, 5));
        barEntries2.add(new BarEntry(4, 5));
        barEntries2.add(new BarEntry(5, 3));
        barEntries2.add(new BarEntry(6, 1));
    }


}