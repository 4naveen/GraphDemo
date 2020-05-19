package com.heka.graphdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;

public class LineActivity extends AppCompatActivity {
    LineChart lineChart ,lineChart2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);

        lineChart = findViewById(R.id.chart);
        lineChart2 = findViewById(R.id.chart2);
        lineChart.setTouchEnabled(true);
        lineChart.setPinchZoom(true);


        LineDataSet  lineDataSet = new LineDataSet(getLineEntries(), "Oil Price");
        lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        lineDataSet.setHighlightEnabled(true);

        lineDataSet.setCircleRadius(6);
        lineDataSet.setDrawIcons(true);
        lineDataSet.setCircleHoleRadius(3);
        lineDataSet.setDrawHighlightIndicators(true);
        lineDataSet.setHighLightColor(Color.RED);
        lineDataSet.setValueTextSize(12);

        LineData lineData = new LineData(lineDataSet);
        lineChart.getDescription().setText("         ");
        lineChart.setDrawMarkers(true);
        lineChart.setDrawGridBackground(false);
        lineChart.getAxisRight().setDrawLabels(false);
        lineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        lineChart.getAxisLeft().setDrawGridLines(false);
        lineChart.getAxisLeft().setAxisMinimum(0);
        lineChart.getAxisLeft().setAxisMaximum(7);
        Bitmap starBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.heart);
        lineChart.setRenderer(new ImageLineChartRenderer(lineChart, lineChart.getAnimator(), lineChart.getViewPortHandler(), starBitmap));
        lineChart.getAxisLeft().setLabelCount(7,true);
        lineChart.getAxisLeft().setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return String.valueOf((int) Math.floor(value));
            }
        });
        lineChart.getXAxis().setDrawGridLines(false);
        lineChart.getXAxis().setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {

                return getXAxisValuesBar1().get((int) value);
            }
        });
        lineChart.getAxisRight().setDrawGridLines(false);
        lineChart.getAxisRight().setDrawAxisLine(false);
        lineChart.animateY(1000);
        lineChart.getXAxis().setGranularityEnabled(true);
        lineChart.getXAxis().setGranularity(1.0f);
        lineChart.getXAxis().setLabelCount(lineDataSet.getEntryCount());
        lineChart.setData(lineData);
        lineChart.invalidate();



        LineDataSet  lineDataSet2 = new LineDataSet(getLineEntries2(), "Oil Price");
        lineDataSet2.setAxisDependency(YAxis.AxisDependency.LEFT);
        lineDataSet2.setHighlightEnabled(true);
        lineDataSet2.setLineWidth(2);

        lineDataSet2.setCircleRadius(6);
        lineDataSet2.setCircleHoleRadius(3);
        lineDataSet2.setDrawHighlightIndicators(true);
        lineDataSet2.setHighLightColor(Color.RED);
        lineDataSet2.setValueTextSize(12);

        LineData lineData2 = new LineData(lineDataSet2);

        lineChart2.getDescription().setText("         ");
        lineChart2.setDrawMarkers(true);
        lineChart2.setDrawGridBackground(false);
        lineChart2.getAxisRight().setDrawLabels(false);
        lineChart2.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        lineChart2.getAxisLeft().setDrawGridLines(false);
        lineChart2.getXAxis().setDrawGridLines(false);
        lineChart2.getAxisLeft().setAxisMinimum(0);
        lineChart2.getAxisLeft().setAxisMaximum(14);
        lineChart2.getAxisLeft().setLabelCount(7,true);

        lineChart2.getXAxis().setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {

                return getXAxisValuesBar1().get((int) value);
            }
        });
        lineChart2.getAxisRight().setDrawGridLines(false);
        lineChart2.getAxisRight().setDrawAxisLine(false);
        lineChart2.animateY(1000);
        lineChart2.getXAxis().setGranularityEnabled(true);
        lineChart2.getXAxis().setGranularity(1.0f);
        lineChart2.getXAxis().setLabelCount(lineDataSet.getEntryCount());
        lineChart2.setData(lineData2);

    }

    private ArrayList<Entry> getLineEntries() {

        ArrayList<Entry> lineEntries = new ArrayList<Entry>();
        lineEntries.add(new Entry(0, 2));
        lineEntries.add(new Entry(1, 1.5f));
        lineEntries.add(new Entry(2, 2.5f));
        lineEntries.add(new Entry(3, 1.9f));
        lineEntries.add(new Entry(4, 3));
        lineEntries.add(new Entry(5, 2.8f));
        lineEntries.add(new Entry(6, 3.2f));


        return lineEntries;
    }
    private ArrayList<Entry> getLineEntries2() {

        ArrayList<Entry> lineEntries = new ArrayList<Entry>();
        lineEntries.add(new Entry(0, 7));
        lineEntries.add(new Entry(1, 7));
        lineEntries.add(new Entry(2, 7));
        lineEntries.add(new Entry(3, 7));
        lineEntries.add(new Entry(4, 7));
        lineEntries.add(new Entry(5, 7));
        lineEntries.add(new Entry(6, 7));


        return lineEntries;
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
}
