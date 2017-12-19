
package com.neart.romanfeliciano.neart_v2;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageButton;

        import com.neart.romanfeliciano.neart_v2.Tutor.TutorMainActivity;


public class welcome extends AppCompatActivity {
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        next = (Button) findViewById(R.id.button19);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(welcome.this, TutorMainActivity.class);
                startActivity(intent);
                finish();
                return;

            }
        });
    }
}