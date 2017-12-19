package com.neart.romanfeliciano.neart_v2.Tutor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import com.neart.romanfeliciano.neart_v2.R;


public class CreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutor_activity_create_account);
    }


    public void buttonClick (View view) {
        Intent intent=new Intent(CreateActivity.this,AttachActivity.class);
        startActivity(intent);

    }


    public void onRadioButtonClicked(View view) {
        boolean Checked = ((RadioButton) view). isChecked();

        switch(view.getId()) {
            case R.id.radioButton:
                if (Checked)
                    break;

            case R.id.radioButton2:
                if (Checked)
                    break; {
        }
    }

    }





}

