package com.yavuzoktay.deprem.adapters;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.yavuzoktay.deprem.OnemliDepremler;
import com.yavuzoktay.deprem.R;
import com.yavuzoktay.deprem.models.Datum;
import com.yavuzoktay.deprem.models.OnemliDepremModel;

import java.util.List;

/**
 * Created by Yavuz on 9.8.2017.
 */

public class SonDepremRecyclerAdapter extends RecyclerView.Adapter<SonDepremRecyclerAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView buyukluk;
        public TextView yer;
        public TextView tarih;
        public CardView cardView ;


        public ViewHolder(final View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            buyukluk=itemView.findViewById(R.id.text_buyukluk);
            yer=itemView.findViewById(R.id.text_yer);
            tarih=itemView.findViewById(R.id.text_tarih);


        }
    }
    List<Datum> onemliDepremler;
     GoogleMap googleMap;


    public SonDepremRecyclerAdapter(List<Datum> onemliDepremler,  GoogleMap googleMap) {
        this.onemliDepremler = onemliDepremler;
        this.googleMap=googleMap;
    }

    @Override
    public SonDepremRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.onemli_custom,parent,false);
        final ViewHolder view_holder=new ViewHolder(v);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.buyukluk.setText(onemliDepremler.get(position).siddeti);
        holder.tarih.setText("Tarih  :"+onemliDepremler.get(position).tarih2);
        holder.yer.setText(onemliDepremler.get(position).lokasyon);




        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                googleMap.clear();
                LatLng latLng=new LatLng(Float.parseFloat(onemliDepremler.get(position).lat), Float.parseFloat(onemliDepremler.get(position).lng));
                googleMap.addMarker(new MarkerOptions().position(latLng).title("Marker Title").snippet("Marker Description"));

                CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(12).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

            }
        });



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
