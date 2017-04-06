package com.geomatics.hilarious;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;


public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {




    //view objects
    private TextView textViewUserEmail,textView1,textView9;
    private Button buttonLogout, getlocation,next;



    //our new views
    private EditText editTextName, noofteachers,otherattribute1, otherattribute2, otherattribute3, otherattribute4, medium, noofrooms;
    private Button buttonSave, uploadbutton;
    private Spinner type, runby, building, toilet,elec,dw,tele;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        getSupportActionBar().setTitle(" ");
        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);


        //getting the views from xml resource
        editTextName = (EditText) findViewById(R.id.editTextName);

        noofteachers=(EditText) findViewById(R.id.noofstaff);
        next = (Button) findViewById(R.id.next);



        type = (Spinner) findViewById(R.id.typespinner);






        //initializing views
        textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);





         next.setOnClickListener(this);





        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }



    @Override
    public void onClick(View view) {

        if (view == next) {
            if (type.getSelectedItem().toString().equals("School")) {
                startActivity(new Intent(this, School.class));
            } else if (type.getSelectedItem().toString().equals("Medical and Health Facility")) {
                startActivity(new Intent(this, Transport.class));
            } else if (type.getSelectedItem().toString().equals("Water Sources")) {
                startActivity(new Intent(this, Water.class));
            }
            else if (type.getSelectedItem().toString().equals("Bank")) {
                startActivity(new Intent(this, Banks.class));
            }
            else if (type.getSelectedItem().toString().equals("Street Lights, Power and Telephone Pole")) {
                startActivity(new Intent(this, Power.class));
            }
            else if (type.getSelectedItem().toString().equals("Religious Places")) {
                startActivity(new Intent(this, Religious.class));
            }else if (type.getSelectedItem().toString().equals("Commercial")) {
                startActivity(new Intent(this, Commercial.class));
            }
            else if (type.getSelectedItem().toString().equals("Others")) {
                startActivity(new Intent(this, Other.class));
            }
        }
    }
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Profile Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}



