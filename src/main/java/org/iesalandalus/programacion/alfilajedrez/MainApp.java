package org.iesalandalus.programacion.alfilajedrez;

public class MainApp {

	private static Alfil alfil;

	public static void main(String[] args) {
		System.out.println("Programa para aprender a colocar y mover un alfil en el tablero de ajedrez");
		System.out.println("-------------------------------------------------------------------------");
	}

	private static void mostrarAlfil() {
		System.out.println("----------------------------------------------------------");
		System.out.println(" Nueva Modificación:");
		System.out.println(" --------------------------------------");
		System.out.println(" | Alfil:                              |");
		System.out.println(" | "+alfil.toString()+"     |");
		System.out.println(" --------------------------------------");
	}

}