package com.clientes;

import com.clases.Clientes;
import com.clases.Empresas;
import com.clases.Personas;
import com.clases.Producto;

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
        ArrayList<Producto> productos = new ArrayList<>();
        do {

            System.out.println(menu);
            opMenu = in.nextInt();
            switch (opMenu.toString()) {
                case "1":
                    clientes = agregarCliente(clientes, productos);
                    break;
                case "2":
                    clientes = editarClientes(clientes, productos);
                    break;
                case "3":
                    clientes = eliminarClientes(clientes);
                    break;
                case "4":
                    productos = agregarProductos(productos);
                    break;
                case "5":
                    consultarClientes(clientes);
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

    public static void consultarClientes(ArrayList<Clientes> clientes){
        Scanner in = new Scanner(System.in);
        int index = buscarIndex(clientes);
        System.out.println("Nombre: " + clientes.get(index).getNombre() + "\n" +
                "Tipo de documento: " + clientes.get(index).getTipDoc() + "\n" +
                "Documento: " + clientes.get(index).getDocumento() + "\n" +
                "Direccion: " + clientes.get(index).getDireccion() + "\n" +
                "Teléfono: " + clientes.get(index).getTelefono());
        if (clientes.get(index).getTipDoc().equalsIgnoreCase("nit")){
            Empresas empresa  = (Empresas) clientes.get(index);
            System.out.println("Nombre del representante: " + empresa.getRepresentante() + "\n");
        }
        System.out.println("Sus productos son: ");
        for (int i = 0; i < clientes.get(index).getProductos().size(); i++){
            System.out.println(
                    "Id del producto: " + clientes.get(index).getProductos().get(i).getIdProducto() +
                            " Nombre del producto: " + clientes.get(index).getProductos().get(i).getNombre() +
                            " Carateristica del producto: " + clientes.get(index).getProductos().get(i).getCarateristicas() +
                            " Condiciones del producto: " + clientes.get(index).getProductos().get(i).getCondiciones()
            );
        }
    }

    public static ArrayList<Producto> agregarProductos(ArrayList<Producto> productos){
        Scanner in = new Scanner(System.in);
        int id = productos.size();
        System.out.println("Ingrese el nombre del producto");
        String nombre = in.nextLine();
        System.out.println("id: " + (id+1) + " producto generado automaticamente");
        String idProducto = "" + id + 1;
        System.out.println("Ingrese una caracteristica del producto");
        String caracteristica = in.nextLine();
        System.out.println("Ingrese la condicion del producto");
        String condicion = in.nextLine();
        productos.add(new Producto(nombre,caracteristica,idProducto,condicion));
        return productos;
    }

    public static ArrayList<Clientes> agregarCliente(ArrayList<Clientes> clientes, ArrayList<Producto> productos){
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el tipo de cliente 'Persona o Empresa'");
        String tipoCliente = in.nextLine();
        String opcion;
        do {
            if (tipoCliente.equalsIgnoreCase("Persona")){
                if (validarExitenciaProduc(productos)){
                    clientes.add(personas(productos));
                }else{
                    break;
                }
            }else if (tipoCliente.equalsIgnoreCase("Empresa")){
                if (validarExitenciaProduc(productos)){
                    clientes.add(empresas(productos));
                }else{
                    break;
                }
            }
            System.out.println("Desea agregar mas clientes 'Si o No'");
            opcion = in.nextLine();
            if (opcion.equalsIgnoreCase("si")){
                System.out.println("Ingrese el tipo de cliente 'Persona o Empresa'");
                tipoCliente = in.nextLine();
            }
        }while (opcion.equalsIgnoreCase("si"));

        return clientes;
    }
    public static ArrayList<Clientes> editarClientes(ArrayList<Clientes> clientes, ArrayList<Producto> productos){
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el tipo de cliente 'Persona o Empresa'");
        String tipoCliente = in.nextLine();
        String opcion;
        String tipo;
        String documento;
        do {
            if (tipoCliente.equalsIgnoreCase("Persona")){
                System.out.println("Ingrese el tipo y número documento del cliente a editar");
                tipo = in.nextLine();
                documento = in.nextLine();
                if (validarExitenciaProduc(productos)){
                    clientes = guardarEdicion(clientes,"persona", tipo, documento, productos);
                }else{
                    break;
                }
            }else if (tipoCliente.equalsIgnoreCase("Empresa")){
                System.out.println("Ingrese el tipo y número documento de la empresa a editar");
                tipo = in.nextLine();
                documento = in.nextLine();
                if (validarExitenciaProduc(productos)){
                    clientes = guardarEdicion(clientes,"empresa", tipo, documento, productos);
                }else{
                    break;
                }
            }
            System.out.println("Desea editar mas clientes 'Si o No'");
            opcion = in.nextLine();
            if (opcion.equalsIgnoreCase("si")){
                System.out.println("Ingrese el tipo de cliente 'Persona o Empresa'");
                tipoCliente = in.nextLine();
            }
        }while (opcion.equalsIgnoreCase("si"));

        return clientes;
    }
    public static ArrayList<Clientes> eliminarClientes(ArrayList<Clientes> clientes){
        Scanner in = new Scanner(System.in);
        String opcion;
        int index;
        do {
            index = buscarIndex(clientes);
            if (index != 0) {
                clientes.remove(index);
                System.out.println("Registro eliminado correctamente");
            }else{
                System.out.println("El cliente no existe");
            }
            System.out.println("Desea eliminar mas clientes 'Si o No'");
            opcion = in.nextLine();
        }while (opcion.equalsIgnoreCase("si"));
        return clientes;
    }
    public static int buscarIndex(ArrayList<Clientes> clientes){
        Scanner in = new Scanner(System.in);
        int index = -1;
        String tipo;
        String documento;
        System.out.println("Ingrese el tipo y número documento del cliente a buscar");
        tipo = in.nextLine();
        documento = in.nextLine();
        for (int i = 0; i < clientes.size(); i++){
            if (clientes.get(i).getTipDoc().equalsIgnoreCase(tipo) && clientes.get(i).getDocumento().equalsIgnoreCase(documento)){
                return i;
            }
        }
    return index;
    }
    public static ArrayList<Clientes> guardarEdicion(ArrayList<Clientes> clientes,String tipoCliente ,String tipoDoc,
                                                     String documento, ArrayList<Producto> productos){
        for (int i = 0; i < clientes.size(); i++){
            if (tipoCliente.equalsIgnoreCase("persona")){
                if (clientes.get(i).getTipDoc().equalsIgnoreCase(tipoDoc) && clientes.get(i).getDocumento().equalsIgnoreCase(documento)){
                    clientes.set(i, personas(productos));
                    System.out.println("Registro realizado correctamente");
                    break;
                }
            }else if (tipoCliente.equalsIgnoreCase("empresa")){
                if (clientes.get(i).getTipDoc().equalsIgnoreCase(tipoDoc) && clientes.get(i).getDocumento().equalsIgnoreCase(documento)){
                    clientes.set(i, empresas(productos));
                    System.out.println("Registro realizado correctamente");
                    break;
                }
            }
        }
        return clientes ;
    }
    public static Boolean validarExitenciaProduc(ArrayList<Producto> productos){
            if (productos.size() < 1){
                System.out.println("Se deben agregar productos para avanzar");
                return false;
            }else{
                for (int i = 0; i < productos.size(); i++){
                    System.out.println(
                            "Id del producto: " + productos.get(i).getIdProducto() +
                            " Nombre del producto: " + productos.get(i).getNombre() +
                            " Carateristica del producto: " + productos.get(i).getCarateristicas() +
                            " Condiciones del producto: " + productos.get(i).getCondiciones()
                    );
                }
                return true;
            }
    }
    public static ArrayList<Producto> agregarProductoClien(ArrayList<Producto> productos){
        Scanner scanner = new Scanner(System.in);
        String opcion;
        ArrayList<Producto> productos1 = new ArrayList<>();
        System.out.println("Ingrese el/los id de productos a agregar al cliente");
        String id = scanner.nextLine();
        do{
            for (Integer i = 0; i < productos.size(); i++){
                if (productos.get(i).getIdProducto().equalsIgnoreCase(id)) {
                    productos1.add(productos.get(i));
                }
            }
            System.out.println("Desea agregar mas productos (Si o No)");
            opcion = scanner.nextLine();
        }while (opcion.equalsIgnoreCase("si"));
        return productos1;
    }
    public static Clientes empresas(ArrayList<Producto> productos){
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
        return new Empresas(nombre,telefono,direccion,tipoDoc,documento,representante, agregarProductoClien(productos));
    }
     public static Clientes personas(ArrayList<Producto> productos){
        Scanner scanner = new Scanner(System.in);
        String opcion;
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
        return new Personas(nombre,telefono,direccion,tipoDoc,documento, agregarProductoClien(productos));
    }
}
