package com.example.pranali.canteenapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private EditText phone;
    private EditText rollno;
    private EditText email;
    private Button submitsignup;
    String emailId, passcode;
    private static final String TAG="SignUp";


    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mUsersDatabaseReference;
    private FirebaseAuth mAuth;
    private ChildEventListener mChildEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        phone=(EditText)findViewById(R.id.phone);
        rollno=(EditText)findViewById(R.id.rollno);
        email=(EditText)findViewById(R.id.email);
        submitsignup=(Button)findViewById(R.id.submitsignup);



        mFirebaseDatabase=FirebaseDatabase.getInstance();
        mAuth=FirebaseAuth.getInstance();

        mUsersDatabaseReference=mFirebaseDatabase.getReference().child("users");

        submitsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                emailId=email.getText().toString();
                passcode=password.getText().toString();

                mAuth.createUserWithEmailAndPassword(emailId, passcode).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                   Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    UserDetails userDetails=new UserDetails(username.getText().toString(),passcode,phone.getText().toString(), rollno.getText().toString(),emailId);
                                    mUsersDatabaseReference.push().setValue(userDetails);
                                    updateUI(user);

                                }
                                else {
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(SignUp.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                    updateUI(null);
                                }
                            }
                        });

//                UserDetails userDetails=new UserDetails(username.getText().toString(),password.getText().toString(),phone.getText().toString(), rollno.getText().toString(),email.getText().toString());
 //               mUsersDatabaseReference.push().setValue(userDetails);

 //               Intent intent=new Intent(SignUp.this,SecondActivity.class);
   //             startActivity(intent);

            }
        });



    }

       private void updateUI(FirebaseUser user) {
        if (user != null) {
            Intent logintent=new Intent(SignUp.this,SecondActivity.class);
            startActivity(logintent);

        } else {
            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show();
            //redirect to signup page
        }
    }



}
