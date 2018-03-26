package com.example.pranali.canteenapp;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.Toast;
import java.util.Calendar;

import java.util.ArrayList;
import java.util.Date;

import static android.view.accessibility.AccessibilityNodeInfo.CollectionInfo.SELECTION_MODE_MULTIPLE;

public class CalendarActivity extends AppCompatActivity {

    CalendarView calendarView;

    private ArrayList<Date> dates;
    private Date date = new Date();

    Calendar cal=Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
        calendarView = (CalendarView) findViewById(R.id.calendarView);

       // cal.set(2018,03,10);
        //cal.set(2018,03,13);
        //cal.set(2018,03,15);
        //
        //cal.set(2018,03,07);



        


        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                Toast.makeText(getApplicationContext(), dayOfMonth + "/" + month + "/" + year, Toast.LENGTH_LONG).show();
            }
        });
    }






}