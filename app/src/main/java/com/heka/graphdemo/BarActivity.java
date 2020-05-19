package com.heka.graphdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;

public class BarActivity extends AppCompatActivity {
    BarChart barchart1;
    float barWidth;
    float barSpace;
    float groupSpace;
    int no_of_bars_in_each_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);

        barchart1 = findViewById(R.id.chartConsumptionGraph);


        BarDataSet barDataSet1, barDataSet2;
        barDataSet1 = new BarDataSet(barEntries1(), "Avg Sleep Hr");
        barDataSet1.setDrawValues(false);
        barDataSet1.setColor(Color.rgb(204, 204, 0));
        barDataSet2 = new BarDataSet(barEntries2(), "Avg Deep Sleep Time");
        barDataSet2.setColor(Color.rgb(255, 255, 51));
        barDataSet2.setDrawValues(false);
        // setting y-axis data
        BarData dataBar1 = new BarData(barDataSet1, barDataSet2);
        // dataBar1.setValueTextSize(15f);
        barchart1.setData(dataBar1);

        // setting x-axis data
        XAxis xAxis1 = barchart1.getXAxis();
        xAxis1.setAxisMaximum(7);
        xAxis1.setValueFormatter(new IndexAxisValueFormatter(getXAxisValuesBar1()));

        xAxis1.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis1.setDrawGridLines(false);
        xAxis1.setGranularity(1);
        xAxis1.setGranularityEnabled(true);

// intialize each bar dimension propperty...

        barWidth = 0.16f;
        barSpace = 0.05f;
        groupSpace = 0.58f;
        no_of_bars_in_each_group=2;

        // settinf some common property of chart
        barchart1.setDrawValueAboveBar(false);
        barchart1.setScaleEnabled(false);
        barchart1.animateXY(2000, 2000);
        barchart1.getDescription().setEnabled(false);
        barchart1.setPinchZoom(false);
        barchart1.setDrawGridBackground(false);


        // setting each bar dimension propperty...

        /* formula to show x-axis abel as in center properly...
        (barWidth+barSpace)*no of bars+groupSpace=1  */

        barchart1.getBarData().setBarWidth(barWidth);
        barchart1.getXAxis().setAxisMinimum(0);
        barchart1.getXAxis().setCenterAxisLabels(true);

        barchart1.getXAxis().setAxisMaximum(0 + barchart1.getBarData().getGroupWidth(groupSpace, barSpace) * 7);
        barchart1.groupBars(0, groupSpace, barSpace);
        barchart1.getAxisLeft().setAxisMinimum(0);

        barchart1.getData().setHighlightEnabled(false);
        barchart1.invalidate();


          // setting legands..........
        Legend l = barchart1.getLegend();
        // l.setPosition(Legend.LegendPosition.);
        l.setTextSize(15f);

        // setting some y-axis property .....
        YAxis rightAxisBar1 = barchart1.getAxisRight();
        rightAxisBar1.setEnabled(false);
        rightAxisBar1.setDrawGridLines(false);
        rightAxisBar1.setSpaceBottom(0f);

     /*   YAxis leftAxis1 = barchart1.getAxisLeft();
        leftAxis1.setSpaceBottom(0f);*/


    }

    private ArrayList<String> getXAxisValuesBar1() {
        ArrayList<String> weekList = new ArrayList<>();
        weekList.add("Mon");
        weekList.add("Tue");
        weekList.add("Wed");
        weekList.add("Thur");
        weekList.add("Fri");
        weekList.add("Sat");
        weekList.add("Sun");

        return weekList;
    }

    private ArrayList<BarEntry> barEntries1() {
        ArrayList<BarEntry> barEntries1 = new ArrayList<>();
        barEntries1.add(new BarEntry(0, 10f));
        barEntries1.add(new BarEntry(1, 4f));
        barEntries1.add(new BarEntry(2, 7f));
        barEntries1.add(new BarEntry(3, 6f));
        barEntries1.add(new BarEntry(4, 5f));
        barEntries1.add(new BarEntry(5, 8f));
        barEntries1.add(new BarEntry(6, 12f));

        return barEntries1;
    }

    private ArrayList<BarEntry> barEntries2() {
        ArrayList<BarEntry> barEntries1 = new ArrayList<>();
        barEntries1.add(new BarEntry(0, 12f));
        barEntries1.add(new BarEntry(1, 8f));
        barEntries1.add(new BarEntry(2, 3f));
        barEntries1.add(new BarEntry(3, 8f));
        barEntries1.add(new BarEntry(4, 5f));
        barEntries1.add(new BarEntry(5, 10f));
        barEntries1.add(new BarEntry(6, 4f));
        return barEntries1;
    }
}
