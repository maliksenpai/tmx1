package com.example.tmx2.Sayfalar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.tmx2.Firebase.GirisKontrol;
import com.example.tmx2.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Giris extends AppCompatActivity {
    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @BindView(R.id.idg) EditText id;
    @BindView(R.id.sifreg) EditText sifre;
    @BindView(R.id.button)Button button;
    @OnClick(R.id.button)void Girisyap(){
        GirisKontrol giris= new GirisKontrol();
        if(TextUtils.isEmpty(id.getText().toString())){
            Toast.makeText(Giris.this, "bos birakma", Toast.LENGTH_SHORT).show();
        }
        else if(!id.getText().toString().trim().matches(emailPattern)){
            Toast.makeText(Giris.this, "eposta yanli", Toast.LENGTH_SHORT).show();
        }
        else if(sifre.getText().toString().length()<8){
            Toast.makeText(Giris.this, "sifre kısa", Toast.LENGTH_SHORT).show();
        }
        else{
            giris.getUser(id.getText().toString(),sifre.getText().toString(),Giris.this);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);
        ButterKnife.bind(this);
    }
}
