package com.neart.romanfeliciano.neart_v2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.neart.romanfeliciano.neart_v2.Tutor.TutorLogIn;
import com.neart.romanfeliciano.neart_v2.Tutor.TutorSignUp;

public class Choose extends AppCompatActivity {
    private ImageButton nTutor, nTutee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose);

        nTutor = (ImageButton) findViewById(R.id.tutor);
        nTutee = (ImageButton) findViewById(R.id.tutee);

        nTutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Choose.this, TutorSignUp.class);
                startActivity(intent);
                finish();
                return;

            }
        });
        nTutee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Choose.this, TutorSignUp.class);
                startActivity(intent);
                finish();
                return;
            }
        });
    }
}
