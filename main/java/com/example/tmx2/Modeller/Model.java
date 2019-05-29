package com.example.tmx2.Modeller;

public class Model {
    String id,sifre;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
    public Model(String id,String sifre){
        this.id=id;
        this.sifre=sifre;
    }
}
