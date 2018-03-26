package com.example.pranali.canteenapp;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;
import java.util.Date;


public class Lunch extends AppCompatActivity {

    String[] days={"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY"};
    String[] day={"MONDAY","TUESDAY","WEDNESDAY"};
    String[] days1={"THURSDAY","FRIDAY","SATURDAY"};
    String currDay;
    Context context=this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day_list);

        Toast.makeText(this,"Select your lunch menu",Toast.LENGTH_LONG).show();


        ListAdapter listAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,days);
        final ListView listView=(ListView)findViewById(R.id.dayslist);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Intent intent = new Intent(view.getContext(), LunchMenu.class);

                        intent.putExtra("day", days[i]);


                        startActivity(intent);

                        finish();
                    }
                }
        );




        /*if(currDay=="Sun" || currDay=="Mon" || currDay=="Tue") {

            listView.setOnItemClickListener(
                    new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            Intent intent = new Intent(view.getContext(), LunchMenu.class);

                            intent.putExtra("day", days[i]);


                            startActivity(intent);

                            finish();
                        }
                    }
            );
        }

        if(currDay=="Wed" || currDay=="Thu" || currDay=="Fri"){
            listView.setOnItemClickListener(
                    new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            Intent intent = new Intent(view.getContext(), LunchMenu.class);

                            intent.putExtra("day", days1[i]);


                            startActivity(intent);

                            finish();
                        }
                    }
            );

        }*/




    }

    @TargetApi(24)
    public String getCurrentTime() {

        String currDate;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String str = date.toString();
        String array[] = str.split(" ");
        currDate = array[0] + " " + array[1] + " " + array[2];
        //currTime=array[3];
        String array1[]=currDate.split(" ");
         currDay=array1[0];
        System.out.println(currDay);

        return (currDay);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(this,"Logged out",Toast.LENGTH_SHORT).show();
                Intent in=new Intent(Lunch.this,Login.class);
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in);
                finish();
                break;
            case R.id.breakfast:
                Intent in2=new Intent(Lunch.this,Breakfast.class);
                in2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in2);
                break;
            case R.id.reviews:
                Intent in1=new Intent(Lunch.this,ReviewFood.class);
                in1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in1);
                break;
        }

        return true;
    }


}