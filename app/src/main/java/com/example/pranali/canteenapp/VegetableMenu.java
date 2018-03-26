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
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Date;

public class VegetableMenu extends AppCompatActivity implements View.OnClickListener {

    CheckBox alo, bhendi, matar, rajma, baigan, chole;
    ImageButton submit;
    int total;
    View view;
    public Button finalSubmit;
    public ArrayList<String> res = new ArrayList<String>();
    int i;
    String veg1,veg2,vegDay;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mLunchDatabaseReference;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vegetables);
        i=0;
        alo = (CheckBox) findViewById(R.id.vegcheckBox1);
        rajma = (CheckBox) findViewById(R.id.vegcheckBox2);
        bhendi = (CheckBox) findViewById(R.id.vegcheckBox3);
        baigan = (CheckBox) findViewById(R.id.vegcheckBox4);
        matar = (CheckBox) findViewById(R.id.vegcheckBox5);
        chole = (CheckBox) findViewById(R.id.vegcheckBox6);
        submit=(ImageButton)findViewById(R.id.vegimageButton);
        finalSubmit=(Button)findViewById(R.id.finalSubmit);

        alo.setOnClickListener(this);
        rajma.setOnClickListener(this);
        bhendi.setOnClickListener(this);
        baigan.setOnClickListener(this);
        matar.setOnClickListener(this);
        chole.setOnClickListener(this);


        vegDay=getIntent().getStringExtra("day");


        mFirebaseDatabase=FirebaseDatabase.getInstance();
        mAuth=FirebaseAuth.getInstance();



        mLunchDatabaseReference=mFirebaseDatabase.getReference().child("request");

    }

    @Override
    public  void onClick(View view)
    {
        CheckBox c=(CheckBox) view;

        if(c.isChecked())
        {
            if(i!=2)
                i++;
            else {
                Toast.makeText(this,"You can select only 2 option",Toast.LENGTH_LONG).show();
                c.toggle();
            }
        }
        else
            i--;
    }

    public void onButtonclick(View view) {

        selectVegetable();

        FirebaseUser user = mAuth.getCurrentUser();

        LunchData lunchData=new LunchData(getCurrentTime(),vegDay,veg1,veg2,null,null);

        mLunchDatabaseReference.push().setValue(lunchData);

        res.clear();

        Toast.makeText(this,"Your choice has been submitted", Toast.LENGTH_SHORT).show();

        Intent intent=new Intent(this,LunchMenu.class);

        intent.putExtra("day",vegDay);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

        startActivity(intent);

        finish();


    }

    public void selectVegetable(){

        res.clear();

        if(alo.isChecked())
            res.add("alo_gobhi");
        if(rajma.isChecked())
            res.add("rajma");
        if(baigan.isChecked())
            res.add("baigan");
        if(matar.isChecked())
            res.add("matar");
        if(chole.isChecked())
            res.add("chole");
        if(bhendi.isChecked());
            res.add("bhendi");


            veg1 = res.get(0);
            veg2 = res.get(1);

       // res.clear();

    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

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
        return (currDate);
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
                Intent in=new Intent(VegetableMenu.this,Login.class);
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in);
                finish();
                break;
            case R.id.breakfast:
                Intent in2=new Intent(VegetableMenu.this,Breakfast.class);
                in2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in2);
                finish();
                break;
            case R.id.reviews:
                Intent in1=new Intent(VegetableMenu.this,ReviewFood.class);
                in1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in1);
                finish();
                break;
            case R.id.lunch:
                Intent in3=new Intent(VegetableMenu.this,Lunch.class);
                in3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in3);
                finish();
                break;
        }

        return true;
    }

}
