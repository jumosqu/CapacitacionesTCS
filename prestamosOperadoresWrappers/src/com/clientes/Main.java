package com.clientes;

import com.clases.BeneficiosCovid19;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code her

        /**
         * Crear 2 lista de beneficios para clientes Lista 1 y Lista 2 por ejemplo
         * Ejemplo:
         * id:12121
         * nombre: Beneficiados que perdieron su trabajo por COVID19
         * valorSubsidio: 150000
         *
         * Ejemplo:
         * id:895656
         * Nombre: Beneficios para persona tercera edad dagnificados COVID
         * valorSubsidio:200000
         */
        BeneficiosCovid19 beneficiosCovid19 = new BeneficiosCovid19();
        List<BeneficiosCovid19> lista1 = new ArrayList<BeneficiosCovid19>();
        List<BeneficiosCovid19> lista2 = new ArrayList<BeneficiosCovid19>();

        lista1.add(new BeneficiosCovid19(getIdBeneficio(),"Julio",400000f));
        lista1.add(new BeneficiosCovid19(getIdBeneficio(),"Camilo",500000f));
        lista1.add(new BeneficiosCovid19(getIdBeneficio(),"Jairo",1200000f));

        lista2.add(new BeneficiosCovid19(getIdBeneficio(),"Andrea",600000f));
        lista2.add(new BeneficiosCovid19(getIdBeneficio(),"Lina",100000f));
        lista2.add(new BeneficiosCovid19(getIdBeneficio(),"Andres",800000f));

        Float mejorBeneficio = beneficiosCovid19.getMejorbeneficios(lista1, lista2);
        comparadorBeneficiarios(mejorBeneficio,lista1, lista2);

    }

    /**
    * Implementa un metodo que entregue un reporte de comparacion de las 2 listas este metodo solo imprimira regiostros
    * Cuando un metodo no retorna un tipo de datos se trabaja con la palabra clave VOID
    * Abarcar los operadores terniarios para condiciones logicas
    * Operadores logicos
    * Operacionres aritmeticos
    **/

    private static void comparadorBeneficiarios(Float mejorBeneficio, List<BeneficiosCovid19> lista1, List<BeneficiosCovid19> lista2 ){
        String mensaje = "";
        for (Integer i = 0; i < lista1.size(); i++){
            if (lista1.get(i).getNombre().length() > lista2.get(i).getNombre().length()){
                switch (i){
                    case 0:
                        mensaje = mensaje("Hola",lista1.get(i).getNombre(), lista1.get(i).getValorSubsidio(),
                                lista1.get(i).getId() ,mejorBeneficio);
                     break;
                    case 1:
                        mensaje = mensaje("Buenas Tardes", lista1.get(i).getNombre(), lista1.get(i).getValorSubsidio(),
                                lista1.get(i).getId(), mejorBeneficio);
                        break;
                    case 2:
                        mensaje = mensaje("Saludos", lista1.get(i).getNombre(), lista1.get(i).getValorSubsidio(),
                                lista1.get(i).getId(),mejorBeneficio);
                        break;
                }
            }
        }
        System.out.println(mensaje);
    }

    private static String mensaje(String saludo, String nombre, Float vlrBeneficion, String id, Float mejorBeneficion){
        String mensaje = saludo + " Sr@ " + nombre + " con el id " + id + " su beneficio es de " + vlrBeneficion
                + " Y el beneficio mas alto de la lista es por " + mejorBeneficion;
        return mensaje;
    }
    //Implementa un metodo que te entregue un numero aletorio para el ide de los beneficios usar el wrapper de Integer
    private static String getIdBeneficio(){
        //La Clase Math tiene varios metodos que te ayudaran
        Integer id = (int) Math.round(Math.random()*10000);
        return id.toString();
    }
}
