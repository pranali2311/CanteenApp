package com.example.pranali.canteenapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class LunchMenu extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    String day;

    private List<com.example.pranali.canteenapp.ListItemLunch> listItems;
    String[] menuname={"VEGETABLE","RICE","DESSERT"};
    int[] img={R.drawable.vegetable,R.drawable.rice,R.drawable.desserts};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_lunch);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems=new ArrayList<>();

        day=getIntent().getStringExtra("day");


        for (int i=0;i<3;i++)
        {
            ListItemLunch listItem=new ListItemLunch(menuname[i],img[i]);
            listItems.add(listItem);

        }

        adapter=new com.example.pranali.canteenapp.MyAdapterLunch(listItems,this,day);

        recyclerView.setAdapter(adapter);


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
                Intent in=new Intent(LunchMenu.this,Login.class);
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in);
                finish();
                break;
            case R.id.reviews:
                Intent in1=new Intent(LunchMenu.this,ReviewFood.class);
                startActivity(in1);
                break;
            case R.id.breakfast:
                Intent in2=new Intent(LunchMenu.this,Breakfast.class);
                startActivity(in2);
                break;
            case R.id.lunch:
                Intent in3=new Intent(LunchMenu.this,Lunch.class);
                startActivity(in3);
                break;
        }

        return true;
    }
}