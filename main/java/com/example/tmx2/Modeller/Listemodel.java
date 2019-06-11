package com.example.tmx2.Modeller;

public class Listemodel {
    private String konu;
    private String aciklama;
    private String enlem;
    private String boylam;

    public String getBoylam() {
        return boylam;
    }

    public String getEnlem() {
        return enlem;
    }

    public void setBoylam(String boylam) {
        this.boylam = boylam;
    }

    public void setEnlem(String enlem) {
        this.enlem = enlem;
    }

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
    public Listemodel(String konu,String aciklama,String boylam,String enlem){
        this.konu=konu;
        this.aciklama=aciklama;
        this.boylam=boylam;
        this.enlem=enlem;
    }
}
