package com.clases;

import java.util.List;

public class BeneficiosCovid19 {
    //Debe ser el numero entero aleatorio puedes usar la funcion ramdom para esto
    private String id;
    private String nombre;
    private Float valorSubsidio;

    //Completar clase

    public BeneficiosCovid19() {
    }

    public BeneficiosCovid19(String id, String nombre, Float valorSubsidio) {
        this.id = id;
        this.nombre = nombre;
        this.valorSubsidio = valorSubsidio;
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

    public Float getValorSubsidio() {
        return valorSubsidio;
    }

    public void setValorSubsidio(Float valorSubsidio) {
        this.valorSubsidio = valorSubsidio;
    }

    //Implementar un metodo que retorne el mejor beneficio comparando los valores de todos los beneficios
    public Float getMejorbeneficios(List<BeneficiosCovid19> lista1, List<BeneficiosCovid19> lista2 ) {
        Float mayorBeneficio = 0f;
        for (int i = 0; i < lista1.size(); i++) {
            if (lista1.get(i).valorSubsidio > lista2.get(i).valorSubsidio) {
                mayorBeneficio = lista1.get(i).valorSubsidio;
            }else{
                mayorBeneficio = lista2.get(i).valorSubsidio;
            }
        }
        return  Float.valueOf(mayorBeneficio);
    }
}
