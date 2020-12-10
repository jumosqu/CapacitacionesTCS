package com.company;

import clases.CapacidadEndedudamiento;
import clases.Constantes;
import javafx.scene.input.KeyCode;

import java.util.Scanner;

public class Main {
    //Recuerda que aca empieza todo
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        CapacidadEndedudamiento capacidadEndedudamiento = new CapacidadEndedudamiento();
        Constantes mensajes = new Constantes();
        String salario;
        String gastosFijos;
        String gastosVariables;
        do {
            System.out.println(mensajes.getMenIngresosTotales() + mensajes.getMenContinuar());
            salario = in.nextLine();
            if (isNumeric(salario) == false){
                capacidadEndedudamiento.setIngresosTotales(Integer.parseInt(salario));
            }
        }while (isNumeric(salario) && salario.equalsIgnoreCase("si") != true);

        do {
            System.out.println(mensajes.getMenGastosFijos() + mensajes.getMenContinuar());
            gastosFijos = in.nextLine();
            if (isNumeric(salario) == false){
                capacidadEndedudamiento.setGastosFijos(Integer.parseInt(gastosFijos));
            }
        }while (isNumeric(gastosFijos) && salario.equalsIgnoreCase("si") != true);

        do {
            System.out.println(mensajes.getMenGastosVariables() + mensajes.getMenContinuar());
            gastosVariables = in.nextLine();
            if (isNumeric(salario) == false){
                capacidadEndedudamiento.setGastoVaribales(Integer.parseInt(gastosVariables));
            }
        } while (isNumeric(gastosVariables) && salario.equalsIgnoreCase("si") != true);
        in.close();
        System.out.println(capacidadEndedudamiento.getCapacidadEndeudamiento());

    }
    public static boolean isNumeric(String value) {
        try {
            Double.parseDouble(value);
        } catch (Exception e) {
            return true;
        }
        return false;
    }
}
