package com.neart.romanfeliciano.neart_v2.Tutor;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.neart.romanfeliciano.neart_v2.ForgotPassword;
import com.neart.romanfeliciano.neart_v2.R;

public class TutorSignUp extends AppCompatActivity implements View.OnClickListener {

    //defining view objects
    private Button btnSignup;
    private TextView btnLogin,btnForgotPass;
    private EditText input_email,input_pass;
    private RelativeLayout activity_sign_up;

    private ProgressDialog progressDialog;

    //defining firebaseauth object
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutor_activity_sign_up);

        //initializing firebase auth object
        auth = FirebaseAuth.getInstance();

        //if getCurrentUser does not returns null
        if(auth.getCurrentUser() != null){
            //that means user is already logged in
            //so close this activity
            finish();

            //and open profile activity
            startActivity(new Intent(getApplicationContext(), TutorMainActivity.class));
        }

        //initializing View
        btnSignup = (Button)findViewById(R.id.signup_btn_register);
        btnLogin = (TextView)findViewById(R.id.signup_btn_login);
        btnForgotPass = (TextView)findViewById(R.id.signup_btn_forgot_pass);
        input_email = (EditText)findViewById(R.id.signup_email);
        input_pass = (EditText)findViewById(R.id.signup_password);
        activity_sign_up = (RelativeLayout)findViewById(R.id.activity_sign_up);

        progressDialog = new ProgressDialog(this);

        //attaching listener to button
        btnSignup.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        btnForgotPass.setOnClickListener(this);

    }

    private void registerUser(){

        //getting email and password from edit texts
        String email = input_email.getText().toString().trim();
        String password  = input_pass.getText().toString().trim();

        //checking if email and passwords are empty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }

        //if the email and password are not empty
        //displaying a progress dialog

        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();

        //creating a new user
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(), CreateActivity.class));
                        }else{
                            //display some message here
                            Toast.makeText(TutorSignUp.this,"Registration Error",Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });

    }

    @Override
    public void onClick(View view) {

        if(view == btnSignup){
            registerUser();
        }

        if(view == btnLogin){
            //open login activity when user taps on the already registered textview
            startActivity(new Intent(this, TutorLogIn.class));
        }
        if(view == btnForgotPass){
            //open login activity when user taps on the already registered textview
            startActivity(new Intent(this, ForgotPassword.class));
        }
    }
}