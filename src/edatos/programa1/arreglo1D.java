/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa1;

import java.util.Scanner;

/**
 *
 * @author anonymous
 */
public class arreglo1D {

    Scanner entrada = new Scanner(System.in);
    int[] arregloNumeros;
    String[] arregloCaracteres;

    public void cargarArreglos() {
        try {
            System.out.println("1.-Insertar datos en el arreglo de enteros\n2.- Insertar datos en el arreglo de cadenas\nescriba una opcion: ");
            int res = entrada.nextInt();
            if (res == 1) {
                System.out.print("Ingrese la cantidad de datos a ingresar:\t");
                int datos = entrada.nextInt();
                cargarArregloNumeros(datos);
            } else if (res == 2) {
                System.out.print("Ingrese la cantidad de datos a ingresar:\t");
                int datos = entrada.nextInt();
                cargarArregloCaracteres(datos);
            } else {
                System.err.println("opcion invalida");
            }
        } catch (NumberFormatException exception) {
            System.err.println("caracter invalido");
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            System.err.println("Error en el arreglo");
        } catch (Exception exception) {
            System.err.println("Error al cargar los datos");
        }
    }

    public void cargarArregloNumeros(int sizeInt) {
        arregloNumeros = new int[sizeInt];
        int cont = 1;
        for (int i = 0; i < arregloNumeros.length; i++) {
            System.out.println("Ingrese el " + cont + "° numero: ");
            arregloNumeros[i] = entrada.nextInt();
            cont++;
        }
        cont = 1;
        System.out.println("***** Datos del arreglo *******");
        for (int i = 0; i < arregloNumeros.length; i++) {
            System.out.println("Numero " + cont + ":\t" + arregloNumeros[i]);
            cont++;
        }
    }

    public void cargarArregloCaracteres(int sizeString) {
        arregloCaracteres = new String[sizeString];
        int cont = 1;
        for (int i = 0; i < arregloCaracteres.length; i++) {
            System.out.println("Ingrese la " + cont + "° cadena: ");
            arregloCaracteres[i] = entrada.next();
            cont++;
        }
        cont = 1;
        System.out.println("***** Datos del arreglo *******");
        for (int i = 0; i < arregloCaracteres.length; i++) {
            System.out.println("cadena " + cont + ":\t" + arregloCaracteres[i]);
            cont++;
        }
    }

    public void modificarArreglo() {
        try {
            System.out.println("1.-Modificar el arreglo de enteros\n2.-Modificar el arreglo de cadenas\nEscriba una opcion: ");
            int tipoArreglo = entrada.nextInt();
            int cont = 1;
            if (tipoArreglo == 1) {
                for (int i = 0; i < arregloNumeros.length; i++) {
                    System.out.println("Indice " + i + ": " + arregloNumeros[i]);
                }
                System.out.println("");
                System.out.println("Indique el indice a modificar: ");
                int indice = entrada.nextInt();
                int temp = arregloNumeros[indice];
                System.out.println("Ingrese el nuevo numero para el indice " + indice + ":");
                int nuevoNumero = entrada.nextInt();
                arregloNumeros[indice] = nuevoNumero;
                System.out.println("El numero " + temp + " ha sido reemplazado por el numero " + arregloNumeros[indice]);
                System.out.println("\n******* Datos actualizados *****");
                for (int i = 0; i < arregloNumeros.length; i++) {
                    System.out.println("Numero " + cont + ": " + arregloNumeros[i]);
                    cont++;
                }
            } else if (tipoArreglo == 2) {
                for (int i = 0; i < arregloCaracteres.length; i++) {
                    System.out.println("Indice " + i + ": " + arregloCaracteres[i]);
                }
                System.out.println("");
                System.out.println("Indique el indice a modificar: ");
                int indice = entrada.nextInt();
                String temp = arregloCaracteres[indice];
                System.out.println("Ingrese la nueva cadena para el indice " + indice + ":");
                String nombre = entrada.next();
                arregloCaracteres[indice] = nombre;
                System.out.println("El nombre " + temp + " ha sido reemplazado por el nombre " + arregloCaracteres[indice]);
                System.out.println("\n******* Datos actualizados *****");
                for (int i = 0; i < arregloCaracteres.length; i++) {
                    System.out.println("cadena " + cont + ": " + arregloCaracteres[i]);
                    cont++;
                }
                System.out.println("");
            } else {
                System.err.println("Opcion invalida");
            }
            System.out.println("");
            //
        } catch (NumberFormatException exception) {
            System.err.println("caracter invalido");
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            System.err.println("Error en el arreglo");
        } catch (Exception exception) {
            System.err.println("Error al cargar los datos");
        }
        System.out.println("");
    }

