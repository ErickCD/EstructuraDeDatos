package actividades;

public class cuartaactividad {

    public static void main(String[] args) {
        //int a3d[][][] = new int[3][4][2];
        int fila = 3, columna = 4, profundidad = 2;
        
        int a3d[][][] = new int[fila][columna][profundidad];
        
        for (int i = 0; i < profundidad; i++) {
            System.out.println("Grado de profundidad es: "+(profundidad + 1));
            for (int j = 0; j < fila; j++) {
                System.out.println("Estas en la fila: "+(fila + 1));
                for (int k = 0; k < columna; k++) {
                    System.out.println("Estas en la columna: "+(columna + 1));
                }
            }
        }
    }
}
