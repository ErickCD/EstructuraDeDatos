package actividades;

public class actividad3 {
    public static void main(String[] args) {
        int arreglo[][];
        arreglo = new int[3][4];
        int tt = arreglo.length * arreglo[0].length;
        System.out.println("filas: "+arreglo.length+"\ncolumnas: "+arreglo[0].length+"\ntotal de celdas: "+tt);
    }
}
