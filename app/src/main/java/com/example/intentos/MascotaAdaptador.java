package com.example.intentos;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{
    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        holder.imgFotoCV.setImageResource(mascota.getFoto());
        holder.tvNombreCV.setText(mascota.getNombre());



        holder.imgFotoCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
               /* Intent intent = new Intent(activity, DetalleMascota.class);
                intent.putExtra("NOMBRE", Mascotas.get(position).getNombre());
                intent.putExtra("TELEFONO", Mascotas.get(position).getTelefono() );
                intent.putExtra("EMAIL", Mascotas.get(position).getEmail() );
                activity.startActivity(intent);*/
            }
        });

        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a : " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends ViewHolder {

        private ImageView   imgFotoCV;
        private TextView    tvNombreCV;
        //private TextView    tvTelefonoCV;
        private ImageButton btnLike;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFotoCV       = (ImageView) itemView.findViewById(R.id.imgFotoCV);
            tvNombreCV      = (TextView) itemView.findViewById(R.id.tvNombreCV);
            //tvRaza   = (TextView) itemView.findViewById(R.id.tvTelefonoCV);
            btnLike         = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }
}

