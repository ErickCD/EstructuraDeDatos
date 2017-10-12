package CuartaActividad;

import java.io.*;
import java.util.Scanner;

public class cuartaactividad {

    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        Abrir_txt open = new Abrir_txt();
        int v = 0;
        do {
            System.out.println("\nDesea Agregar mas datos o leer el archivo existente"
                    + "\n1 = Abrir archivo\n2 = Insertar mas datos");
            int decicion = entrada.nextInt();

            if (decicion == 1) {
                open.Abrir_txt();
            }
            if (decicion == 2) {
                procesoini();
            }
            
            System.out.println("\nDesea acer otra operacion: Y = 1, N = 0");
            v = entrada.nextInt();
        } while (v == 1);
    }

    public static void procesoini() throws IOException {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese el número de carreras: ");
        int p = entrada.nextInt();
        System.out.print("Ingrese la cantidad de alumnos a calificar: ");
        int m = entrada.nextInt();
        System.out.print("Ingrese el número de parciales a calificar: ");
        int n = entrada.nextInt();
        arreglo(p, n, m);
        System.out.println("\n\t*****Hasta pronto, vuelve pronto...*****");
    }

    public static void arreglo(int p, int n, int m) throws IOException {
        Scanner entrada;
        float arreglo[][][] = new float[p][m][n];
        String nombre[][] = new String[p][m];
        String carrera[] = new String[p];

        for (int i = 0; i < p; i++) {
            entrada = new Scanner(System.in);
            System.out.println("\nIngrese el nombre de la carrera: " + (i + 1));
            String car = entrada.nextLine();
            carrera[i] = car;
            for (int j = 0; j < m; j++) {
                entrada = new Scanner(System.in);
                System.out.println("\nIngrese el nombre completo del alumno: " + (j + 1));
                String nom = entrada.nextLine();
                nombre[i][j] = nom;
                System.out.println("\n");
                for (int k = 0; k < n; k++) {
                    entrada = new Scanner(System.in);
                    System.out.println("Ingrese la cal del parcial: " + (k + 1));
                    float cal = entrada.nextFloat();
                    arreglo[i][j][k] = cal;
                }
            }
        }
        promedio(arreglo, p, m, n, carrera, nombre);
        Guardar(arreglo, nombre, carrera, p, m, n);
    }

    public static void promedio(float arreglo[][][], int p, int m, int n, String carrera[], String nombre[][]) throws IOException {
        Scanner entrada;
        float prom[][] = new float[p][m];

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < m; j++) {
                float suma = 0;
                for (int k = 0; k < n; k++) {
                    float cambio = arreglo[i][j][k];
                    suma = suma + cambio;
                }
                suma = suma / n;
                prom[i][j] = suma;
            }
        }
        float promedioc[] = new float[p];

        for (int i = 0; i < p; i++) {
            float suma = 0, tem;
            for (int j = 0; j < m; j++) {
                tem = prom[i][j];
                suma = suma + tem;
            }
            suma = suma / m;
            promedioc[i] = suma;
        }

        entrada = new Scanner(System.in);
        int c = 0;
        do {
            System.out.println("\n1 = Guardar en txt\nQue desea hacer:\n2 = Ver las Todo\n3 = Ver promedios por alumno\n4 = "
                    + "Promedio por carreras\n5 = Promedio minino y maximo de cada carreras\n6 = promedio minimo y maximo de todas las carreras");
            int opcion = entrada.nextInt();
            if(opcion == 1){
                Guardar(arreglo, nombre, carrera, p, m, n);
            }
            if (opcion == 2) {
                mostrar(prom, arreglo, nombre, carrera, p, m, n, promedioc);
            }
            if (opcion == 3) {
                promedioa(prom, carrera, nombre, p, m);
            }
            if (opcion == 4) {
                promedioc(promedioc, carrera);
            }
            if (opcion == 5) {
                promediomma(prom, carrera, nombre, p, m);
            }
            if (opcion == 6) {
                promediommc(promedioc, carrera);
            }

            System.out.println("\nDesea hacer otra operación: Y = 1 N = 0");
            c = entrada.nextInt();
        } while (c == 1);


    }

    public static void promediommc(float promedioc[], String carrera[]) {
        float max = promedioc[0], min = promedioc[0];
        int posa = 0, posb = 0;
        for (int i = 0; i < promedioc.length - 1; i++) {
            if (max < promedioc[i + 1]) {
                max = promedioc[i + 1];
                posa = i + 1;
            }
            if (min > promedioc[i + 1]) {
                min = promedioc[i + 1];
                posb = i + 1;
            }
        }
        System.out.println("\nLa calificacion minima es: " + min + " de la carrera de: " + carrera[posb]
                + "\nLa calificacion maxima es: " + max + "de la carrera de: " + carrera[posa]);

    }

    public static void promediomma(float prom[][], String carrera[], String nombre[][], int p, int m) {

        float max = prom[0][0], min = prom[0][0];
        int posa = 0, posb = 0;
        if (prom[0].length > 1) {
            for (int j = 0; j < carrera.length; j++) {
                for (int i = 0; i < prom.length - 1; i++) {
                    if (max < prom[j][i + 1]) {
                        max = prom[j][i + 1];
                        posa = i + 1;
                    }
                    if (min > prom[j][i + 1]) {
                        min = prom[j][i + 1];
                        posb = i + 1;
                    }
                }
                System.out.println("\nLa calificacion mínima de la carrera de: " + carrera[j] + " es: " + min + " del alumno: " + nombre[j][posb]
                        + "\nLa calificacion maxima de la carrera de: " + carrera[j] + " es: " + max + " del alumno: " + nombre[j][posa]);
            }
        }
        if (prom[0].length == 1) {
            for (int j = 0; j < carrera.length; j++) {
                for (int i = 0; i < prom.length - 1; i++) {
                    min = prom[0][0];
                    max = prom[0][0];
                }
                System.out.println("\nLa calificacion mínima y maxima de la carrera de: " + carrera[j] + " es: " + min + " del alumno: "
                        + nombre[j][0] + " ya que es el unico alumno");
            }
        }
    }

    public static void promedioa(float prom[][], String carrera[], String nombre[][], int p, int m) {
        System.out.println("\n");
        for (int i = 0; i < p; i++) {
            System.out.println("Carrera de: " + carrera[i]);
            for (int j = 0; j < m; j++) {
                System.out.println("El promedio del alumno: " + nombre[i][j] + " es: " + prom[i][j]);
            }
        }
    }

    public static void promedioc(float promedioc[], String carrera[]) {

        for (int i = 0; i < carrera.length; i++) {
            System.out.println("El promedio de la carrera de " + carrera[i] + " es: " + promedioc[i]);
        }
    }

    public static void Guardar(float arreglo[][][], String nombre[][], String carrera[], int p, int m, int n) throws IOException {
        //aqui se guarda todo el arreglo
        File archivo = new File("datos.txt");
        FileWriter fw = new FileWriter(archivo, true);
        BufferedWriter bf = new BufferedWriter(fw);
        for (int i = 0; i < p; i++) {
            bf.write(carrera[i] + ":"+"t");
            bf.newLine();

            for (int j = 0; j < m; j++) {
                bf.write(nombre[i][j] + ","+"t");
                for (int k = 0; k < n; k++) {
                    bf.write(arreglo[i][j][k] +";"+"t");
                }

            }
            bf.newLine();
        }
        bf.close();
    }

    public static void mostrar(float prom[][], float arreglo[][][], String nombre[][], String carrera[], int p, int m, int n, float promedioc[]) throws IOException {
        System.out.printf("%-45s%-45s%-30s\n", "Carrera: ", "Nombre: ", "promedio");
        System.out.println("");
        BufferedReader br = null;
        br = new BufferedReader(new FileReader("datos.txt"));

        String line = br.readLine();
        
        for (int j = 0; j < 2; j++) {
            while (br.ready()) {
                String[] datos = line.split("carr");               
                System.out.printf("%-45s", datos);
                line = br.readLine();
            }
        }
       
        
        





        //Aqui se imprime la tabla con las calificaciones
//        System.out.printf("%-45s%-45s%-30s\n", "Carrera: ", "Nombre: ", "promedio");
//        System.out.println("");
//        for (int q = 0; q < p; q++) {
//            for (int i = 0; i < m; i++) {
//                System.out.printf("%-45s", carrera[q]);
//                System.out.printf("%-45s", nombre[q][i]);
//                System.out.printf("%-30s", prom[q][i]);
//                System.out.println("");
//            }
//        }
//        //aqui se imprimen promedio maximo
//
//        float max = prom[0][0], min = prom[0][0];
//        int posa = 0, posb = 0;
//
//        if (prom[0].length > 1) {
//            for (int j = 0; j < carrera.length; j++) {
//                for (int i = 0; i < prom.length - 1; i++) {
//                    if (max < prom[j][i + 1]) {
//                        max = prom[j][i + 1];
//                        posa = i + 1;
//                    }
//                    if (min > prom[j][i + 1]) {
//                        min = prom[j][i + 1];
//                        posb = i + 1;
//                    }
//                }
//                System.out.println("\nLa calificacion mínima de la carrera de: " + carrera[j] + " es: " + min + " del alumno: " + nombre[j][posb]
//                        + "\nLa calificacion maxima de la carrera de: " + carrera[j] + " es: " + max + " del alumno: " + nombre[j][posa]);
//            }
//        }
//        if (prom[0].length == 1) {
//            for (int j = 0; j < carrera.length; j++) {
//                for (int i = 0; i < prom.length - 1; i++) {
//                    min = prom[0][0];
//                    max = prom[0][0];
//                }
//                System.out.println("\nLa calificacion mínima y maxima de la carrera de: " + carrera[j] + " es: " + min + " del alumno: " + nombre[j][0]
//                        + " ya que es el unico");
//            }
//        }
//
//
//        for (int i = 0; i < promedioc.length - 1; i++) {
//            if (max < promedioc[i + 1]) {
//                max = promedioc[i + 1];
//                posa = i + 1;
//            }
//            if (min > promedioc[i + 1]) {
//                min = promedioc[i + 1];
//                posb = i + 1;
//            }
//        }
//        System.out.println("\nLa calificacion minima es: " + min + " de la carrera de: " + carrera[posb]
//                + "\nLa calificacion maxima es: " + max + "de la carrera de: " + carrera[posa]);
    }
}
