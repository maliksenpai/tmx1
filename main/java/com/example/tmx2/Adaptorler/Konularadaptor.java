package com.example.tmx2.Adaptorler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tmx2.Firebase.Konular;
import com.example.tmx2.Modeller.Listemodel;
import com.example.tmx2.R;

import java.util.ArrayList;

import butterknife.BindView;

public class Konularadaptor extends RecyclerView.Adapter<Konularadaptor.ViewHolder> {
    private ArrayList<Listemodel> models;
    private Context context;

    private RelativeLayout layout;
    public Konularadaptor(Context context,ArrayList<Listemodel> models) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_item,viewGroup,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Log.d("sonuc", String.valueOf(i));
        viewHolder.textView.setText(models.get(i).getKonu());
        viewHolder.textView2.setText(models.get(i).getAciklama());
        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, models.get(i).getKonu(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return models.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textView1) TextView textView;
        @BindView(R.id.textView2) TextView textView2;
        @BindView(R.id.layout) LinearLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView1);
            textView2=itemView.findViewById(R.id.textView2);
            layout=itemView.findViewById(R.id.layout);
        }
    }
}
