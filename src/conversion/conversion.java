package conversion;

import java.util.Scanner;

public class conversion {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int x;
        System.out.println("ingrese un numero: ");
        x = entrada.nextInt();
        numeros(x);
    }

    public static void numeros(int x) {
        int a = 0, b = 0, c, d, suma;
        if (x > 9 && x < 100) {
            a = x / 10;
            b = x - (a * 10);
        } else {
            System.out.println("Solo se puede con dos números, es temporal.");
        }
        System.out.println("los numeros de son: " + a + " y " + b);
        c = a + 48;
        d = b + 48;
        suma = c + d;
        System.out.println("Los numero en el código acii son: \n" + c + "\n" + d + "\nY la suma de los numeros es:\n" + suma);
    }
}
