package com.geomatics.hilarious;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class dashboard extends AppCompatActivity implements View.OnClickListener {
private Button Record,View;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        getSupportActionBar().setTitle(" ");
        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
    Record = (Button) findViewById(R.id.rasset);
        View = (Button) findViewById(R.id.vasset);
        Record.setOnClickListener(this);
        View.setOnClickListener(this);}

    @Override
    public void onClick(View view) {
        if (view==Record){
            startActivity(new Intent(this, ProfileActivity.class));}
            if (view==View){
                startActivity(new Intent(this, Maps.class));
        }
    }
}
