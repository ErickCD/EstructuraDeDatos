package conversion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class conversionD {

    public static void main(String[] args) {
        Scanner entrada;
        int y;
        do {
            entrada = new Scanner(System.in);
            try {
                long x;
                System.out.println("ingrese un numero: ");
                x = entrada.nextLong();

                long resultado, a, suma = 0;
                String acci = "", numeros = "";
                do {
                    resultado = x % 10;
                    numeros = resultado + ", " + numeros;
                    a = resultado + 48;
                    suma = suma + a;
                    acci = a + ", " + acci;
                    x = (x - resultado) / 10;
                } while (x > 0);
                System.out.println("Los numeros que ingreso son: " + numeros + "\nLos numeros transformados al codigo"
                        + " acii son: " + acci + "\nLa suma de los numeros en codigo acii es: " + suma);
            } catch (InputMismatchException a) {
                System.err.println("Lo lamento deben ser numeros\n");
            }
            entrada = new Scanner(System.in);
            System.out.println("\nDesea hacer otra conversion? Y = 1");
            y = entrada.nextInt();
        } while (y == 1);
    }
}
