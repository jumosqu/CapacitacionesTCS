package com.clientes;

import com.clases.Clientes;
import com.clases.Empresas;
import com.clases.Personas;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String menu =
                        "         * 1 Agregar cliente\n" +
                        "         * 2 Editar cliente\n" +
                        "         * 3 Eliminar cliente\n" +
                        "         * 4 Agregar productos\n" +
                        "         * 5 Consultar clientes con documento y tipo de documento \n" +
                        "         * 0 salir de la aplicacion";
        Scanner in = new Scanner(System.in);


        //Uso clico do while() para iniciar menu
        @Deprecated(since = "1.2", forRemoval = true)
        Integer opMenu = new Integer(0);
        /**
         * Segun el concepto de polimorfismo un objeto puede tener multiples formas
         * con la estructura de clase que se entrega por favor implementar el concepto de poliformismo
         */
        ArrayList<Clientes> clientes = new ArrayList<>();
        ArrayList<String> productos = new ArrayList<>();
        do {

            System.out.println(menu);
            opMenu = in.nextInt();
            switch (opMenu.toString()) {
                case "1":
                    clientes = agregarCliente(clientes);
                    break;
                case "2":
                    clientes = editarClientes(clientes);
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    for (int i = 0; i < clientes.size(); i++){
                        System.out.println(i + clientes.get(i).getNombre());
                    }
                    break;
                case "0":
                    System.out.println("Muchas gracias por usar nuestra app, hasta luego");
                    break;
                default:
                    System.out.println("El valor ingresado no es una opcion de menu");
                    break;
            }
        } while (!opMenu.toString().equals("0"));
        in.close();

    }
    public static ArrayList<Clientes> agregarCliente(ArrayList<Clientes> clientes){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el tipo de cliente 'Persona o Empresa'");
        String tipoCliente = scanner.nextLine();
        String opcion;
        do {
            if (tipoCliente.equalsIgnoreCase("Persona")){
                clientes.add(personas());
            }else if (tipoCliente.equalsIgnoreCase("Empresa")){
                clientes.add(empresas());
            }
            System.out.println("Desea agregar mas clientes 'Si o No'");
            opcion = scanner.nextLine();
            if (opcion.equalsIgnoreCase("si")){
                System.out.println("Ingrese el tipo de cliente 'Persona o Empresa'");
                tipoCliente = scanner.nextLine();
            }
        }while (opcion.equalsIgnoreCase("si"));
        return clientes;
    }
    public static ArrayList<Clientes> editarClientes(ArrayList<Clientes> clientes){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el tipo de cliente 'Persona o Empresa'");
        String tipoCliente = scanner.nextLine();
        String opcion;
        String tipo;
        Integer documento;
        do {
            if (tipoCliente.equalsIgnoreCase("Persona")){
                System.out.println("Ingrese el tipo y número documento del cliente a editar");
                tipo = scanner.nextLine();
                documento = scanner.nextInt();

                clientes.add(personas());
            }else if (tipoCliente.equalsIgnoreCase("Empresa")){
                clientes.add(empresas());
            }
            System.out.println("Desea agregar mas clientes 'Si o No'");
            opcion = scanner.nextLine();
            if (opcion.equalsIgnoreCase("si")){
                System.out.println("Ingrese el tipo de cliente 'Persona o Empresa'");
                tipoCliente = scanner.nextLine();
            }
        }while (opcion.equalsIgnoreCase("si"));
        return clientes;
    }
    public static Integer buscarIndex(ArrayList<Clientes> clientes, String tipoDoc, String documento){
        for (int i = 0; i < clientes.size(); i++){
            if (clientes.get(i).getTipDoc().equalsIgnoreCase(tipoDoc) && clientes.get(i).getDocumento().equalsIgnoreCase(documento)){

            }
        }
        return 0 ;
    }
    public static Clientes empresas(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la empresa");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el teléfono de la empresa");
        String telefono = scanner.nextLine();
        System.out.println("Ingrese la dirección de la empresa");
        String direccion = scanner.nextLine();
        System.out.println("Ingrese el tipo de documento");
        String tipoDoc = scanner.nextLine();
        System.out.println("Ingrese el número de documento de la empresa");
        String documento = scanner.nextLine();
        System.out.println("Ingrese el nombre del representante de la empresa");
        String representante = scanner.nextLine();
        return new Empresas(nombre,telefono,direccion,tipoDoc,documento,representante);
    }
     public static Clientes personas(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del cliente");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el teléfono del cliente");
        String telefono = scanner.nextLine();
        System.out.println("Ingrese la dirección del cliente");
        String direccion = scanner.nextLine();
        System.out.println("Ingrese el tipo de documento del cliente");
        String tipoDoc = scanner.nextLine();
        System.out.println("Ingrese el número de documento del cliente");
        String documento = scanner.nextLine();
        return new Personas(nombre,telefono,direccion,tipoDoc,documento);
    }
}
