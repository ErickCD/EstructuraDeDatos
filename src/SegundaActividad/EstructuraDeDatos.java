package SegundaActividad;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EstructuraDeDatos {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int d = 0;
        do {
            try {
                System.out.println("\nDesea trabajar con números(1) o con letras(2)? ");
                int y = entrada.nextInt();
                System.out.println("\nDe qué tamaño quiere que sea el vector");
                int x = entrada.nextInt();
                if (y == 1) {
                    proceso(x);
                }
                if (y == 2) {
                    proceso2(x);
                }
                if (y != 1 && y != 2) {
                    System.err.println("Lo siento, esa opción es invalida...");
                }
            } catch (InputMismatchException a) {
                System.err.println("Ups!!! en donde son números, solo numeros...");
            }
            System.out.println("\n\nQuiére hacer otro vector? Y = 1 N = 0");
            d = entrada.nextInt();
        } while (d == 1);
        System.out.println("\t*****Hasta Pronto*****");
    }

    public static void proceso(int x) {
        Scanner entrada = new Scanner(System.in);
        int arreglo[] = new int[x];
        int v = 0;

        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("Ingrese el número: " + (i + 1));
            int j = entrada.nextInt();
            arreglo[i] = j;
        }
        do {
            System.out.println("\nQué desea hacer? \n1 = Buscar\n2 = mostrar datos\n3 = Eliminar un datos"
                    + "\n4 = Ingresar un nuevo dato\n5 = Ordenar de menor a mayor\n6 = Ordenar de mayor a menor");
            int c = entrada.nextInt();

            if (c == 1) {
                busqueda(arreglo);
            }
            if (c == 2) {
                mostrar(arreglo);
            }
            if (c == 3) {
                eliminar(arreglo);
            }
            if (c == 4) {
                insertarn(arreglo);
            }
            if (c == 5) {
                orden(arreglo);
            }
            if (c == 6) {
                ordenm(arreglo);
            }
            if (c != 1 && c != 2 && c != 3 && c != 4 && c != 5 && c != 6) {
                System.err.println("Lo siento, esa opción es invaalida...");
            }

            System.out.println("\nQuiéres hacer otra operación? Y = 1 N = 0");
            v = entrada.nextInt();
        } while (v == 1);
    }

    public static void proceso2(int x) {
        String arreglo[] = new String[x];
        Scanner entrada = new Scanner(System.in);

        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("Ingrese una palabra: ");
            String j = entrada.nextLine();
            arreglo[i] = j;
        }
        int v = 0;
        do {
            System.out.println("\nQué desea hacer? \n1 = Buscar\n2 = mostrar datos\n3 = eliminar palabra\n4 = Insertar una nueva palabra\n"
                    + "5 = Ordenas de A-Z\n6 = Ordenar de Z-A");
            int c = entrada.nextInt();

            if (c == 1) {
                busqueda2(arreglo);
            }
            if (c == 2) {
                mostrarp(arreglo);
            }
            if (c == 3) {
                eliminarp(arreglo);
            }
            if (c == 4) {
                insertarp(arreglo);
            }
            if (c == 5) {
                ordencadenas(arreglo);
            }
            if (c == 6) {
                ordencadenasf(arreglo);
            }
            if (c != 1 && c != 2 && c != 3 && c != 4 && c != 5 && c != 6) {
                System.err.println("Lo siento, esa opción es invaalida...");
            }
            System.out.println("\nQuiére hacer otra operación? Y = 1 N = 0");
            v = entrada.nextInt();
        } while (v == 1);
    }

    public static void mostrar(int arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("El número " + (i + 1) + " es: " + arreglo[i]);
        }
    }

    public static void mostrarp(String arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("La palabra " + (i + 1) + " es: " + arreglo[i]);
        }
    }

    public static void busqueda(int arreglo[]) {
        Scanner entrada = new Scanner(System.in);
        int c = 0;
        System.out.println("\nQué número desea Buscar? ");
        int b = entrada.nextInt();
        for (int i = 0; i < arreglo.length; i++) {
            if (b == arreglo[i]) {
                System.out.println("El número " + b + " está en la posición " + (i + 1));
                c = 1;
            }
        }
        if (c == 0) {
            System.err.println("Lo siento el número " + b + " no fue encontrado...");
        }
    }

    public static void busqueda2(String arreglo[]) {
        Scanner entrada = new Scanner(System.in);
        int c = 0;
        System.out.println("\nQué palabra desea Buscar? ");
        String b = entrada.nextLine();

        for (int i = 0; i < arreglo.length; i++) {
            if (b.equals(arreglo[i])) {
                System.out.println("La palabra " + b + " está en la posición " + (i + 1));
                c = 1;
            }
        }
        if (c == 0) {
            System.err.println("Lo siento la palabra " + b + " no fue encontrada...");
        }
    }

    public static void orden(int arreglo[]) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < (arreglo.length - 1); j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int tem = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = tem;
                }
            }
        }
    }

    public static void ordenm(int arreglo[]) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < (arreglo.length - 1); j++) {
                if (arreglo[j] < arreglo[j + 1]) {
                    int tem = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = tem;
                }
            }
        }
    }

    public static void ordencadenas(String arreglo[]) {
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < arreglo.length - 1; i++) {
                int comparison = arreglo[i].compareTo(arreglo[i + 1]);
                if (comparison > 0) {
                    String temp = arreglo[i + 1];
                    arreglo[i + 1] = arreglo[i];
                    arreglo[i] = temp;
                }
            }
        }
    }

    public static void ordencadenasf(String arreglo[]) {
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < arreglo.length - 1; i++) {
                int comparison = arreglo[i].compareTo(arreglo[i + 1]);
                if (comparison < 0) {
                    String temp = arreglo[i + 1];
                    arreglo[i + 1] = arreglo[i];
                    arreglo[i] = temp;
                }
            }
        }
    }

    public static void eliminar(int arreglo[]) {
        Scanner entrada = new Scanner(System.in);
        int t = (arreglo.length - 1), c = 0;
        System.out.println("\nQué número desea eliminar?");
        int x = entrada.nextInt();

        for (int i = 0; i < arreglo.length; i++) {
            if (x == arreglo[i]) {
                for (int j = i; j < t; j++) {
                    arreglo[j] = arreglo[j + 1];
                }
                c = 1;
            }
        }
        if (c == 1) {
            System.out.println("El número " + x + " se ha eliminado exitosamente!!!");
        }
        if (c == 0) {
            System.err.println("Ups!!! el número " + x + " no fue encontrado...");
        }
        arreglo[t] = 0;
    }

    public static void eliminarp(String arreglo[]) {
        Scanner entrada = new Scanner(System.in);
        int t = (arreglo.length - 1), c = 0;
        System.out.println("Qué palabra desea eliminar?");
        String x = entrada.nextLine();

        for (int i = 0; i < arreglo.length; i++) {
            if (x.equals(arreglo[i])) {
                for (int j = i; j < t; j++) {
                    arreglo[j] = arreglo[j + 1];
                }
                c = 1;
            }
        }
        if (c == 1) {
            System.out.println("La palabra " + x + " se ha eliminado exitosamente!!!");
        }
        if (c == 0) {
            System.err.println("Ups!!! la palabra " + x + " no fue encontrada...");
        }
        arreglo[t] = "";
    }

    public static void insertarn(int arreglo[]) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Qué número desea ingresar?");
        int num = entrada.nextInt();
        System.out.println("En qué posición desea ingresarlo? (Las posiciones empiezan desde el 1)");
        int pos = entrada.nextInt();
        int c = pos - 1;
        if (pos <= arreglo.length && pos >= 0) {
            arreglo[c] = num;
            System.out.println("El número " + num + " se ha colocado exitosamente!!!");
        } else {
            System.err.println("Ups!!! Esa posición no existe...");
        }
    }

    public static void insertarp(String arreglo[]) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Qué palabra desea ingresar?");
        String palabra = entrada.nextLine();
        System.out.println("En qué posición desea ingresarla? (Las posiciones empiezan desde el 1)");
        int pos = entrada.nextInt();
        int c = pos - 1;
        if (pos <= arreglo.length && pos >= 0) {
            arreglo[c] = palabra;
            System.out.println("La palabra " + palabra + " se ha colocado exitosamente!!!");
        } else {
            System.err.println("Ups!!! Esa posición no existe...");
        }
    }
}