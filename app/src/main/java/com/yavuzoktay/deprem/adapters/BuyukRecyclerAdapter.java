package com.yavuzoktay.deprem.adapters;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.yavuzoktay.deprem.OnemliDepremler;
import com.yavuzoktay.deprem.R;
import com.yavuzoktay.deprem.models.Datum;
import com.yavuzoktay.deprem.models.OnemliDepremModel;

import java.util.List;

/**
 * Created by Yavuz on 9.8.2017.
 */

public class BuyukRecyclerAdapter extends RecyclerView.Adapter<BuyukRecyclerAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView buyukluk;
        public TextView yer;
        public TextView tarih;
        public CardView cardView ;
        FrameLayout frameLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            buyukluk=itemView.findViewById(R.id.text_buyukluk);
            yer=itemView.findViewById(R.id.text_yer);
            tarih=itemView.findViewById(R.id.text_tarih);
            frameLayout=itemView.findViewById(R.id.frame_layout);
        }
    }
    List<Datum> onemliDepremler;

    public BuyukRecyclerAdapter(List<Datum> onemliDepremler) {
        this.onemliDepremler = onemliDepremler;
    }

    @Override
    public BuyukRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.onemli_custom,parent,false);
        final ViewHolder view_holder=new ViewHolder(v);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.buyukluk.setText(onemliDepremler.get(position).siddeti);
        holder.tarih.setText("Tarih  :"+onemliDepremler.get(position).tarih);
        holder.yer.setText(onemliDepremler.get(position).lokasyon);

        if(Float.parseFloat(onemliDepremler.get(position).siddeti)>7){
            holder.frameLayout.setBackgroundColor(Color.RED);
        }
        else{
            holder.frameLayout.setBackgroundColor(Color.YELLOW);
        }


    }

    @Override
    public int getItemCount() {
        return onemliDepremler.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    



}
