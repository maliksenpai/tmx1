package com.example.tmx2.Firebase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;
import com.example.tmx2.Sayfalar.Anasayfa;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Kayitol {
    private FirebaseAuth auth;
    public void Kayitol(String eposta, String sifre, final Context context){
        auth=FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(eposta,sifre)
                .addOnCompleteListener((Activity) context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(context, "Yetkilendirme Hatası",
                                    Toast.LENGTH_SHORT).show();
                        }
                        else {
                            context.startActivity(new Intent(context, Anasayfa.class));
                        }
                    }
                });
    }
}
