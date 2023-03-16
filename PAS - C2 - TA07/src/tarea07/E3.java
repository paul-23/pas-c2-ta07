package tarea07;

import java.util.*;

public class E3 {

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
		
		//Creamos un menú para seleccionar la opcion que deseamos, si escogemos 4 salimos
		while (!salir) {
			System.out.print("\n----- Control de Stock -----"
					+ "\n1. Añadir nuevo artículo"
					+ "\n2. Consultar precio de un artículo"
					+ "\n3. Listar todo el stock"
					+ "\n4. Salir"
					+ "\nElige una opción: ");

			int opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion) {
			//Añadimos un producto a la lista con su numbre y su precio
			case 1:
				System.out.print("Introduce el nombre del nuevo artículo: ");
				String articulo = scanner.nextLine();
				System.out.print("Introduce el precio del nuevo artículo: ");
				double precio = scanner.nextDouble();
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
			//Salir del programa y mostrar un mensaje de final
			case 4:
				System.out.println("\n----- Fin del programa -----");
				salir = true;
				break;
			//Mensaje si introducimos un valor incorrecto en el menu
			default:
				System.out.println("\nOpción no válida.");
				break;
			}
		}
	}

}
