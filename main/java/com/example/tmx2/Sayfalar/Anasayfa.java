package com.example.tmx2.Sayfalar;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

import com.example.tmx2.Adaptorler.Konularadaptor;
import com.example.tmx2.Firebase.Konular;
import com.example.tmx2.Modeller.Listemodel;
import com.example.tmx2.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
public class Anasayfa extends AppCompatActivity {
    private ArrayList<Listemodel> liste=new ArrayList<Listemodel>();
    private DatabaseReference reference;
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
    @BindView(R.id.liste) RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        reference=FirebaseDatabase.getInstance().getReference().child("duyurular");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    String aciklama = dataSnapshot1.child("aciklama").getValue().toString();
                    String konu =dataSnapshot1.child("isim").getValue().toString();
                    Log.d("gelen", String.valueOf(konu));
                    liste.add(new Listemodel(konu,aciklama));
                }
                Log.d("gelen", String.valueOf(liste.size()));
                Konularadaptor konularadaptor= new Konularadaptor(Anasayfa.this,liste);
                recyclerView.setAdapter(konularadaptor);
                recyclerView.setLayoutManager(new LinearLayoutManager(Anasayfa.this));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("gelen",databaseError.getMessage());
            }
        });
    }
}
