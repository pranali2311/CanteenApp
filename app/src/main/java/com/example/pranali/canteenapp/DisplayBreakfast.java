package com.example.pranali.canteenapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class DisplayBreakfast extends AppCompatActivity {

    TextView backendidli,backenddosa,backendsamosa,backendupma,backendvadapav,backendpoha,backendsanwitch,backendbournvita,backendmilk,backendtea,backendcoffee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice);

         backendidli=(TextView)findViewById(R.id.idliname);
         backenddosa=(TextView)findViewById(R.id.dosa);
         backendsamosa=(TextView)findViewById(R.id.samosa);
         backendupma=(TextView)findViewById(R.id.upma);
         backendvadapav=(TextView)findViewById(R.id.vadapav);
         backendpoha=(TextView)findViewById(R.id.poha);
         backendsanwitch=(TextView)findViewById(R.id.sandwitch);
        backendbournvita=(TextView)findViewById(R.id.bournvita);
         backendmilk=(TextView)findViewById(R.id.milk);
        backendtea=(TextView)findViewById(R.id.tea);
        backendcoffee=(TextView)findViewById(R.id.coffee);
        Button ok=(Button)findViewById(R.id.OK);

        String[] bItemNames=getIntent().getExtras().getStringArray("itemnames");
        int[] bItemCount=getIntent().getExtras().getIntArray("counterarray");

        String[] bItemCountStr=new String[11];
        for(int i=0;i<11;i++) {
            bItemCountStr[i] = Integer.toString(bItemCount[i]);
        }
        if(bItemCount[0]!=0)
        {
            backendidli.setText(bItemNames[0]+"-"+bItemCountStr[0]);
        }
        else
        {
            backendidli.setText("");
        }

        if(bItemCount[1]!=0)
        {
            backenddosa.setText(bItemNames[1]+"-"+bItemCountStr[1]);
        }
        else
        {
            backenddosa.setText("");
        }

        if(bItemCount[2]!=0)
        {
            backendsamosa.setText(bItemNames[2]+"-"+bItemCountStr[2]);
        }
        else
        {
            backendsamosa.setText("");
        }

        if(bItemCount[3]!=0)
        {
            backendupma.setText(bItemNames[3]+"-"+bItemCountStr[3]);
        }
        else
        {
            backendupma.setText("");
        }

        if(bItemCount[4]!=0)
        {
            backendvadapav.setText(bItemNames[4]+"-"+bItemCountStr[4]);
        }
        else
        {
            backendvadapav.setText("");
        }

        if(bItemCount[5]!=0)
        {
            backendpoha.setText(bItemNames[5]+"-"+bItemCountStr[5]);
        }
        else
        {
            backendpoha.setText("");
        }

        if(bItemCount[6]!=0)
        {
            backendsanwitch.setText(bItemNames[6]+"-"+bItemCountStr[6]);
        }
        else
        {
            backendsanwitch.setText("");
        }


        if(bItemCount[7]!=0)
        {
            backendbournvita.setText(bItemNames[7]+"-"+bItemCountStr[7]);
        }
        else
        {
            backendbournvita.setText("");
        }

        if(bItemCount[8]!=0)
        {
            backendmilk.setText(bItemNames[8]+"-"+bItemCountStr[8]);
        }
        else
        {
            backendmilk.setText("");
        }

        if(bItemCount[9]!=0)
        {
            backendtea.setText(bItemNames[9]+"-"+bItemCountStr[9]);
        }
       /* else
        {
            backendtea.setText("");
        }*/

        if(bItemCount[10]!=0)
        {
            backendcoffee.setText(bItemNames[10]+"-"+bItemCountStr[10]);
        }
        else
        {
            backendcoffee.setText("");
        }


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(DisplayBreakfast.this, ChoiceActivity.class);

                startActivity(intent);
            }
        });


    }
}