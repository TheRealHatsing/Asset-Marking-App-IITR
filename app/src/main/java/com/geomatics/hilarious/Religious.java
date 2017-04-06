package com.geomatics.hilarious;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;






public class Religious extends AppCompatActivity implements View.OnClickListener {


    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //view objects
    private TextView type,textViewUserEmail,textView1,textView9;
    private Button buttonLogout, getlocation;


    //defining a database reference
    private DatabaseReference databaseReference;

    //our new views
    private EditText editTextName, noofteachers,otherattribute1, otherattribute2, otherattribute3, otherattribute4, medium, noofrooms;
    private Button buttonSave, uploadbutton;
    private Spinner religion, runby, building, toilet,elec,dw,tele;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    Intent starterIntent4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_religious);
        starterIntent4 = getIntent();
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        getSupportActionBar().setTitle(" ");
        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        //if the user is not logged in
        //that means current user will return null
        if (firebaseAuth.getCurrentUser() == null) {
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }

        //getting the database reference
        databaseReference = FirebaseDatabase.getInstance().getReference();

        //getting the views from xml resource
        editTextName = (EditText) findViewById(R.id.editTextName);




        buttonSave = (Button) findViewById(R.id.buttonSave);
        uploadbutton = (Button) findViewById(R.id.uploadbutton);
        getlocation = (Button) findViewById(R.id.getlocation);
        type = (TextView) findViewById(R.id.textView11);
        textView1=(TextView)findViewById(R.id.textview);
        textView9=(TextView)findViewById(R.id.textView9) ;
        otherattribute1 = (EditText) findViewById(R.id.otherattributes1);
        otherattribute2 = (EditText) findViewById(R.id.otherattributes2);
        otherattribute3 = (EditText) findViewById(R.id.otherattributes3);
        otherattribute4 = (EditText) findViewById(R.id.otherattributes4);
        religion = (Spinner) findViewById(R.id.religiontype);


        FirebaseUser user = firebaseAuth.getCurrentUser();

        //initializing views

        buttonLogout = (Button) findViewById(R.id.buttonLogout);



        //adding listener to button
        buttonLogout.setOnClickListener(this);
        buttonSave.setOnClickListener(this);
        uploadbutton.setOnClickListener(this);
        getlocation.setOnClickListener(this);





        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    public void saveUserInformation() {
        //Getting values from database


        String name = editTextName.getText().toString().trim();
        String rooms = "-";

        String teachers = "-";
        String Type = type.getText().toString();
        String Runby = "-";
        String Building = "-";
        String Toilet = "-";
        String Electricity = "-";
        String Drinkingwater = "-";
        String Telephone = "-";
        String Latitude= textView1.getText().toString().trim();
        String Longitude=textView9.getText().toString().trim();
        String otherattributes2 = otherattribute2.getText().toString().trim();
        String otherattributes3 = otherattribute3.getText().toString().trim();
        String otherattributes4 = otherattribute4.getText().toString().trim();
        String otherattributes1 = otherattribute1.getText().toString().trim();
        String lanes = "Not Applicable";
        String RoadType = "Not Applicable";
        String Built = "Not Applicable";
        String staff = "-";
        String TypeHospital = "-";
        String WaterType = "-";
        String waterLevel = "-";
        String Uses = "-";
        String Powertype = "-";
        String Religious = religion.getSelectedItem().toString();

        String Commercial = "-";


        //creating a userinformation object
        UserInformation userInformation = new UserInformation(name,Powertype,Commercial, Religious,  rooms, WaterType, Uses , waterLevel,staff, teachers, TypeHospital, otherattributes1, otherattributes2, otherattributes3, otherattributes4, Type, Runby, Toilet,  Building,Electricity, Drinkingwater, Telephone, Latitude, Longitude);

        //getting the current logged in user
        FirebaseUser user = firebaseAuth.getCurrentUser();


        if (user != null) {
            String email = user.getEmail().toString().trim();
            databaseReference.child(user.getUid()).child(name).setValue(userInformation);


        }

        //displaying a success toast
        Toast.makeText(this, "Information Saved...", Toast.LENGTH_LONG).show();


    }


    @Override
    public void onClick(View view) {
        //if logout is pressed
        if (view == buttonLogout) {
            //logging out the user
            firebaseAuth.signOut();
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }

        if (view == buttonSave) {
            saveUserInformation();

        }

        if (view == uploadbutton) {
            startActivity(new Intent(this, Uploadimage.class));
        }

        if (view == getlocation) {
            Intent intentGetMessage=new Intent(this,AndroidLocation.class);
            startActivityForResult(intentGetMessage, 2);



        }



    }
    @Override
    public void onBackPressed() {

        finish();
        startActivity(starterIntent4);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);


        // check if the request code is same as what is passed  here it is 2
        if(requestCode==2)
        {
            // fetch the message String
            String lat=data.getStringExtra("MESSAGE");
            String lon=data.getStringExtra("MESSAG");

            // Set the message string in textView
            textView1.setText(lat);
            textView9.setText(lon);

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



