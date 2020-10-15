package com.example.intentos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString("NOMBRE");
        String telefono = parametros.getString("TELEFONO");
        String email = parametros.getString("EMAIL");

         tvNombre = (TextView) (findViewById(R.id.tvNombre));
         tvTelefono = (TextView) (findViewById(R.id.tvTelefono));
         tvEmail = (TextView) (findViewById(R.id.tvEmail));

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
    }

    public void llamar(View v){
        String telefono= tvTelefono.getText().toString();
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+ telefono)));
    }

    public void enviarcorreo(View v){
        String email= tvEmail.getText().toString();
        Intent emailIntent = new Intent((Intent.ACTION_SEND));
        emailIntent.setData(Uri.parse("mailto:" ));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email"));
    }
}