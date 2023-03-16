package tarea07;

import java.util.*;

public class E4 {

	public static void main(String[] args) {
		
		//Creamos un array de stock con el nombre y el precio de productos
		Hashtable<String, Double> stock = new Hashtable<>();
		
		//Damos valor a los objetos de la lista
		stock.put("Leche", 0.80);
		stock.put("Pan", 1.00);
		stock.put("Azúcar", 1.50);
		stock.put("Café", 3.50);
		stock.put("Yogur", 1.20);
		stock.put("Huevos", 2.00);
		stock.put("Queso", 2.50);
		stock.put("Aceite", 3.00);
		stock.put("Arroz", 1.80);
		stock.put("Pasta", 1.50);

		Scanner scanner = new Scanner(System.in);
		boolean salir = false;

		//Creamos un menú para seleccionar la opcion que deseamos, si escogemos 5 salimos
		while (!salir) {
			System.out.print("\n----- Gestion de ventas / Control de stock -----"
					+ "\n1. Añadir nuevo artículo"
					+ "\n2. Consultar precio de un artículo"
					+ "\n3. Listar todo el stock"
					+ "\n4. Finalizar compra"
					+ "\n5. Salir"
					+ "\nElige una opción: ");

			int opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion) {
			//Añadimos un producto a la lista con su numbre y su precio
			case 1:
				System.out.print("Introduce el nombre del nuevo artículo: ");
				String articulo = scanner.nextLine();
				double precio = 0;
				do {
					System.out.print("Introduce el precio del nuevo artículo: ");
					precio = scanner.nextDouble();
				} while (precio < 0);
				stock.put(articulo, precio);
				System.out.println("Artículo añadido correctamente.");
				break;
			//Mostrar el precio del producto pasando el nombre como valor
			case 2:
				System.out.print("Introduce el nombre del artículo: ");
				articulo = scanner.nextLine();
				if (stock.containsKey(articulo)) {
					System.out.println("\nEl precio de " + articulo + " es " + stock.get(articulo) + "€.");
				} else {
					System.out.println("\nEl artículo no existe en el stock.");
				}
				break;
			//Recorrer el array de stock y mostrar el nombre y precio de todos los productos
			case 3:
				System.out.println("\n----- Listado de Stock -----");
				for (Map.Entry<String, Double> entry : stock.entrySet()) {
					System.out.println("- " + entry.getKey() + ": " + entry.getValue() + "€");
				}
				break;
			//Realizar la compra con los articulos que tenemos, aplicando el iva y devolviendo el cambio del cliente
			case 4:
				//Comprobar que hay articulos en la lista, mostrar mensaje en caso contrario
				if (stock.size() == 0) {
					System.out.println("\n - No has comprado nada, no hay ningún artículo en la cesta.");
					break;
				}
				//Sumamos el precio bruto de todos los productos
				double precioTotalBruto = 0;
				Enumeration<Double> sumaStock = stock.elements();
				while (sumaStock.hasMoreElements()) {
					precioTotalBruto += sumaStock.nextElement();
				}
				//Mostrar el número de artículos
				System.out.println("------------\nNúmero de artículos comprados: " + stock.size());
				
				//Indicamos si la compra contiene el iva completo(21%) o reducido(4%)
				int iva;
				System.out.print("------------\n¿IVA reducido? (s/n): ");
				String opcionIVA = scanner.next();
				if (opcionIVA.equalsIgnoreCase("s")) {
					iva = 4;
				} else {
					iva = 21;
				}
				
				//Mostramos por pantalla el precio bruto de todos los productos, el IVA aplicado y el precio total con IVA
				double precioMasIVA = precioTotalBruto + (precioTotalBruto * iva) / 100;
				System.out.println("------------\nPrecio total bruto: " + precioTotalBruto);
				System.out.println("IVA aplicado: " + iva + "%");
				System.out.println("Precio total con IVA: " + precioMasIVA);

				//Pedir por pantalla la cantidad que paga el cliente, volver a pedir si es menor que el valor total de la compra
				double cantidadPagada = 0;
				do {
					System.out.print("------------\nIntroduce la cantidad pagada: ");
					cantidadPagada = scanner.nextDouble();
				} while (cantidadPagada < precioMasIVA);
				
				//Calcular y mostrar el cambio a devolver al cliente
				double cambio = cantidadPagada - precioMasIVA;
				System.out.println("Cambio a devolver: " + cambio + "€");
				salir = true;
				break;
			//Salir del programa y mostrar un mensaje de final	
			case 5:
				System.out.println("\n----- Fin del programa -----");
				salir = true;
				break;
			//Mensaje si introducimos un valor incorrecto en el menu
			default:
				System.out.println("\nOpción no válida.");
				break;
			}
		}
		scanner.close();
	}

}
