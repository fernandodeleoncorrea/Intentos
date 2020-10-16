package com.example.intentos;

public class Mascota {
    private String nombre;
    private String raza;
    private String edad;
    private int foto;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public Mascota() {
    }

    public Mascota(String nombre, String raza, String edad, int foto) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.foto = foto;
    }
}

