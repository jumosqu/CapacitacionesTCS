package com.clases;

import java.util.List;

public class Personas extends Clientes{
    public Personas(String nombre, String telefono, String direccion, String tipDoc, String documento, List<Producto> productos) {
        super(nombre, telefono, direccion, tipDoc, documento, productos);
    }
}
