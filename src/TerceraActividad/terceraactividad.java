package TerceraActividad;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class terceraactividad {

    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        int c = 0;
        do {
            System.out.println("\nQue operacion desea hacer?\n[1] = Leer el archivo existente.\n[2] = Ingresar mas datos.");
            int ciclo = entrada.nextInt();
            if (ciclo == 1) {
                leer();
            }
            if (ciclo == 2) {
                ini();
            }
            System.out.println("\nDesea hacer otra operacion? Y = 1 N = 0");
            c = entrada.nextInt();
        } while (c == 1);
        System.out.println("\t*****Hasta pronto...*****");
    }

    public static void ini() throws IOException {
        int c = 0;
        do {
            Scanner entrada = new Scanner(System.in);
            try {
                System.out.println("\nIngrese el nombre de la asignatura");
                String asig = entrada.nextLine();
                System.out.println("Cuántos alumnos seran calificados?");
                int x = entrada.nextInt();
                System.out.println("Cuántos parciales");
                int y = entrada.nextInt();
                array(x, y, asig);

            } catch (InputMismatchException a) {
                System.err.println("Ups!!! Donde son números solo números");
            } catch (ArrayIndexOutOfBoundsException b) {
                System.err.println("Ups!!! Si se hace una carrera sin nada, no es nada");
            }
            System.out.println("\nDesea ingresar nuevos datos? Y = 1 N = 0");
            c = entrada.nextInt();
        } while (c == 1);
    }

    public static void leer() throws FileNotFoundException, IOException {
        File archivo = new File("Registro.txt");
        FileReader fr = new FileReader(archivo);
        BufferedReader leer = new BufferedReader(fr);
        while (leer.ready()) {
            String variable = leer.readLine();
            System.out.println(variable);
        }
        fr.close();
    }

    public static void array(int x, int y, String as) throws IOException {
        Scanner entrada;
        int arreglo[][] = new int[x][y];
        float arreglou[] = new float[x];
        String arreglon[] = new String[x];

        for (int i = 0; i < x; i++) {
            entrada = new Scanner(System.in);
            System.out.println("\nIngrese el nombre del alumno: " + (i + 1));
            arreglon[i] = entrada.nextLine();
            System.out.println("\n");
            for (int j = 0; j < y; j++) {
                entrada = new Scanner(System.in);
                System.out.println("Ingrese la calificación del parcial " + (j + 1));
                arreglo[i][j] = entrada.nextInt();
            }
        }
        File archivo = new File("Registro.txt");
        FileWriter fw = new FileWriter(archivo, true);
        BufferedWriter bf = new BufferedWriter(fw);

        for (int i = 0; i < x; i++) {
            float suma = 0;
            for (int j = 0; j < y; j++) {
                int v;
                v = arreglo[i][j];
                suma = suma + v;
            }
            suma = suma / y;
            arreglou[i] = suma;
        }
        System.out.println("\n");
        for (int i = 0; i < arreglou.length; i++) {
            System.out.println("El promedio del alumno: " + arreglon[i] + " es: " + arreglou[i]);
            bf.write("El promedio del alumno: " + arreglon[i] + " es: " + arreglou[i]);
            bf.newLine();
        }
        
        int t = arreglou.length;
        float suma = 0;
        for (int i = 0; i < arreglou.length; i++) {
            float var = arreglou[i];
            suma = suma + var;
        }
        float promedio = suma / t;
        System.out.println("\nEl promedio general del grupo de " + as + " es: " + promedio);
        bf.write("\nEl promedio general del grupo de " + as + " es: " + promedio);
        bf.newLine();
        orden(arreglou, as);
        bf.close();
    }

    public static void orden(float array[], String a) throws IOException {
        File archivo = new File("Registro.txt");
        FileWriter fw = new FileWriter(archivo, true);
        BufferedWriter bf = new BufferedWriter(fw);

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    float tem = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tem;
                }
            }
        }
        int var = array.length - 1;
        System.out.println("\nEl promedio mínimo del grupo de " + a + " es:"
                + array[0] + "\n" + "El promedio máximo del grupo de " + a + " es:" + array[var]);
        bf.write("\nEl promedio mínimo del grupo de " + a + " es:"
                + array[0] + "\n" + "El promedio máximo del grupo de " + a + " es:" + array[var]);
    }
}
