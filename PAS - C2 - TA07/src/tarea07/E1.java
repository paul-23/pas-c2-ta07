package tarea07;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class E1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Crear un objeto Hashtable para almacenar los nombres y las notas de los alumnos
		Hashtable<String, Double> alumnosNotas = new Hashtable<String, Double>();
		int contadorAlumnos = 0;
		
		// Solicitar al usuario el número de alumnos
		System.out.print("Introduce el número de alumnos: ");
		int numeroDeAlumnos = sc.nextInt();
		
		while (numeroDeAlumnos <= 0) {
			System.out.print("Introduce el número de alumnos válido: ");
			numeroDeAlumnos = sc.nextInt();
		}

		while (alumnosNotas.size() < numeroDeAlumnos) {
			++contadorAlumnos;
			introducirCalcularNotas(alumnosNotas, sc, contadorAlumnos);
		}

		// Mostrar la media de notas de todos los alumno
		System.out.println("\n----- MEDIA DE NOTAS DE TODOS LOS ALUMNOS -----");
		mostrarMedia(alumnosNotas);

		sc.close(); // Cerrar el objeto Scanner
	}

	// Definir el método para introducir y calcular las notas de un alumno
	public static void introducirCalcularNotas(Hashtable<String, Double> alumnosNotas, Scanner sc, int contadorAlumnos) {
		
		// Solicitar al usuario el nombre del alumno
		System.out.print("\n---------\nIntroduce el nombre del alumno " + contadorAlumnos + ": ");
		sc.nextLine();
		String nombre = sc.nextLine();
		
		// Solicitar al usuario el número de notas del alumno
		System.out.print("Introduce el número de notas a introducir para el alumno " + nombre + ": ");
		int numeroDeNotas = sc.nextInt();
		while (numeroDeNotas <= 0) {
			System.out.print("Introduce el número de notas por alumno válido: ");
			numeroDeNotas = sc.nextInt();
		}

		// Pedir al usuario que introduzca cada nota del alumno y calcular la media
		System.out.print("Introduce la nota 1 del alumno " + nombre + ": ");
		int nota = 0;
		nota = sc.nextInt();
		double sumaNotas = nota;
		int contador = 1;

		while (contador < numeroDeNotas) {
			++contador;
			System.out.print("Introduce la nota " + contador + " del alumno " + nombre + ": ");
			nota = sc.nextInt();
			sumaNotas = sumaNotas + nota;
		}

		double media = (sumaNotas / numeroDeNotas);
		
		// Mostrar la media de notas del alumno
		System.out.println("\nLa media de notas del alumno " + nombre + " es: " + media);

		// Agregar el nombre y la media de notas del alumno al objeto Hashtable
		alumnosNotas.put(nombre, media);

	}

	//Mostrar los objeto de alumnos y las medias de notas de cada uno
	public static void mostrarMedia(Hashtable<String, Double> alumnosNotas) {
		Enumeration<String> nombre = alumnosNotas.keys();
		Enumeration<Double> media = alumnosNotas.elements();

		while (nombre.hasMoreElements()) {
			System.out.println("Alumno " + nombre.nextElement() + ": " + media.nextElement());
		}
	}

}
