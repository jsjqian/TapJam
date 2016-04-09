package com.example.jack.tapjam;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PickInstrumentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_instrument);

        Button drum = (Button)findViewById(R.id.drum);
        Button synth = (Button)findViewById(R.id.synth);

        drum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PickInstrumentActivity.this, DrumActivity.class);
                startActivity(intent);
            }
        });

        synth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PickInstrumentActivity.this, Synth.class);
                startActivity(intent);
            }
        });
    }
}
