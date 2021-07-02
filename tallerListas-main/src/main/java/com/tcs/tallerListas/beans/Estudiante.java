package com.tcs.tallerListas.beans;

public class Estudiante {

    private String id;
    private String nombre;
    private String edad;
    private String grado;

    public Estudiante(String id, String nombre, String edad, String grado) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.grado = grado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }
}
