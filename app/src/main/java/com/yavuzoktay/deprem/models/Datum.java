package com.yavuzoktay.deprem.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("tarih")
    @Expose
    public String tarih;
    @SerializedName("tarih2")
    @Expose
    public String tarih2;
    @SerializedName("lokasyon")
    @Expose
    public String lokasyon;
    @SerializedName("siddeti")
    @Expose
    public String siddeti;
    @SerializedName("hissedilensiddedi")
    @Expose
    public String hissedilensiddedi;
    @SerializedName("cankaybi")
    @Expose
    public String cankaybi;
    @SerializedName("hasarlibina")
    @Expose
    public String hasarlibina;
    @SerializedName("hit")
    @Expose
    public String hit;
    @SerializedName("yorum")
    @Expose
    public String yorum;
    @SerializedName("re")
    @Expose
    public String re;
    @SerializedName("ge")
    @Expose
    public String ge;
    @SerializedName("be")
    @Expose
    public String be;
    @SerializedName("lat")
    @Expose
    public String lat;
    @SerializedName("lng")
    @Expose
    public String lng;

    public Datum withId(String id) {
        this.id = id;
        return this;
    }

    public Datum withTarih(String tarih) {
        this.tarih = tarih;
        return this;
    }

    public Datum withTarih2(String tarih2) {
        this.tarih2 = tarih2;
        return this;
    }

    public Datum withLokasyon(String lokasyon) {
        this.lokasyon = lokasyon;
        return this;
    }

    public Datum withSiddeti(String siddeti) {
        this.siddeti = siddeti;
        return this;
    }

    public Datum withHissedilensiddedi(String hissedilensiddedi) {
        this.hissedilensiddedi = hissedilensiddedi;
        return this;
    }

    public Datum withCankaybi(String cankaybi) {
        this.cankaybi = cankaybi;
        return this;
    }

    public Datum withHasarlibina(String hasarlibina) {
        this.hasarlibina = hasarlibina;
        return this;
    }

    public Datum withHit(String hit) {
        this.hit = hit;
        return this;
    }

    public Datum withYorum(String yorum) {
        this.yorum = yorum;
        return this;
    }

    public Datum withRe(String re) {
        this.re = re;
        return this;
    }

    public Datum withGe(String ge) {
        this.ge = ge;
        return this;
    }

    public Datum withBe(String be) {
        this.be = be;
        return this;
    }

    public Datum withLat(String lat) {
        this.lat = lat;
        return this;
    }

    public Datum withLng(String lng) {
        this.lng = lng;
        return this;
    }

}