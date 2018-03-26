package com.example.pranali.canteenapp;

import android.annotation.TargetApi;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Breakfast extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    Button breakfastSubmit;
    public TextView totalPrice;
    String currTime;
    String time;


    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mBreakfastDatabaseReference;
    private FirebaseAuth mAuth;

    private List<ListItemBreakfast> listItems;

    String[] menuname={"IDLI","DOSA","SAMOSA","UPMA","VADAPAV","POHA","SANDWICH","BOURNVITA","MILK","TEA","COFFEE"};

    int[] img={R.drawable.idliwada,R.drawable.dosa,R.drawable.samosa,R.drawable.samai_upma,R.drawable.vadapav,R.drawable.poha,R.drawable.bombay_sandwitch,R.drawable.bourvita,R.drawable.milk_glass,R.drawable.tea,R.drawable.coffee};

    int[] countItems={0,0,0,0,0,0,0,0,0,0,0};
   //String[] countItems={"0","0","0","0","0","0","0","0","0","0","0"};

    String[] finalMenu;
    int[] finalCount;
    String[] finalCount1;
    int k=0;
    String currDate;

    String[] prices={"25","20","10","15","10","15","30","20","15","10","10"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_breakfast);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        breakfastSubmit=(Button)findViewById(R.id.breakfastsubmit);
        totalPrice=(TextView)findViewById(R.id.totalcnt);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mFirebaseDatabase=FirebaseDatabase.getInstance();
        mAuth=FirebaseAuth.getInstance();

        mBreakfastDatabaseReference=mFirebaseDatabase.getReference().child("breakfast");

        time=getCurrentTime();

        if(time.compareTo("22:00:00")>1){
            breakfastSubmit.setEnabled(false);
            Toast.makeText(this,"You cannot order now!!",Toast.LENGTH_SHORT).show();
        }

        listItems=new ArrayList<>();

        for (int i=0;i<11;i++)
        {
            ListItemBreakfast listItem=new ListItemBreakfast(menuname[i],prices[i],img[i],"0");
            listItems.add(listItem);

        }

        adapter=new MyAdapterBreakfast(listItems,this,totalPrice,countItems);

        recyclerView.setAdapter(adapter);

        breakfastSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BreakfastData breakfastData=new BreakfastData(currDate,countItems[0],countItems[1],countItems[2],countItems[3],countItems[4],countItems[5],countItems[6],countItems[7],countItems[8],countItems[9],countItems[10]);

                mBreakfastDatabaseReference.push().setValue(breakfastData);



                Intent intent=new Intent(Breakfast.this,ChoiceActivity.class);

                intent.putExtra("itemnames",menuname);
                intent.putExtra("counterarray",countItems);
                startActivity(intent);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

                startActivity(intent);
                finish();

            }
        });
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
                Intent in=new Intent(Breakfast.this,Login.class);
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in);
                finish();
                break;
            case R.id.reviews:
                Intent in1=new Intent(Breakfast.this,ReviewFood.class);
                in1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in1);
                finish();
                break;
            case R.id.breakfast:
                Intent in2=new Intent(Breakfast.this,Breakfast.class);
                in2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in2);
                finish();
                break;
            case R.id.lunch:
                Intent in3=new Intent(Breakfast.this,Lunch.class);
                in3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in3);
                finish();
                break;
        }

        return true;
    }

    @TargetApi(24)
    public String getCurrentTime() {


        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String str = date.toString();
        String array[] = str.split(" ");
        currDate = array[0] + " " + array[1] + " " + array[2];
        currTime=array[3];
        return (currTime);
    }
}