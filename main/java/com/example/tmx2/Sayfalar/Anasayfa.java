package com.example.tmx2.Sayfalar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import com.example.tmx2.R;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
public class Anasayfa extends AppCompatActivity {
    @BindView(R.id.button4)Button giris;
    @BindView(R.id.button3)Button kayit;
    @OnClick(R.id.button3)void kayitekrani(){
        Intent intent=new Intent(Anasayfa.this, Kayit.class);
        startActivity(intent);
    }
    @OnClick(R.id.button4)void girisekrani(){
        Intent intent = new Intent(Anasayfa.this, Giris.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}