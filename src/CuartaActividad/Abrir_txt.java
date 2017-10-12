package CuartaActividad;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
public class Abrir_txt {
    
    public void Abrir_txt() throws FileNotFoundException, IOException{
        
        System.out.printf("%-45s%-45s%-30s\n", "Carrera: ", "Nombre: ", "promedio");
        System.out.println("");
        BufferedReader br = null;
        br = new BufferedReader(new FileReader("datos.txt"));

        String line = br.readLine();
               
            while (br.ready()) {
                String[] datos = line.split(":");               
                System.out.printf("%-45s",datos);
                
                String[] n = datos[0].split(":");
                
                String nombre = n[0];
                
                System.out.printf("%-45s%-30s",datos,nombre);
               
                line = br.readLine();
                
            
        }
        
        br.close();
        System.out.println("\n\nFin del archivo...");
    }
}