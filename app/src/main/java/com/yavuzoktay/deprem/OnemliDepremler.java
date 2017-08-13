package com.yavuzoktay.deprem;

/**
 * Created by Yavuz on 9.8.2017.
 */

public class OnemliDepremler {
    private String buyukluk;
    private String yer;
    private String tarih;
    private String derinlik;

    public OnemliDepremler(String buyukluk, String yer, String tarih, String derinlik) {
        this.buyukluk = buyukluk;
        this.yer = yer;
        this.tarih = tarih;
        this.derinlik = derinlik;
    }

    public String getBuyukluk() {
        return buyukluk;
    }

    public void setBuyukluk(String buyukluk) {
        this.buyukluk = buyukluk;
    }

    public String getYer() {
        return yer;
    }

    public void setYer(String yer) {
        this.yer = yer;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getDerinlik() {
        return derinlik;
    }

    public void setDerinlik(String derinlik) {
        this.derinlik = derinlik;
    }
}


