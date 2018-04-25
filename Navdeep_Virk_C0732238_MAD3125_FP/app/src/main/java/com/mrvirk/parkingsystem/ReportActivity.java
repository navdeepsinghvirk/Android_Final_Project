package com.mrvirk.parkingsystem;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.mrvirk.parkingsystem.Adapter.TicketAdapter;
import com.mrvirk.parkingsystem.DB.DBAddTicket;
import com.mrvirk.parkingsystem.Model.AddTicket;

import java.util.ArrayList;

public class ReportActivity extends AppCompatActivity {

    TicketAdapter ticketAdapter;
    ListView lstTicket;
    ArrayList<AddTicket> TicketList;
    public static void startIntent(Context context)
    {
        context.startActivity(new Intent(context,ReportActivity.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.addticket);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ReportActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);


        DBAddTicket ad= new DBAddTicket(this);

        TicketList = (ArrayList<AddTicket>) ad.getAllTickets();

        ticketAdapter = new TicketAdapter(this,TicketList);

        recyclerView.setAdapter(ticketAdapter);
    }
}

