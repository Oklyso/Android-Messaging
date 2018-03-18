package com.Lab01.oklyso.oblig1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    public ArrayList<String> numb;

    public static final String EXTRA_MESSAGE = "com.Lab01.oklyso.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numb = new ArrayList<String>();
        numb.add("1");
        numb.add("2");
        numb.add("3");
        numb.add("4");
        numb.add("5");

        spinner = findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, numb);
        spinner.setAdapter(adapter);
        SharedPreferences sharedpreferences = getSharedPreferences("test", MODE_PRIVATE);
        String def = sharedpreferences.getString("selected", "Not defined");
        for(int i = 0; i < numb.size(); i++){
            if(def.contains(numb.get(i))){
                spinner.setSelection(i);
            }
        }
    }
    /** B1 / Send-button functionality*/
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Activity2.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences.Editor editor = getSharedPreferences("test", MODE_PRIVATE).edit();
        editor.putString("selected", spinner.getSelectedItem().toString());
        editor.apply();
    }

}
