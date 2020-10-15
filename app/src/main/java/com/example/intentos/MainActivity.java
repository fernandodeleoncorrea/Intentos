package com.example.intentos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto("Pepe Suarez", "1111111", "pepe@pepe.com"));
        contactos.add(new Contacto("Juan Peres", "2222222","juan@juan.com"));
        contactos.add(new Contacto("Laura Rosa", "333333", "laura@laura.com"));
        contactos.add(new Contacto("Tuna Mate", "444444","tuna@tuna.com"));
        contactos.add(new Contacto("papel Fernandez", "55555", "papel@papel.com"));

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
        });
    }

}