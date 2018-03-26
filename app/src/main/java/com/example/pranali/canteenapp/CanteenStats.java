package com.example.pranali.canteenapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * Created by pranali on 15/3/18.
 */


public class CanteenStats extends AppCompatActivity {

    TextView veg1;
    TextView veg2;
    TextView desert;
    TextView rice;

    int[] arrDesert=new int[8];
    int[] arrVeg1=new int[6];
    int[] arrVeg2=new int[6];
    int[] arrRice=new int[8];

    String[] veggie1={"alo_gobhi","rajma","bhendi","baigan","matar","chole"};
    String[] veggie2={"alo_gobhi","rajma","bhendi","baigan","matar","chole"};
    String[] des= {"Ice-Cream","Gulab-Jamun","Lassi","Mathha","Puding","Waffles","Brownie","Pie"};
    String[] riceDal= {"Plain-Rice","Dal-Tadka","Pulav","Curd-rice","Jeera-Rice","Sambar-rice","Kadhi Rice","Brown-Rice"};



    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mLunchDatabaseReference;
    private FirebaseAuth mAuth;
    private ChildEventListener mChildEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.canteen_stats);


        veg1=(TextView)findViewById(R.id.veg1);
        veg2=(TextView)findViewById(R.id.veg2);
        rice=(TextView)findViewById(R.id.rice);
        desert=(TextView)findViewById(R.id.desert);

        mFirebaseDatabase=FirebaseDatabase.getInstance();
        mAuth=FirebaseAuth.getInstance();

        mLunchDatabaseReference=mFirebaseDatabase.getReference().child("request");


        mLunchDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot snapshot:dataSnapshot.getChildren()){

                    if(snapshot.hasChild("desertName")) {
                        switch (snapshot.child("desertName").getValue(String.class)) {

                            case "Ice-Cream":
                                ++arrDesert[0];
                                break;
                            case "Gulab-Jamun":
                                ++arrDesert[1];
                                break;
                            case "Lassi":
                                ++arrDesert[2];
                                break;
                            case "Mathha":
                                ++arrDesert[3];
                                break;
                            case "Puding":
                                ++arrDesert[4];
                                break;
                            case "Waffles":
                                ++arrDesert[5];
                                break;
                            case "Brownie":
                                ++arrDesert[6];
                                break;
                            case "Pie":
                                ++arrDesert[7];
                                break;
                            default:
                                break;
                        }
                    }

                    if(snapshot.hasChild("veg1")){
                        switch (snapshot.child("veg1").getValue(String.class)) {

                            case "alo_gobhi":
                                ++arrVeg1[0];
                                break;
                            case "rajma":
                                ++arrVeg1[1];
                                break;
                            case "bhendi":
                                ++arrVeg1[2];
                                break;
                            case "baigan":
                                ++arrVeg1[3];
                                break;
                            case "matar":
                                ++arrVeg1[4];
                                break;
                            case "chole":
                                ++arrVeg1[5];
                                break;
                            default:
                                break;
                        }

                    }

                    if(snapshot.hasChild("veg2")){
                        switch (snapshot.child("veg2").getValue(String.class)) {

                            case "alo_gobhi":
                                ++arrVeg2[0];
                                break;
                            case "rajma":
                                ++arrVeg2[1];
                                break;
                            case "bhendi":
                                ++arrVeg2[2];
                                break;
                            case "baigan":
                                ++arrVeg2[3];
                                break;
                            case "matar":
                                ++arrVeg2[4];
                                break;
                            case "chole":
                                ++arrVeg2[5];
                                break;
                            default:
                                break;
                        }

                    }

                    if(snapshot.hasChild("riceName")){
                        switch (snapshot.child("riceName").getValue(String.class)) {

                            case "Plain-Rice":
                                ++arrRice[0];
                                break;
                            case "Dal-Tadka":
                                ++arrRice[1];
                                break;
                            case "Pulav":
                                ++arrRice[2];
                                break;
                            case "Curd-rice":
                                ++arrRice[3];
                                break;
                            case "Jeera-rice":
                                ++arrRice[4];
                                break;
                            case "Sambar-rice":
                                ++arrRice[5];
                                break;
                            case "Kadhi-Rice":
                                ++arrRice[6];
                                break;
                            case "Brown-Rice":
                                ++arrRice[7];
                                break;
                            default:
                        }

                    }

                }


                displayVeg1();
                displayVeg2();
                displayRice();
                displayDesert();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Log.w("postCommentsonCancelled",databaseError.toException());
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
                Intent in=new Intent(CanteenStats.this,Login.class);
                startActivity(in);
                break;

            /*case R.id.breakfast:
                Intent in2=new Intent(SecondActivity.this,Breakfast.class);
                startActivity(in2);
                break;
            case R.id.lunch:
                Intent in3=new Intent(SecondActivity.this,Lunch.class);
                startActivity(in3);
                break;*/
        }

        return true;
    }

    public void displayDesert() {
        int max = 0;
        String str = "";

        for (int i = 0; i < 8; i++) {
            if (max < arrDesert[i]) {
                max = arrDesert[i];
                str = des[i];
            }

        }

        String d = Integer.toString(max);
        str = str + ":" + d;
        desert.setText(str);
    }

    public void displayVeg1(){
        int max=0;
        String str="";

        for(int i=0;i<6;i++){
            if(max< arrVeg1[i]){
                max=arrVeg1[i];
                str=veggie1[i];
            }

        }

        String d=Integer.toString(max);
        str=str+":"+d;
        veg1.setText(str);
    }

    public void displayVeg2() {
        int max = 0;
        String str = "";

        for (int i = 0; i < 6; i++){
            if (max < arrVeg2[i]) {
                max = arrVeg2[i];
                str = veggie2[i];
            }

        }

        String d = Integer.toString(max);
        str = str + ":" + d;
        veg2.setText(str);
    }

    public void displayRice() {
        int max = 0;
        String str = "";

        for (int i = 0; i < 8; i++) {
            if (max < arrRice[i]) {
                max = arrRice[i];
                str = riceDal[i];
            }

        }

        String d = Integer.toString(max);
        str = str + ":" + d;
        rice.setText(str);
    }



}