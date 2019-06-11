package com.example.tmx2.Sayfalar;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tmx2.Adaptorler.Konularadaptor;
import com.example.tmx2.Modeller.Listemodel;
import com.example.tmx2.R;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTouch;

public class Kullanici extends AppCompatActivity implements Konularadaptor.onClick {
    private ArrayList<Listemodel> liste=new ArrayList<Listemodel>();
    private DatabaseReference reference;
    @BindView(R.id.liste)
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kullanici);
        Bundle gelenler=getIntent().getExtras();
        FirebaseUser user= (FirebaseUser) gelenler.get("kullanici");
        ButterKnife.bind(this);
        reference= FirebaseDatabase.getInstance().getReference().child("duyurular");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    String aciklama = dataSnapshot1.child("aciklama").getValue().toString();
                    String konu =dataSnapshot1.child("isim").getValue().toString();
                    String enlem =dataSnapshot1.child("enlem").getValue().toString();
                    String boylam =dataSnapshot1.child("boylam").getValue().toString();
                    Log.d("gelen", String.valueOf(konu));
                    liste.add(new Listemodel(konu,aciklama,boylam,enlem));
                }
                Log.d("gelen", String.valueOf(liste.size()));
                Konularadaptor konularadaptor= new Konularadaptor(Kullanici.this,liste);
                recyclerView.setAdapter(konularadaptor);
                recyclerView.setLayoutManager(new LinearLayoutManager(Kullanici.this));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("gelen",databaseError.getMessage());
            }
        });
    }

    @Override
    public void onClick(int position) {

    }
}
