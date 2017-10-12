package Euclides;

import java.util.Scanner;

public class euclides {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int a, b, ciclo = 0;
        do {
            System.out.println("Ingrese el numero 1");
            a = entrada.nextInt();
            System.out.println("Ingrese el numero 2");
            b = entrada.nextInt();

            if (a > b) {
                proceso(a, b);
            } else {
                proceso(b, a);
            }
            System.out.println("Desea hacer otra operación? Y = 1, N = 0");
            ciclo = entrada.nextInt();
        } while (ciclo == 1);
    }

    public static void proceso(int a, int b) {
        int variable = 1, cambiante;
        do {
            cambiante = a / b;
            variable = a - (b * cambiante);
            if (variable != 0) {
                if (variable < b) {
                    a = b;
                    b = variable;
                } else {
                    a = variable;
                }
            }

        } while (variable == 0);
        System.out.println("\nEl máximo común divor es: " + b);
    }
}
