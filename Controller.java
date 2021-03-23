import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

    // Utilidades
    private Scanner sc = new Scanner(System.in);
    private Scanner scInt = new Scanner(System.in);

    String src = "./ListadoProducto.txt";
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;

    // Implementación MAP
    private FactoryMap factoryMap = new FactoryMap();
    private IMap<String, List<String>> MAP;

    // Inventario
    private IMap<String, List<String>> inventary;

    /*
     * Lee el archivo y guarda los datos en el inventario
     */
    public void readFile() {
        // Leer el archivo de texto
        try {
            archivo = new File(src);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
        } catch (Exception e) {
            System.out.println("[!] No se encontro el archivo");
        }

        try {
            String linea;
            while ((linea = br.readLine()) != null) {

                String[] products = linea.replace("|", ",").split(",");
                String category = products[0].trim();
                String product = products[1].trim();

                try {

                    // Revisa si existe la categoria, si no existe la creo
                    if (inventary.get(category) != null) {

                        List<String> currentList = inventary.get(category);
                        currentList.add(product);
                        inventary.put(category, currentList);

                    } else {

                        List<String> newList = new ArrayList<String>();
                        newList.add(product);
                        inventary.put(category, newList);
                    }

                } catch (Exception e) {
                    System.out.println("[!] Error al agregar producto al inventario");
                }

            }

        } catch (Exception e) {
            System.out.println("[!] Error al leer el archivo ListadoProductos");
        }
        // Recorre todas las lineas del archivo
    }

    /*
     * Indica el tipo de implementación de MAP que se utilizara
     */
    public void instanceFatory() {
        System.out.println(" :: TIENDA ONLINE ::");

        // Implementar patron de diseño Factory para seleccionar que tipo de MAP
        // utilizara
        System.out.println("Ingrese que MAP implementara: ");
        System.out.println("1. HashMAP");
        System.out.println("2. TreeMAP");
        System.out.println("3. LinkedHashMap");
        Integer optionMAP = scInt.nextInt();

        // Instanciar el tipo de MAP que se utilizara
        MAP = factoryMap.getMap(optionMAP);
        inventary = factoryMap.getMap(optionMAP);

    }

    /*
     * Muestra al usuario las opciónes disponibles  
     */
    public void startProgram() {

        boolean isActive = true;

        while (isActive) {
            System.out.println("\n :: TIENDA ONLINE ::");

            System.out.println("\n 1. Agregar producto a la collecion");
            System.out.println("\n 2. Mostrar categoria un producto");
            System.out.println("\n 3. Mostrar coleccion del usuario");
            System.out.println("\n 5. Mostrar inventario");
            System.out.println("\n 6. Mostrar inventario (Ordenados por tipo)");
            System.out.println("\n 7. Salir");
            Integer option = scInt.nextInt();

            if (option == 1) {

            } else if (option == 2) {

            } else if (option == 3) {

            } else if (option == 4) {

            } else if (option == 5) {

            } else if (option == 6) {

            } else if (option == 7) {

                isActive = false;
                System.out.println("Finalizando programa ...");
                break;
            }

        }

    }

}
