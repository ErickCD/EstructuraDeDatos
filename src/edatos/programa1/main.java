
package programa1;

import java.util.Scanner;

/**
 *
 * @author anonymous
 */
public class main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        arreglo1D arreglo = new arreglo1D();
        boolean bandera = true;

        while (bandera) {
            try {
                System.out.println("\n"
                        + "******* MENU *******"
                        + "\n1.-Insertar datos"
                        + "\n2.-Modificar datos"
                        + "\n3.-Buscar datos"
                        + "\n4.-Eliminar datos"
                        + "\n5.-Ordenar datos"
                        + "\n6.-Imprimir datos"
                        + "\n7.-Salir"
                        + "\n********************\n"
                        + "Escriba su opcion: ");
                int opcion = entrada.nextInt();
                switch (opcion) {
                    case 1:
                        arreglo.cargarArreglos();
                        break;
                    case 2:
                        arreglo.modificarArreglo();
                        break;
                    case 3:
                        arreglo.buscarDatos();
                        break;
                    case 4:
                       arreglo.eliminarDatosArreglo();
                        break;
                    case 5:
                        arreglo.ordenar();
                        break;
                    case 6:
                        arreglo.imprimirDatos();
                        break;
                    case 7:
                        System.out.println("***********************************************");
                        System.out.println("*|     GRACIAS POR UTILIZAR ESTE PROGRAMA    |*");
                        System.out.println("*|      Asignatura: Estructura de Datos      |*");
                        System.out.println("*|    Elaborado por: @Emmanuel_Hernandez :)  |*");
                        System.out.println("***********************************************");
                        System.exit(0);
                      
                    default:
                        System.err.println("Opcion Invalida");
                }

            } catch (NumberFormatException exception) {
                System.err.println("caracter invalido");
            } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                System.err.println("Error en el arreglo");
            } catch (Exception exception) {
                System.err.println("Error al cargar los datos");
                System.err.println("Caracter invalido");
                System.exit(0);

            }
        }

    }

}
