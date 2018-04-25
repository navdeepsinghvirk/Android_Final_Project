package com.mrvirk.parkingsystem.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mrvirk.parkingsystem.R;

public class TicketViewHolder extends RecyclerView.ViewHolder {
    public TextView vnumber;
    public TextView  vbrand;
    public TextView vcolor;
    public TextView position;
    public TextView lane;
    public TextView time;
    public TextView paymethod;


    public TicketViewHolder(View itemView) {
        super(itemView);
        vnumber= (TextView)itemView.findViewById(R.id.vnumber) ;
        vbrand= (TextView)itemView.findViewById(R.id.vbrand);
        vcolor= (TextView)itemView.findViewById(R.id.vcolor);
        position=(TextView)itemView.findViewById(R.id.position);
        lane=(TextView)itemView.findViewById(R.id.lane);
        paymethod=(TextView)itemView.findViewById(R.id.paymethod);

    }


}

