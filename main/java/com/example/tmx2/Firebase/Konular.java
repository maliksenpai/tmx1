package com.example.tmx2.Firebase;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.tmx2.Modeller.Listemodel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class Konular {
    private DatabaseReference reference;
    private List<Listemodel> liste;
    public List<Listemodel> Konular(){
        reference=FirebaseDatabase.getInstance().getReference().child("duyurular");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    String aciklama = dataSnapshot1.child("aciklama").getValue().toString();
                    String konu =dataSnapshot1.child("isim").getValue().toString();
                    liste.add(new Listemodel(konu,aciklama));
                    Log.d("gelen", String.valueOf(liste.size()));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("gelen",databaseError.getMessage());
            }
        });
        return liste;
    }
}
