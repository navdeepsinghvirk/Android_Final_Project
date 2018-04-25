package com.mrvirk.parkingsystem.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrvirk.parkingsystem.Model.AddTicket;
import com.mrvirk.parkingsystem.R;

import java.util.List;

public  class TicketAdapter extends RecyclerView.Adapter<TicketViewHolder> {
    private List<AddTicket> addTicketList;
    private Context context;
    public TicketAdapter(Context context, List<AddTicket> addTicketList)
    {
        this.addTicketList = addTicketList;
        this.context = context;
    }
    @Override
    public TicketViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.report_layout,parent,false);
        return new TicketViewHolder(view);
    }
    @Override
    public void onBindViewHolder(TicketViewHolder holder, int position) {

        AddTicket ticket = addTicketList.get(position);
        holder.vnumber.setText(ticket.getVnumber());
        holder.vbrand.setText(ticket.getVbrand());
        holder.vcolor.setText(ticket.getVcolor());
        holder.position.setText(ticket.getPosition());
        holder.lane.setText(ticket.getLane());
        holder.time.setText(ticket.getTime());
        holder.paymethod.setText(ticket.getPaymethod());




    }
    @Override
    public int getItemCount() {
        return addTicketList.size();
    }

}

