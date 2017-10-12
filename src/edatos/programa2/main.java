package programa2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class main {

	public static void main(String[] args){
		calificaciones calificaciones = new calificaciones();
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese la ruta del archivo a leer (URL): " +
				"\nEl archivo debe cumplir con el formato especificado en el archivo \"README.txt\"" );
		String ruta = entrada.next();
		File archivo = new File(ruta);
		try {
			calificaciones.LeerArchivo(archivo);
			System.out.println("\n****** PROMEDIO DEL GRUPO *******");
			System.out.println("==>   "+calificaciones.promedioGrupal());
			System.out.println("----------------------------------------");
			System.out.println("******  PROMEDIO  MAXIMO  *******");
			System.out.println("==>   "+calificaciones.promMaximo());
			System.out.println("----------------------------------------");
			System.out.println("******  PROMEDIO  MINIMO  *******");
			System.out.println("==>   "+calificaciones.promMinimo());
			System.out.println("----------------------------------------");
			System.out.println("\n" +
					"\n*********************************" +
					"\n*             @autor            *" +
					"\n*  Emmanuel Hernandez Hernandez *" +
					"\n*                               *" +
					"\n*********************************" );
					
		
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
}
