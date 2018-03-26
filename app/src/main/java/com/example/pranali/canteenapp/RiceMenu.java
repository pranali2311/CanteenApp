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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class RiceMenu extends AppCompatActivity {

    private static RadioGroup desert_g;
    private static RadioButton rice,tadka,pulav,curd,jeera,sambar,kadhi,brown,temp;
    public ImageButton riceImageButton;
    String dalresult;
    public Button finalSubmit2;
    String riceDay;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mLunchDatabaseReference;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rice);

        desert_g=(RadioGroup)findViewById(R.id.dalradio);
        riceImageButton=(ImageButton)findViewById(R.id.riceImageButton);
        rice=(RadioButton)findViewById(R.id.rice);
        tadka=(RadioButton)findViewById(R.id.tadka);
        pulav=(RadioButton)findViewById(R.id.pulav);
        curd=(RadioButton)findViewById(R.id.curd);
        jeera=(RadioButton)findViewById(R.id.jeera);
        sambar=(RadioButton)findViewById(R.id.sambar);
        kadhi=(RadioButton)findViewById(R.id.kadhi);
        brown=(RadioButton)findViewById(R.id.brown);
        finalSubmit2=(Button)findViewById(R.id.finalSubmit2);

        mFirebaseDatabase=FirebaseDatabase.getInstance();
        mAuth=FirebaseAuth.getInstance();

        riceDay=getIntent().getStringExtra("day");

        mLunchDatabaseReference=mFirebaseDatabase.getReference().child("request");

        riceImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectRice();

                onclickbutton();



            }
        });

    }


    public void onclickbutton(){

        LunchData lunchData=new LunchData(getCurrentTime(),riceDay,null,null,dalresult,null);

        mLunchDatabaseReference.push().setValue(lunchData);

        Toast.makeText(this,"Your choice has been submitted", Toast.LENGTH_SHORT).show();

        Intent intent=new Intent(RiceMenu.this,LunchMenu.class);

        intent.putExtra("day",riceDay);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

        startActivity(intent);

        finish();


    }


    public void selectRice(){

        int select=desert_g.getCheckedRadioButtonId();
        temp=(RadioButton)findViewById(select);
        dalresult=temp.getText().toString();
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
                Intent in=new Intent(RiceMenu.this,Login.class);
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in);
                finish();
                break;
            case R.id.breakfast:
                Intent in2=new Intent(RiceMenu.this,Breakfast.class);
                in2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in2);
                finish();
                break;
            case R.id.reviews:
                Intent in1=new Intent(RiceMenu.this,ReviewFood.class);
                in1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in1);
                finish();
                break;
            case R.id.lunch:
                Intent in3=new Intent(RiceMenu.this,Lunch.class);
                in3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in3);
                finish();
                break;
        }

        return true;
    }

}