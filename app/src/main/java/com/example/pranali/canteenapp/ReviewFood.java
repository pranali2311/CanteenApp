package com.example.pranali.canteenapp;

import android.annotation.TargetApi;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.String;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Date;


public class ReviewFood extends AppCompatActivity {

    ImageView imageReview1;
    ImageView imageReview2;
    TextView mTextView;

    int[] images={R.drawable.onestar, R.drawable.twostar, R.drawable.threestar,R.drawable.fourstar, R.drawable.fivestar};
    int i=0,j=0;
    public long time;
    public String currDate;
    public String currTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review);


        mTextView=(TextView)findViewById(R.id.mTextView);
        imageReview1=(ImageView)findViewById(R.id.imageReview1);
        imageReview2=(ImageView)findViewById(R.id.imageReview2);

        mTextView.setText(getCurrentTime());

        imageReview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (i){
                    case 0: imageReview1.setImageResource(images[i]);
                            i++;
                            break;
                    case 1: imageReview1.setImageResource(images[i]);
                            i++;
                            break;
                    case 2: imageReview1.setImageResource(images[i]);
                            i++;
                            break;
                    case 3: imageReview1.setImageResource(images[i]);
                            i++;
                            break;
                    case 4: imageReview1.setImageResource(images[i]);
                            i++;
                            break;
                }
            }
        });

        imageReview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (j){
                    case 0: imageReview2.setImageResource(images[j]);
                            j++;
                            break;
                    case 1: imageReview2.setImageResource(images[j]);
                            j++;
                            break;
                    case 2: imageReview2.setImageResource(images[j]);
                            j++;
                            break;
                    case 3: imageReview2.setImageResource(images[j]);
                            j++;
                            break;
                    case 4: imageReview2.setImageResource(images[j]);
                            j++;
                            break;
                }
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
                Intent in=new Intent(ReviewFood.this,Login.class);
                startActivity(in);
                break;
            case R.id.breakfast:
                Intent in2=new Intent(ReviewFood.this,Breakfast.class);
                startActivity(in2);
                break;
            case R.id.lunch:
                Intent in3=new Intent(ReviewFood.this,Lunch.class);
                startActivity(in3);
                break;
        }

        return true;
    }

    @TargetApi(24)
    public String getCurrentTime(){

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String str=date.toString();
        String array[]=str.split(" ");
        currDate=array[0]+" "+array[1]+" "+array[2];
        currTime=array[3];
        return(array[3]);

       // return (formatter.format(date));
        //time=System.currentTimeMillis();

    }




}