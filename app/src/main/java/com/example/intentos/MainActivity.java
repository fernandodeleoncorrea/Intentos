package com.example.intentos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> Mascotas;
    private RecyclerView listaMascotas;
    public MascotaAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar miActionBar = findViewById(R.id.miActionbar);
        //setSupportActionBar(miActionBar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        inicializarListaDeMascotas();
        inicializarAdaptador();


        ArrayList<String> nombresMascota = new ArrayList<>();
        /*
        for (Mascota Mascota : Mascotas) {
            nombresMascota.add(Mascota.getNombre());
        }

        ListView lstMascotas = (ListView) findViewById(R.id.lstMascotas);
        lstMascotas.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,nombresMascota));

        listaMascotas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //intent Explicito
                Intent intent = new Intent(MainActivity.this, DetalleMascota.class);
                intent.putExtra("NOMBRE", Mascotas.get(position).getNombre());
                intent.putExtra("TELEFONO", Mascotas.get(position).getTelefono() );
                intent.putExtra("EMAIL", Mascotas.get(position).getEmail() );
                startActivity(intent);
            }
        });*/
    }
    private void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(Mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }
    public void inicializarListaDeMascotas(){
        Mascotas = new ArrayList<Mascota>();
        Mascotas.add(new Mascota("Perro", "perro del sofa", "4", R.drawable.perro));
        Mascotas.add(new Mascota("Gato", "gato del sillon","2", R.drawable.gato));
        Mascotas.add(new Mascota("Lagarto", "lagartija", "17", R.drawable.lagarto));
        Mascotas.add(new Mascota("Chancho", "puerco del jardin","5", R.drawable.chancho));
        Mascotas.add(new Mascota("Pato", "pato del estanque", "0", R.drawable.pato));
    }

    public void irSiguienteActividad(View w){
        Intent intent = new Intent(MainActivity.this, DetalleMascota.class);
        startActivity(intent);
    }
}