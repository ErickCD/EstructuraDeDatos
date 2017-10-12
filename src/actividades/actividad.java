package actividades;

import java.util.Scanner;

public class actividad {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese la cantidada de datos: ");
        int datos = entrada.nextInt();

        int arreglo[] = new int[datos];

        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("Ingrese el el dato de la posición " + (i + 1) + " :");
            arreglo[i] = entrada.nextInt();
        }
        int d = 0;
        do{
        System.out.println("Por cual metodo quiere vereficar el maximo?\n1 = arreglo uno\n2 = arreglo 2");
        int c = entrada.nextInt();
        if (c == 1) {
            arreglo(arreglo);
        }
        if (c == 2) {
            arreglo2(arreglo);
        }
            System.out.println("\nQuiere volver a ver el arreglo? Y = 1 N = 2");
            d = entrada.nextInt();
        }while(d == 1);
    }

    public static void arreglo(int arreglo[]) {
        int max = arreglo[0], min = arreglo[0], posa = 0, posb = 0;
        
        for (int i = 0; i < arreglo.length - 1; i++) {
            if (max < arreglo[i + 1]) {
                max = arreglo[i + 1];
                posa = i+2;
            }if(min > arreglo[i + 1]) {
                min = arreglo[i + 1];
                posb = i+2;
            }
        }
        System.out.printf("\nEl valor maximo es: %d en la posicion: %d\nEl valor "
                + "minimo es: %d en la posicion: %d", max, posa, min, posb);
    }

    public static void arreglo2(int arreglo[]) {
        int max = arreglo.length - 1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < (arreglo.length - 1); j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int tem = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = tem;
                }
            }
        }
        System.out.println("\nEl valor minimo es: " + arreglo[0] + "\nEl valor maximo es: " + arreglo[max]);
    }
}
