package programa2;

import java.io.*;
import java.util.Arrays;
/*
 * Materia: Estructura de Datos
 * Equipo: I
 * Nombre: Emmanuel Hernandez Hernandez
 * Fecha: 30/09/2014
 * Laboratorio No: LAB01
 * Titulo: Practica 2
 * Grupo: S31
 * Descripcion: calcular el promedio por estudiante,promedio grupal, 
 * promedio maximo y minimo
 * 
 * */
public class calificaciones {
	private String[] nombre;
	private double[] promedio;
	private String[] calif;
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

	public void LeerArchivo(File archivo) throws IOException {
		
		try {
			FileReader fr = new FileReader(archivo);
			BufferedReader reader = new BufferedReader(fr);
			
			
			
			
			nombre = new String[obtenerTamanioArchivo(archivo)];
			int i =0;
			 promedio= new double[obtenerTamanioArchivo(archivo)];
			 calif=new String[obtenerTamanioArchivo(archivo)];
			while (reader.ready()) {
				String Linea = reader.readLine();
				String[] arreglo = Linea.split(":");
				//System.out.println(Linea);
				
				nombre[i]=arreglo[0].toString();
				
				 calif[i] = arreglo[1];
				 String cl = arreglo[1];
				 
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
				i++;
				
			
			}
			System.out.println("");
			reader.close();
			System.out.printf("%-50s%-45s%-30s\n","Nombre: ","Calificaciones: ","Promedio: ");
			System.out.println("");
			for (int j = 0; j < nombre.length; j++) {
				System.out.printf("%-45s ",nombre[j]);
				System.out.printf("%-30s",calif[j]);
				System.out.printf("%25s\n ",promedio[j]);
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
		
	}
	public void guardarRegistro(){
		File archivo = new File("registro.txt");
		try {
			FileWriter fileWriter = new FileWriter(archivo);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			for (int i = 0; i < nombre.length; i++) {
				writer.write(nombre[i]+calif[i]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
