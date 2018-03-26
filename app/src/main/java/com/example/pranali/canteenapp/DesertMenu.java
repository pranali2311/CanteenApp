package com.example.pranali.canteenapp;

import android.annotation.TargetApi;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class DesertMenu extends AppCompatActivity {

    private static RadioGroup desert_g;
    private static RadioButton ice,jamun,lassi,mathha,waffles,pudding,brownie,pie,temp;
    public ImageButton submitDesert;
    String  desresult;
    public Button finalSubmit1;
    String desertDay;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mLunchDatabaseReference;
    private FirebaseAuth mAuth;
   // LunchData lunchData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desert);

        desert_g=(RadioGroup)findViewById(R.id.desertlist);
        submitDesert=(ImageButton)findViewById(R.id.desertButton);
        ice=(RadioButton)findViewById(R.id.icecream);
        jamun=(RadioButton)findViewById(R.id.jamun);
        lassi=(RadioButton)findViewById(R.id.lassi);
        mathha=(RadioButton)findViewById(R.id.mathha);
        waffles=(RadioButton)findViewById(R.id.waffles);
        pudding=(RadioButton)findViewById(R.id.pudding);
        brownie=(RadioButton)findViewById(R.id.brownie);
        pie=(RadioButton)findViewById(R.id.pie);
        finalSubmit1=(Button)findViewById(R.id.finalSubmit1);

        mFirebaseDatabase=FirebaseDatabase.getInstance();
        mAuth=FirebaseAuth.getInstance();

        desertDay=getIntent().getStringExtra("day");

        mLunchDatabaseReference=mFirebaseDatabase.getReference().child("request");

        submitDesert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectDesert();

                onclickButton();

            }
        });

    }


    public  void onclickButton()
    {
        FirebaseUser user = mAuth.getCurrentUser();

        LunchData lunchData=new LunchData(getCurrentTime(),desertDay,null,null,null,desresult);

        mLunchDatabaseReference.push().setValue(lunchData);

        Toast.makeText(this,"Your choice has been submitted", Toast.LENGTH_SHORT).show();


        Intent intent=new Intent(this,LunchMenu.class);

        intent.putExtra("day",desertDay);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_CLEAR_TASK);

        startActivity(intent);
        finish();

    }

    public void selectDesert(){

        int select=desert_g.getCheckedRadioButtonId();
        temp=(RadioButton)findViewById(select);
        desresult=temp.getText().toString();

    }

    @TargetApi(24)
    public String getCurrentTime(){

        String currDate;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String str=date.toString();
        String array[]=str.split(" ");
        currDate=array[0]+" "+array[1]+" "+array[2];
        //currTime=array[3];
        return(currDate);

        // return (formatter.format(date));
        //time=System.currentTimeMillis();

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
                Intent in=new Intent(DesertMenu.this,Login.class);
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in);
                finish();
                break;
            case R.id.breakfast:
                Intent in2=new Intent(DesertMenu.this,Breakfast.class);
                in2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in2);
                finish();
                break;
            case R.id.reviews:
                Intent in1=new Intent(DesertMenu.this,ReviewFood.class);
                in1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in1);
                finish();
                break;
            case R.id.lunch:
                Intent in3=new Intent(DesertMenu.this,Lunch.class);
                in3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in3);
                finish();
                break;
        }

        return true;
    }

}