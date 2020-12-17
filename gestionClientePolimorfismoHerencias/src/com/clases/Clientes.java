package com.clases;

import java.util.List;

public class Clientes {
    private String nombre;
    private String telefono;
    private String direccion;
    private String tipDoc;
    private String documento;
    private List<Producto> productos;

    public Clientes(String nombre, String telefono, String direccion, String tipDoc, String documento,List<Producto> productos) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tipDoc = tipDoc;
        this.documento = documento;
        this.productos = productos;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipDoc() {
        return tipDoc;
    }

    public void setTipDoc(String tipDoc) {
        this.tipDoc = tipDoc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
