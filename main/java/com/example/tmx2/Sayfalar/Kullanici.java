package com.example.tmx2.Sayfalar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.example.tmx2.R;
import com.google.firebase.auth.FirebaseUser;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTouch;

public class Kullanici extends AppCompatActivity {
    @BindView(R.id.yazi) TextView yazi;
    @OnTouch(R.id.yazi) boolean renk(){
        Toast.makeText(this, "lel", Toast.LENGTH_SHORT).show();
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kullanici);
        Bundle gelenler=getIntent().getExtras();
        FirebaseUser user= (FirebaseUser) gelenler.get("kullanici");
        ButterKnife.bind(this);
        yazi.setText(user.getEmail());
    }
}
