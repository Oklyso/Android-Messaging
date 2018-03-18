package com.Lab01.oklyso.oblig1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    public Button button;
    // Initialiserer en knapp og
    // Gir den en 'activity'.

    public void init(){
        button = (Button)findViewById(R.id.but2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent click = new Intent(Activity2.this, Activity3.class);
                startActivity(click);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

       //Tar imot Intenten til Activity, og kopierer string.
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Fanger teksten fra TextView og setter det som message-stringen.
        TextView textView = findViewById(R.id.textView);
        textView.setText("Hello " + message);


        init();
    }

}
