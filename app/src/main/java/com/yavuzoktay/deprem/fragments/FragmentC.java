package com.yavuzoktay.deprem.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yavuzoktay.deprem.OnemliDepremler;
import com.yavuzoktay.deprem.R;
import com.yavuzoktay.deprem.adapters.CustomRecyclerAdapter;
import com.yavuzoktay.deprem.models.OnemliDepremModel;
import com.yavuzoktay.deprem.networks.Factory;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Yavuz on 9.8.2017.
 */

public class FragmentC extends  Fragment{
    View view ;
    TextView textView;
    RecyclerView recyclerView ;
    ArrayList<OnemliDepremler> onemliDepremler;
    CustomRecyclerAdapter customRecyclerAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sabit,container,false);
       // textView=view.findViewById(R.id.textView3);

        recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(layoutManager);
        onemliDepremler=new ArrayList<OnemliDepremler>();


        Factory.getInstance().onemliDepremModel().enqueue(new Callback<OnemliDepremModel>() {
            @Override
            public void onResponse(Call<OnemliDepremModel> call, Response<OnemliDepremModel> response) {
                //textView.setText(response.body().data.get(0).lokasyon);
               // onemliDepremler.add(response.body().data.get(0).lokasyon);


                customRecyclerAdapter=new CustomRecyclerAdapter(response.body().data.subList(0, 10));
                recyclerView.setAdapter(customRecyclerAdapter);
            }

            @Override
            public void onFailure(Call<OnemliDepremModel> call, Throwable t) {

            }
        });

        return view;

    }
}
