package actividades;
import java.util.Scanner;
public class quintaactividad {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int arreglo3d[][][] = new int [2][3][3];
        int arreglon[][][] = new int [2][3][3];
        
        for (int i = 0; i < 2; i++) {
            System.out.println("Profundidad "+(i+1));
            for (int j = 0; j < 3; j++) {
                System.out.println("Renglon "+(j+1));
                for (int k = 0; k < 3; k++) {
                    System.out.println("Columna "+(k+1)+"\nIngrese un numero");
                    arreglo3d[i][j][k] = entrada.nextInt();
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    int var = arreglo3d[i][j][k] %2;
                    if(var == 0){
                        arreglon[1][j][k] = arreglo3d[i][j][k];
                    }else{
                        arreglon[0][j][k] = arreglo3d[i][j][k];
                    }
                }
            }
        }
        System.out.println("\n\n");
        for (int i = 0; i < 2; i++) {
            System.out.println("Profundidad "+(i+1));
            for (int j = 0; j < 3; j++) {
                System.out.println("Renglon "+(j+1));
                for (int k = 0; k < 3; k++) {
                    System.out.println("Columna "+(k+1)+" es: "+arreglon[i][j][k]);
                }
            }
        }
    }
}
