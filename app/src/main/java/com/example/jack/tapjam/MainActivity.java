package com.example.jack.tapjam;

import android.app.Activity;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = (Button)findViewById(R.id.start_button);
        Log.d("before initialize", "1");
        Intent external_sounds = new Intent(Intent.ACTION_SYNC, null, this, GetSounds.class);
        startService(external_sounds);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateSessionActivity.class);
                startActivity(intent);
            }
        });
    }


}
