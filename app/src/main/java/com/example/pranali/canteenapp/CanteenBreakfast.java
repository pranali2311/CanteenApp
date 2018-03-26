package com.example.pranali.canteenapp;

import android.annotation.TargetApi;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;


/**
 * Created by pranali on 15/3/18.
 */


public class CanteenBreakfast extends AppCompatActivity {

    TextView idli,dosa,samosa,upma,vadapav,poha,sandwich,bournvita,milk,tea,coffee;
    public int[] a={0,0,0,0,0,0,0,0,0,0,0};
    String b,currDate;
    Button lunchButton;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mBreakfastDatabaseReference;
    private FirebaseAuth mAuth;
    private ChildEventListener mChildEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.canteen_breakfast);

        idli=(TextView)findViewById(R.id.idli);
        dosa=(TextView)findViewById(R.id.dosa);
        samosa=(TextView)findViewById(R.id.samosa);
        upma=(TextView)findViewById(R.id.upma);
        vadapav=(TextView)findViewById(R.id.vadapav);
        poha=(TextView)findViewById(R.id.poha);
        sandwich=(TextView)findViewById(R.id.sandwich);
        bournvita=(TextView)findViewById(R.id.bournvita);
        milk=(TextView)findViewById(R.id.milk);
        tea=(TextView)findViewById(R.id.tea);
        coffee=(TextView)findViewById(R.id.coffee);
        lunchButton=(Button)findViewById(R.id.lunchButton);

        mFirebaseDatabase=FirebaseDatabase.getInstance();
        mAuth=FirebaseAuth.getInstance();


        lunchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CanteenBreakfast.this,CanteenStats.class);
                startActivity(intent);
            }
        });

        /*mBreakfastDatabaseReference=mFirebaseDatabase.getReference().child("breakfast");

        mBreakfastDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()) {

                    if (currDate =="Sun Mar 18") {

                        if (snapshot.hasChild("idli")) {
                            ++a[0];
                        }

                        if (snapshot.hasChild("dosa")) {
                            ++a[1];
                        }


                        if (snapshot.hasChild("samosa")) {
                            ++a[2];
                        }


                        if (snapshot.hasChild("upma")) {
                            ++a[3];

                        }


                        if (snapshot.hasChild("vadapav")) {
                            ++a[4];
                        }


                        if (snapshot.hasChild("poha")) {
                            ++a[5];
                        }


                        if (snapshot.hasChild("sandwich")) {
                            ++a[6];
                        }


                        if (snapshot.hasChild("bournvita")) {
                            ++a[7];
                        }


                        if (snapshot.hasChild("milk")) {
                            ++a[8];
                        }


                        if (snapshot.hasChild("tea")) {
                            ++a[9];
                        }


                        if (snapshot.hasChild("coffee")) {
                            ++a[10];
                        }


                    }
                }

                display();



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Log.w("postCommentsonCancelled",databaseError.toException());
            }
        });*/



    }

   /* public void display(){

        String[] str=new String[11];

        for(int i=0;i<11;i++)
            str[i]=Integer.toString(a[i]);

        idli.setText("Idli : "+str[0]);
        dosa.setText("Dosa : "+str[1]);
        samosa.setText("Samosa : "+str[2]);
        upma.setText("Upma : "+str[3]);
        vadapav.setText("Vada Pav : "+str[4]);
        poha.setText("Poha : "+str[5]);
        sandwich.setText("Sandwich : "+str[6]);
        bournvita.setText("Bournvita : "+str[7]);
        milk.setText("Milk : "+str[8]);
        tea.setText("Tea : "+str[9]);
        coffee.setText("Coffee : "+str[10]);
    }*/

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
}