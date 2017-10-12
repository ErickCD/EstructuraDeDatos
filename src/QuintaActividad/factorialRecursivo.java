package QuintaActividad;

import java.util.Scanner;

public class factorialRecursivo {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el numero que quiere factorizar: ");
        int n = entrada.nextInt();
        
        System.out.println("Factorial: " + factorial2(n));
    }
    private static int factorial2(int n){
        if (n == 0) {
            return 1;
        }else{
            return (n * factorial2(n -1));
        }
    }
    
    private static int factorial(int n){
        
        if (n == 0 || n == 1) {
            return 1;
        }
            return n * factorial(n - 1);
        }
    }


