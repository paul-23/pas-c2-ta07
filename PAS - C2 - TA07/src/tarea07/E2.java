package tarea07;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class E2 {

	public static void main(String[] args) {
		
		//Crear un objeto para almacenar los precios de los productos
		ArrayList<Double> listaProductos = new ArrayList<Double>();

		Scanner scanner = new Scanner(System.in);
		double precioProducto;
		
		//Solicitar el precio de los productos y se agregarán a la lista mientras se ingrese un precio mayor a 0.
		do {
			System.out.print("Introduce el precio del producto (0 para finalizar): ");
			precioProducto = scanner.nextDouble();
			if (precioProducto > 0) {
				listaProductos.add(precioProducto);
			}
		} while (precioProducto > 0);

		//Recorremos la lista y sumamos el valor de todos los precios brutos
		double precioTotalBruto = 0;
		for (double precio : listaProductos) {
			precioTotalBruto += precio;
		}
		
		//Mostramos el número de artículos comprados
		System.out.println("------------\nNúmero de artículos comprados: " + listaProductos.size());

		//Indicamos si la compra contiene el iva completo(21%) o reducido(4%)
		int iva;
		System.out.print("------------\n¿IVA reducido? (s/n): ");
		String opcion = scanner.next();
		if (opcion.equalsIgnoreCase("s")) {
			iva = 4;
		} else {
			iva = 21;
		}

		//Mostramos por pantalla el precio bruto de todos los productos, el IVA aplicado y el precio total con IVA
		double precioMasIVA = precioTotalBruto + (iva*100/precioTotalBruto);
		System.out.println("------------\nPrecio total bruto: " + precioTotalBruto);
		System.out.println("IVA aplicado: " + iva + "%");
		System.out.println("Precio total con IVA: " + precioMasIVA);

		//Pedir por pantalla la cantidad que paga el cliente, volver a pedir si es menor que el valor total de la compra
		double cantidadPagada = 0;
		do {
			System.out.print("------------\nIntroduce la cantidad pagada: ");
			cantidadPagada = scanner.nextDouble();
		} while (cantidadPagada  < precioMasIVA);
		
		//Calcular y mostrar el cambio a devolver al cliente
		double cambio = cantidadPagada - precioMasIVA;
		System.out.println("Cambio a devolver: " + cambio + "€");
		scanner.close();
	}

}
