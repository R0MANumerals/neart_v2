package com.neart.romanfeliciano.neart_v2.Tutor;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.neart.romanfeliciano.neart_v2.R;


public class AttachActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutor_file_attachment);
    }
    public void buttonClick1 (View view) {
        Intent intent = new Intent(AttachActivity.this, SecondActivity.class);
        startActivity(intent);
    }


}
