package com.clases;

import javax.swing.*;
import java.util.List;

public class Empresas extends Clientes{

    private String representante;

    public Empresas(String nombre, String telefono, String direccion, String tipDoc, String documento, String representante, List<Producto> productos) {
        super(nombre, telefono, direccion, tipDoc, documento,productos);
        this.representante = representante;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }
}
