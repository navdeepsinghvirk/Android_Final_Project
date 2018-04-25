package com.mrvirk.parkingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.mrvirk.parkingsystem.DB.DBAddTicket;
import com.mrvirk.parkingsystem.DB.DBHelper;
import com.mrvirk.parkingsystem.Model.AddTicket;

import java.util.List;

public class AddTicketActivity extends AppCompatActivity {

    TextView vnumber;
    TextView vbrand;
    Spinner vcolor;
    RadioGroup time;
    Spinner lane;
    Spinner position;
    Spinner paymethod;
    Button btnsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ticket);
        vnumber = (TextView) findViewById(R.id.vnumber);
        vbrand = (TextView) findViewById(R.id.vbrand);
        vcolor = (Spinner) findViewById(R.id.vcolor);
        lane = (Spinner) findViewById(R.id.lane);
        position = (Spinner) findViewById(R.id.position);
        // time = (RadioGroup) findViewById(R.id.timer);
        paymethod = (Spinner) findViewById(R.id.paymethod);
        btnsave = (Button) findViewById(R.id.btn);
        time = (RadioGroup) findViewById(R.id.time);
        int idd = time.getCheckedRadioButtonId();
        final RadioButton radioButton = (RadioButton) time.findViewById(idd);
        //time=(RadioButton) findViewById(R.id.);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //     if (validate()) {
                AddTicket ad = new AddTicket();


                ad.setVnumber(vnumber.getText().toString());
                ad.setVbrand(vbrand.getText().toString());
                ad.setVcolor(vcolor.getSelectedItem().toString());
                ad.setLane(lane.getSelectedItem().toString());
                ad.setPosition(position.getSelectedItem().toString());
                ad.setPaymethod(paymethod.getSelectedItem().toString());
                loadSpinnerData();


                DBAddTicket ad1 = new DBAddTicket(AddTicketActivity.this);
                ad1.insertTicket(ad);
                ad1.getAllTickets();
                // ad.get();
                Intent intent = new Intent(AddTicketActivity.this, HomeActivity.class);
                startActivity(intent);


                //  }
            }
        });
    }


    private void loadSpinnerData() {
        // database handler
        DBHelper db = new DBHelper(getApplicationContext());

        // Spinner Drop down elements
        List<String> lables = db.getAllLabels();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);

        // Drop down layout style - list view with radio button
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        lane.setAdapter(dataAdapter);
        vcolor.setAdapter(dataAdapter);
        position.setAdapter(dataAdapter);
        paymethod.setAdapter(dataAdapter);
    }




}