package com.yavuzoktay.deprem.fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.yavuzoktay.deprem.MainActivity;
import com.yavuzoktay.deprem.OnemliDepremler;
import com.yavuzoktay.deprem.R;
import com.yavuzoktay.deprem.adapters.BuyukRecyclerAdapter;
import com.yavuzoktay.deprem.adapters.SonDepremRecyclerAdapter;
import com.yavuzoktay.deprem.models.OnemliDepremModel;
import com.yavuzoktay.deprem.networks.Factory;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentA extends Fragment {

    MapView mMapView;
    private GoogleMap googleMap;
    View view ;
    TextView textView;
    RecyclerView recyclerView ;
    ArrayList<OnemliDepremler> onemliDepremler;
    SonDepremRecyclerAdapter sonDepremRecyclerAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.son_deprem_custom, container, false);



        recyclerView = rootView.findViewById(R.id.son_recycler);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(layoutManager);
        onemliDepremler=new ArrayList<OnemliDepremler>();

        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

//                LatLng sydney = new LatLng(-34, 151);
//
//
//                // For zooming automatically to the location of the marker
//


            }
        });

        Factory.getInstance().sonDepremModel().enqueue(new Callback<OnemliDepremModel>() {
            @Override
            public void onResponse(Call<OnemliDepremModel> call, Response<OnemliDepremModel> response) {
                sonDepremRecyclerAdapter=new SonDepremRecyclerAdapter(response.body().data.subList(0, 10),googleMap);

                LatLng latLng=new LatLng(Float.parseFloat(response.body().data.get(0).lat), Float.parseFloat(response.body().data.get(0).lng));
                googleMap.addMarker(new MarkerOptions().position(latLng).title("Marker Title").snippet("Marker Description"));

                CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(12).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                recyclerView.setAdapter(sonDepremRecyclerAdapter);
            }

            @Override
            public void onFailure(Call<OnemliDepremModel> call, Throwable t) {

            }
        });

        return rootView;
    }



    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}