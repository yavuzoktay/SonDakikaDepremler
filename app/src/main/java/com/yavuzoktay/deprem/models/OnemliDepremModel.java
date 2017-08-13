package com.yavuzoktay.deprem.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.yavuzoktay.deprem.OnemliDepremler;

public class OnemliDepremModel {

    @SerializedName("data")
    @Expose
    public List<Datum> data = null;

    public OnemliDepremModel withData(List<Datum> data) {
        this.data = data;
        return this;
    }

}