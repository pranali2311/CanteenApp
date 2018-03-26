package com.example.pranali.canteenapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Login extends AppCompatActivity {

    private EditText mPhoneField;
    private EditText mPasswordField;
    private EditText mEmailField;
    private Button submitlogin;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        mAuth=FirebaseAuth.getInstance();

        mPasswordField=(EditText)findViewById(R.id.password1);
        mPhoneField=(EditText)findViewById(R.id.phone1);
        mEmailField=(EditText)findViewById(R.id.email1);
        submitlogin=(Button)findViewById(R.id.submitlogin);

        mAuthListener=new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){

                if(firebaseAuth.getCurrentUser()!=null){
                    //not logged in
                    Intent logintent=new Intent(Login.this,Breakfast.class);
                    logintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(logintent);
                    finish();
                }
            }
        };

        submitlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSignIn();
                //FirebaseUser currentUser = mAuth.getCurrentUser();
                //updateUI(currentUser);
            }
        });
    }

    private void startSignIn(){
        String email1=mEmailField.getText().toString();
        String password1=mPasswordField.getText().toString();
        String phone1=mPhoneField.getText().toString();

        if(TextUtils.isEmpty(email1) || TextUtils.isEmpty(password1) || TextUtils.isEmpty(phone1)) {

            Toast.makeText(Login.this, "Fields are empty!!", Toast.LENGTH_SHORT).show();

        } else {
            mAuth.signInWithEmailAndPassword(email1, password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (!task.isSuccessful()) {
                        Toast.makeText(Login.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Intent logintent=new Intent(Login.this,ChoiceActivity.class);
                        logintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(logintent);
                        finish();
                        mPasswordField.setText("");
                        mEmailField.setText("");
                        mPhoneField.setText("");
                    }
                }
            });
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        mAuth.addAuthStateListener(mAuthListener);
    }

    /* private void updateUI(FirebaseUser user) {
        if (user != null) {
            Intent logintent=new Intent(Login.this,SecondActivity.class);
            startActivity(logintent);

        } else {0
            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show();
            //redirect to signup page
        }
    }*/


}
