package com.yavuzoktay.deprem.networks;

import com.yavuzoktay.deprem.models.OnemliDepremModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Yavuz on 9.8.2017.
 */

public interface ServiceGenerator {
    @GET("/onemliDepremler")
    Call<OnemliDepremModel> onemliDepremModel() ;

    @GET("/buyukDepremler")
    Call<OnemliDepremModel> buyukDepremModel();

    @GET("/depremler")
    Call<OnemliDepremModel> sonDepremModel();


}
