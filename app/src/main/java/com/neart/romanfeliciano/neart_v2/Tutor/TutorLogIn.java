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
import com.neart.romanfeliciano.neart_v2.Choose;
import com.neart.romanfeliciano.neart_v2.ForgotPassword;
import com.neart.romanfeliciano.neart_v2.R;

public class TutorLogIn extends AppCompatActivity implements View.OnClickListener {

    //defining views
    private Button btnLogin;
    private EditText input_email, input_password;
    private TextView btnSignup, btnForgotPass;
    private RelativeLayout activity_main;

    //firebase auth object
    private FirebaseAuth auth;

    //progress dialog
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutor_activity_login);

        //getting firebase auth object
        auth = FirebaseAuth.getInstance();

        //if the objects getcurrentuser method is not null
        //means user is already logged in
        if (auth.getCurrentUser() != null) {
            //close this activity
            finish();
            //opening profile activity
            startActivity(new Intent(TutorLogIn.this, TutorMainActivity.class));
        }
        //Initializing View

        btnLogin = (Button) findViewById(R.id.login_btn_login);
        input_email = (EditText) findViewById(R.id.login_email);
        input_password = (EditText) findViewById(R.id.login_password);
        btnSignup = (TextView) findViewById(R.id.login_btn_signup);
        btnForgotPass = (TextView) findViewById(R.id.login_btn_forgot_password);
        activity_main = (RelativeLayout) findViewById(R.id.log_in_activity);

        progressDialog = new ProgressDialog(this);

        //attaching click listener
        btnSignup.setOnClickListener(this);
        btnForgotPass.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    //method for user login


    private void userLogin() {
        String email = input_email.getText().toString().trim();
        String password = input_password.getText().toString().trim();


        //checking if email and passwords are empty
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
            return;
        }

        //if the email and password are not empty
        //displaying a progress dialog

        progressDialog.setMessage("Logging In Please Wait...");
        progressDialog.show();

        //logging in the user
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        //if the task is successfull
                        if (task.isSuccessful()) {
                            //start the profile activity
                            finish();
                            startActivity(new Intent(getApplicationContext(), TutorMainActivity.class));
                        }
                    }
                });

    }

    @Override
    public void onClick(View view) {
        if (view == btnLogin) {
            userLogin();
        }

        if (view == btnSignup) {
            finish();
            startActivity(new Intent(this, Choose.class));
        }
        if (view == btnForgotPass) {
            finish();
            startActivity(new Intent(this, ForgotPassword.class));
        }
    }
}