package Ackermann;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author anonymous
 */
public class FuncionDeAckermann {

    private long[] n;
    private long[] m;
    java.util.ArrayList array = new ArrayList();

    public void leer_txt_n(File archivo) {
        n = new long[getSize(archivo)];

        FileReader fr = null;
        try {
            fr = new FileReader(archivo);
            BufferedReader reader = new BufferedReader(fr);
            int i = 0;
            while (reader.ready()) {
                String linea = reader.readLine();
                String arreglo[] = linea.split(" ");
                long a = Long.parseLong(arreglo[1]);
                n[i] = a;
                i++;
            }
        } catch (FileNotFoundException ex) {
            System.err.println("No existe el archivo o fichero\nIngrese la ruta o nombre correctamente");
        } catch (IOException ex) {
            System.err.println("No se puede leer el formato del archivo\n");
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                System.err.println("No se puede cerrar el archivo\n"
                        + "cierre otras aplicaciones que esten usando este archivo");
            }
        }

    }

    public int getSize(File archivo) {
        FileReader fr = null;
        int cont = 1;
        try {
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                br.readLine();
                cont++;
            }
            //return 0;
        } catch (FileNotFoundException ex) {
            System.err.println("No existe el archivo o fichero\nIngrese la ruta o nombre correctamente");
        } catch (IOException ex) {
            System.err.println("No se puede leer el formato del archivo\n");
        } catch (NullPointerException exception) {
            System.err.println("No hay datos\n");
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                System.err.println("No se puede cerrar el archivo\n"
                        + "cierre otras aplicaciones que esten usando este archivo");
            }
        }
        return cont;
    }

    public void leer_txt_m(File archivo) {
        m = new long[getSize(archivo)];
        FileReader fr = null;
        try {
            fr = new FileReader(archivo);
            BufferedReader reader = new BufferedReader(fr);
            int i = 0;
            while (reader.ready()) {
                String linea = reader.readLine();
                String arreglo[] = linea.split(" ");

                long b = Long.parseLong(arreglo[0]);
                m[i] = b;
                i++;
            }
        } catch (FileNotFoundException ex) {
            System.err.println("No existe el archivo o fichero\nIngrese la ruta o nombre correctamente");
        } catch (IOException ex) {
            System.err.println("No se puede leer el formato del archivo\n");
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                System.err.println("No se puede cerrar el archivo\n"
                        + "cierre otras aplicaciones que esten usando este archivo");
            }
        }

    }

    public long Ackermann(long p, long q) {

        if (p == 0) {
            return q + 1;
        }
        if (q == 0) {
            return Ackermann(p - 1, 1);
        }
        return Ackermann(p - 1, Ackermann(p, q - 1));

    }

    public void pritFuncion() {
        System.out.println("*****  FUNCION DE ACKERMANN  ******");
        for (int i = 0; i < n.length; i++) {
            long a = Ackermann(m[i], n[i]);
            System.out.println("Resultado de " + m[i] + ", " + n[i] + " es :" + a);
            array.add(a);
        }

    }

    public void guardarResultados() {
        FileWriter fw = null;
        try {
            File archivo = new File("Resultados de la funcion de ackermann.txt");
            fw = new FileWriter(archivo,true);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.newLine();
            writer.write("*******    FUNCION DE ACKERMANN   *******");
            writer.newLine();
            writer.write("\n***********  Resultados  **************");
            writer.newLine();
            writer.newLine();
            for (int i = 0; i < m.length; i++) {
                writer.write("El resultado de " + m[i] + " y " + n[i] + " es:\t" + array.get(i) + "\n");
                writer.newLine();
            }
            writer.newLine();
            writer.write("*****     Finalizado     *******");
            writer.newLine();
            writer.close();
        } catch (IOException ex) {
            System.err.println("No se puede escribir o crear el archivo\n");
        } finally {

            try {

                fw.close();
            } catch (IOException ex) {
                System.err.println("No se puede leer el formato del archivo\n");
            }
        }
    }

    public static void main(String[] args) {
        try {
            FuncionDeAckermann fda = new FuncionDeAckermann();
            Scanner entrada = new Scanner(System.in);
            System.out.println("Ingrese la ruta o nombre del archivo: ");
            File archivo = new File(entrada.next());
            fda.getSize(archivo);
            fda.leer_txt_n(archivo);
            fda.leer_txt_m(archivo);
            fda.pritFuncion();
            fda.guardarResultados();
        } catch (NullPointerException exception) {
            System.err.println("No hay datos que procesar\n");
        }
    }
}