    public void buscarDatos() {
        try {
            System.out.println("1.- Buscar numeros\n2.-Buscar caracteres\nEscriba una opcion: \n");
            int opcion = entrada.nextInt();
            if (opcion == 1) {
                System.out.print("Ingrese el numero a buscar:\n");
                int busqueda = entrada.nextInt();
                for (int i = 0; i < arregloNumeros.length; i++) {
                    if (busqueda == arregloNumeros[i]) {
                        System.out.println("El numero " + busqueda + " se encuentra en el indice " + i + " del arreglonumeros\n");
                    }

                }
            } else if (opcion == 2) {
                System.out.print("Escriba la cadena a buscar: \n");
                String busqueda = entrada.next();
                for (int i = 0; i < arregloCaracteres.length; i++) {
                    if (arregloCaracteres[i].equalsIgnoreCase(busqueda)) {
                        System.out.println("La cadena " + busqueda + " se encuentra en el indice " + i + " del arreglo\n");
                    }

                }
            } else {
                System.err.println("Opcion invalida");
            }
        } catch (NumberFormatException exception) {
            System.err.println("Caracter invalido");

        } catch (Exception exception) {
            System.out.println("Error al cargar los datos");
        }
    }

    public void eliminarDatosArreglo() throws Exception {

        System.out.println("Escriba (1) para eliminar datos del arregloNumeros \n(2)Escriba para eliminar datos del arregloCaracteres");
        int opcion = entrada.nextInt();
        int[] arregloTemp;
        String[] arregloStemp;

        if (opcion == 1) {
            System.out.println("\n****** Datos del arreglo ******");
            for (int i = 0; i < arregloNumeros.length; i++) {
                System.out.println("Indice [" + i + "]: " + arregloNumeros[i]);

            }
            System.out.println("Ingrese el indice a eliminar: ");
            int indice = entrada.nextInt();
            arregloTemp = new int[arregloNumeros.length - 1];
            for (int i = 0; i <= arregloTemp.length; i++) {
                if (i < indice) {
                    arregloTemp[i] = arregloNumeros[i];
                } else if (i > indice) {
                    arregloTemp[i - 1] = arregloNumeros[i];
                }

            }
            arregloNumeros = new int[arregloTemp.length];
            arregloNumeros = arregloTemp;

            System.out.println("\n******** Datos actualizados ********");
            for (int i = 0; i < arregloNumeros.length; i++) {
                System.out.println("Indice [" + i + "]: " + arregloNumeros[i]);

            }
        } else if (opcion == 2) {
            System.out.println("\n****** Datos del arreglo ******");
            for (int i = 0; i < arregloCaracteres.length; i++) {
                System.out.println("Indice [" + i + "]: " + arregloCaracteres[i]);

            }
            System.out.println("Ingrese el indice a eliminar: ");
            int indice = entrada.nextInt();
            arregloStemp = new String[arregloCaracteres.length - 1];
            for (int i = 0; i <= arregloStemp.length; i++) {
                if (i < indice) {
                    arregloStemp[i] = arregloCaracteres[i];
                } else if (i > indice) {
                    arregloStemp[i - 1] = arregloCaracteres[i];
                }

            }
            arregloCaracteres = new String[arregloStemp.length];
            arregloCaracteres = arregloStemp;

            System.out.println("\n******** Datos actualizados ********");
            for (int i = 0; i < arregloCaracteres.length; i++) {
                System.out.println("Indice [" + i + "]: " + arregloCaracteres[i]);

            }
        } else {
            System.out.println("Opcion Invalida");
        }
    }

    public void imprimirDatos() {
        System.out.println("1.-Imprimir arreglo de numeros\n2.- Imprimir arreglo de caracteres\nescriba su opcion: ");
        int opcion = entrada.nextInt();
        if (opcion == 1) {
            System.out.println("*******   datos del arreglo de numeros *******");
            for (int i = 0; i < arregloNumeros.length; i++) {
                System.out.println("\tIndice " + i + ":" + arregloNumeros[i]);

            }

        }else if (opcion==2) {
             System.out.println("*******   datos del arreglo de caracteres *******");
            for (int i = 0; i < arregloCaracteres.length; i++) {
                System.out.println("\tIndice " + i + ":" + arregloCaracteres[i]);

            }
        }

    }

    public void ordenar() throws Exception{
        System.out.println("(1) Ordenar datos en el arreglo de Numeros"
                + "\n(2) Ordenar datos en el arreglo de Caracteres");
        int opcion = entrada.nextInt();
        if (opcion == 1) {
            System.out.println("\n***** Datos Ordenados *****");
            java.util.Arrays.sort(arregloNumeros);
            for (int i = 0; i < arregloNumeros.length; i++) {
                System.out.println("ArrayNumeros [" + i + "]" + arregloNumeros[i]);

            }
        }else if (opcion==2) {
            
            java.util.Arrays.sort(arregloCaracteres);
            System.out.println("\n***** Datos Ordenados *****");
            for (int i = 0; i < arregloCaracteres.length; i++) {
               System.out.println("ArregloCaracteres [" + i + "]" + arregloCaracteres[i]);
                
            }
        }else{
            System.err.println("Opcion inválida");
        }

    }
}
