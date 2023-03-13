package tarea07;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class E1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Hashtable<String, Double> alumnosNotas = new Hashtable<String, Double>();
		int contadorAlumnos = 0;
		
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

		System.out.println("\n----- MEDIA DE NOTAS DE TODOS LOS ALUMNOS -----");
		mostrarMedia(alumnosNotas);

		sc.close();
	}

	public static void introducirCalcularNotas(Hashtable<String, Double> alumnosNotas, Scanner sc, int contadorAlumnos) {
		
		System.out.print("\n---------\nIntroduce el nombre del alumno " + contadorAlumnos + ": ");
		sc.nextLine();
		String nombre = sc.nextLine();
		
		System.out.print("Introduce el número de notas a introducir para el alumno " + nombre + ": ");
		int numeroDeNotas = sc.nextInt();
		while (numeroDeNotas <= 0) {
			System.out.print("Introduce el número de notas por alumno válido: ");
			numeroDeNotas = sc.nextInt();
		}

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
		
		System.out.println("\nLa media de notas del alumno " + nombre + " es: " + media);

		alumnosNotas.put(nombre, media);

	}

	public static void mostrarMedia(Hashtable<String, Double> alumnosNotas) {
		Enumeration<String> nombre = alumnosNotas.keys();
		Enumeration<Double> media = alumnosNotas.elements();

		while (nombre.hasMoreElements()) {
			System.out.println("Alumno " + nombre.nextElement() + ": " + media.nextElement());
		}
	}

}
