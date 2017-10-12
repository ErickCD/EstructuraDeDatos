package programa3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class calificaciones {
	private String[] nombre;
	private double[] promedio;
	private double[] promedio2;
	private String[] calif;
	private String[] carrera;
	private double pmax;
	private double pmin;
	ArrayList<String> array = new ArrayList<String>();
	HashSet<String> hashSet = new HashSet<String>(array);

	
	public static int obtenerTamanioArchivo(File archivo) throws IOException{
		int cont = 0;
		try {
			FileReader fr = new FileReader(archivo);
			BufferedReader reader = new BufferedReader(fr);
			
			while (reader.ready()) {
				String Linea = reader.readLine();
				cont++;
			}
			reader.close();
		} catch (FileNotFoundException exception) {
			System.err.println("error en el archivo");
		}
		
			return cont;
		
	}
	public void getPromCareer(){
		
	
		double prom=0;
		double suma = 0;
		
		int cont = 1;
		double prome[] = new double[nombre.length];
		for (int i = 0; i < nombre.length; i++) {
			
			for (int j = 0; j < nombre.length; j++) {
				if (carrera[i].equalsIgnoreCase(carrera[j])) {
					
					suma = suma + promedio2[j];
					prom = suma /cont;
				    cont++;
				    
				}
				prome[i]=prom;
				
			}
			//System.out.println("["+carrera[i]+"]"+prom);
			array.add(carrera[i]+": "+prom);
			
			
			//System.out.println("["+carrera[i]+"]"+prom);
			prom = 0;
			suma = 0;
			cont = 1;
			
			
		}
		//array.clear();
		array.addAll(hashSet);
		
		Arrays.sort(prome);
		pmax = prome[prome.length-1];
		pmin = prome[0];
		System.out.println("Promedio maximo de las carreras: "+prome[prome.length-1]);
		System.out.println("Promedio Minimo De Las Carreras: "+ prome[0]);
	}
	public void LeerArchivo(File archivo) throws IOException {
		
		try {
			FileReader fr = new FileReader(archivo);
			BufferedReader reader = new BufferedReader(fr);
			
			
			
			
			nombre = new String[obtenerTamanioArchivo(archivo)];
			int i =0;
			 promedio= new double[obtenerTamanioArchivo(archivo)];
			 promedio2= new double[obtenerTamanioArchivo(archivo)];
			 calif=new String[obtenerTamanioArchivo(archivo)];
			 carrera = new String[obtenerTamanioArchivo(archivo)];
			while (reader.ready()) {
				String Linea = reader.readLine();
				String[] arreglo = Linea.split(":");				
				nombre[i]=arreglo[0].toString();	
				 calif[i] = arreglo[1];
				 String cl = arreglo[1];
				 carrera[i] = arreglo[2];
				 String[] arrayEnteros = cl.split(",");		
				 String a ="";
				 double prom =0;
				 double total =0;
				 for (int j = 0; j < arrayEnteros.length; j++) {
					a = arrayEnteros[j];
					int b = Integer.parseInt(a);
					
					total = total + b;
					
					
				}
				 prom = total/arrayEnteros.length;
				 promedio[i]=prom;
				 promedio2[i]=prom;
				 
				i++;
				
			
			}
			System.out.println("");
			reader.close();
			System.out.printf("%-50s%-45s%-30s%-30s\n","Nombre: ","Calificaciones: ","Promedio: ","carrera: ");
			System.out.println("");
			for (int j = 0; j < nombre.length; j++) {
				System.out.printf("%-45s ",nombre[j]);
				System.out.printf("%-30s",calif[j]);
				System.out.printf("%25s ",promedio[j]);
				System.out.printf("%30s\n",carrera[j]);
				
					
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public double  promedioGrupal(){
		double suma = 0.0;
		double promTotal =0.0;
		for (int i = 0; i < promedio.length; i++) {
			suma = suma + promedio[i];
			promTotal= suma/promedio.length;
		}
		return promTotal;
	}
	public double promMaximo(){
		
	Arrays.sort(promedio);
				
		return promedio[promedio.length-1];
	}
	public double promMinimo(){
		Arrays.sort(promedio);
		return promedio[0];
	}
	public void print(){
		for (int i = 0; i <nombre.length; i++) {
			System.out.println("["+carrera[i]+"]"+promedio2[i]);
		}
	}
	public void guardarRegistro(){
		File archivo = new File("informe.txt");
		try {
			FileWriter fileWriter = new FileWriter(archivo);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			writer.write("***************  INFORME DE REGISTRO   *************\n");
			writer.newLine();
			for (int i = 0; i < nombre.length; i++) {
				writer.write(nombre[i]+":       "+calif[i]+"      "+carrera[i]+"    "+promedio2[i]);
				writer.newLine();
			}
			writer.write("***********************************\n");
			writer.write("Promedio Maximo: "+promMaximo());
			writer.newLine();
			writer.write("***********************************\n");
			writer.write("Promedio Minimo: "+promMinimo());
			writer.newLine();
			writer.write("***********************************\n");
			writer.write("***** Promedio Maximo y MInimo de las carreras *********\n");
			writer.write("Promedio Maximo: "+pmax+"\n");
			writer.write("Promedio Minimo: "+pmin+"\n");
			writer.write("***********    INFORME   COMPLETADO    **********\n");
			writer.write("              **         \n");
			writer.write("           *      *      \n");
			writer.write("          *   * *  *     \n");
			writer.write("          *   -_-  *\n");
			writer.write("           *      *\n");
			writer.write("             ****\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
