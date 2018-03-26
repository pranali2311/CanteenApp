package com.example.pranali.canteenapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.name;
import static com.example.pranali.canteenapp.R.id.image;
import static com.example.pranali.canteenapp.R.id.text;

public class UserDetails {

    private String username;
    private String password;
    private String phone;
    private String rollno;
    private String email;


    public UserDetails(String username, String password, String phone, String rollno,String email) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.rollno=rollno;
        this.email=email;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getRollno() {return rollno;}

    public void setRollno(String rollno) {this.rollno = rollno;}

    public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}



}




