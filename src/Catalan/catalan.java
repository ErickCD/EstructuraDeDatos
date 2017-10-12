package Catalan;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class catalan {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        ArrayList<String> lista = new ArrayList<String>();
        try {
            Scanner archivo = new Scanner(new File("catalan.txt"));
            while (archivo.hasNext()) {
                lista.add(archivo.nextLine());
            }
            archivo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String items[] = lista.toArray(new String[lista.size()]);
        File archivo = new File("Resultado de catalan.txt");
        FileWriter fileWriter = new FileWriter(archivo, true);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        writer.newLine();
        writer.write("*****Parametros de salida de Catalan*****");

        writer.newLine();
        writer.newLine();
        writer.newLine();

        int[] entero = new int[items.length];

        for (int i = 0; i < items.length; i++) {
            entero[i] = Integer.parseInt(items[i]);
        }

        for (int i = 0; i < entero.length; i++) {
            int a = 2*(entero[i]);
            int b = 1 + entero[i];
            int c = entero[i];

            int resultado = factorial(a) / (factorial(b)*factorial(c));
            writer.write("El numero de catalan de: "+c+" es: "+resultado);
            writer.newLine();
        }
        writer.close();

    }

    public static int factorial(int entero){
        int resultado = 1;

        for (int j = entero; j > 1; j--) {
            resultado = resultado * j;
        }
        return resultado;
    }
}