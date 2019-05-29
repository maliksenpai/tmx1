package com.example.tmx2.Firebase;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.example.tmx2.Sayfalar.Kullanici;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class GirisKontrol {
    private FirebaseAuth auth;
    public void getUser(String eposta, String sifre,final Context context) {
        auth = FirebaseAuth.getInstance();
                auth.signInWithEmailAndPassword(eposta, sifre).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    context.startActivity(new Intent(context,Kullanici.class).putExtra("kullanici",auth.getCurrentUser()));
                } else {
                    Toast.makeText(context, "hata var", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
