package actividades;

public class CompararCadenas {
    public static void main(String[] args) {
        String primerapalabra = "Beto", segundapalabra = "Chely";
        
        int comparacion = primerapalabra.compareTo(segundapalabra);
        if (comparacion > 0){
            String temp = segundapalabra;
             segundapalabra = primerapalabra;
             primerapalabra = temp;
        }
        System.out.println("Las palabras ordenadas son: "+ primerapalabra +" y "+ segundapalabra);
    }
}
