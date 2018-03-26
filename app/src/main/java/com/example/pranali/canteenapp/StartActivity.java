
package com.example.pranali.canteenapp;

import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    private Button signup;
    private Button login;
    private Button canteenLogin;
    private Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);

        canteenLogin=(Button)findViewById(R.id.canteenLogin);
        signup=(Button)findViewById(R.id.signup);
        login=(Button)findViewById(R.id.login);

        anim= AnimationUtils.loadAnimation(StartActivity.this,R.anim.alpha);
        anim.setFillAfter(true);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(StartActivity.this,SignUp.class);
                startActivity(i1);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(StartActivity.this,Login.class);
                startActivity(i2);
            }
        });

        canteenLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(StartActivity.this,CanteenBreakfast.class);
                startActivity(i2);
            }
        });

    }

}