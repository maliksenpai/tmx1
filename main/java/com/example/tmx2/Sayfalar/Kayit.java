package com.example.tmx2.Sayfalar;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.tmx2.Firebase.Kayitol;
import com.example.tmx2.Modeller.Model;
import com.example.tmx2.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Kayit extends AppCompatActivity {
    @BindView(R.id.id) EditText id;
    @BindView(R.id.sifre)EditText sif;
    @BindView(R.id.yaziid)TextView yazid;
    @BindView(R.id.yazisifre)TextView yazsif;
    @BindView(R.id.kayit)Button kayit;
    @OnClick(R.id.kayit)void kayitol(){
        Model model = new Model(id.getText().toString(),sif.getText().toString());
        if(model.getId().length()<1){
            yazid.setText("Email giriniz");
            yazid.setTextColor(Color.RED);
            if(model.getSifre().length()<8){
                yazsif.setText("Sifre(8 karakterden kısa olmamalı)");
                yazsif.setTextColor(Color.RED);
            }}
        else if(model.getSifre().length()<8){
            yazsif.setText("Sifre(8 karakterden kısa olmamalı)");
            yazsif.setTextColor(Color.RED);
            yazid.setText("İsim");
            yazid.setTextColor(Color.BLACK);
        }
        else {
            Kayitol kayitol=new Kayitol();
            kayitol.Kayitol(id.getText().toString(),sif.getText().toString(), Kayit.this);
            yazsif.setText("Sifre");
            yazsif.setTextColor(Color.BLACK);
            yazid.setText("İsim");
            yazid.setTextColor(Color.BLACK);;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);
        ButterKnife.bind(this);
    }
}
