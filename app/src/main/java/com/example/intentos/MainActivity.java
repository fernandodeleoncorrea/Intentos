package com.example.intentos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    public ContactoAdaptador adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaContactos.setLayoutManager(llm);

        inicializarListaDeContactos();
        inicializarAdaptador();

        /*
        ArrayList<String> nombresContacto = new ArrayList<>();

        for (Contacto contacto : contactos) {
            nombresContacto.add(contacto.getNombre());
        }

        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,nombresContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //intent Explicito
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra("NOMBRE", contactos.get(position).getNombre());
                intent.putExtra("TELEFONO", contactos.get(position).getTelefono() );
                intent.putExtra("EMAIL", contactos.get(position).getEmail() );
                startActivity(intent);
            }
        });*/
    }
    private void inicializarAdaptador(){
        adaptador = new ContactoAdaptador(contactos, this);
        listaContactos.setAdapter(adaptador);
    }
    public void inicializarListaDeContactos(){
        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto("Pepe Suarez", "1111111", "pepe@pepe.com", R.drawable.escudo));
        contactos.add(new Contacto("Juan Peres", "2222222","juan@juan.com", R.drawable.marcianito2));
        contactos.add(new Contacto("Chori Castro", "333333", "chori@chori.com", R.drawable.marcianito_android9));
        contactos.add(new Contacto("Gomito Corujo", "444444","gomito@gomito.com", R.drawable.mail));
        contactos.add(new Contacto("Sebita Fernandez", "55555", "papel@papel.com", R.drawable.phone));


    }
}