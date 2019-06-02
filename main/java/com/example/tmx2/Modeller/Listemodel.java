package com.example.tmx2.Modeller;

public class Listemodel {
    private String konu;
    private String aciklama;

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setKonu(String konu) {
        this.konu = konu;
    }

    public String getKonu() {
        return konu;
    }
    public Listemodel(String konu,String aciklama){
        this.konu=konu;
        this.aciklama=aciklama;
    }
}
