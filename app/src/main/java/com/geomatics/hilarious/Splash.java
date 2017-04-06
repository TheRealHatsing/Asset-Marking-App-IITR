package com.geomatics.hilarious;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Splash extends AppCompatActivity implements View.OnClickListener{

    private TextView about;
    private Button getstarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getstarted = (Button) findViewById(R.id.getstarted);
        getstarted.setOnClickListener(this);
        about = (TextView) findViewById(R.id.about);
        about.setOnClickListener(this);
    }
    public void onClick(View view) {
        if(view == about){
            startActivity(new Intent(this, Credits.class));
        }
        if(view == getstarted){
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}
