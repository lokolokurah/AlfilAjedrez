package org.iesalandalus.programacion.alfilajedrez;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

	private static Alfil alfil;

	public static void main(String[] args) {
		System.out.println("Programa para aprender a colocar y mover un alfil en el tablero de ajedrez");
		System.out.println("-------------------------------------------------------------------------");
		mostrarMenu();
	}

	private static void mostrarAlfil() {
		System.out.println("*--------------------");
		System.out.println("| Nueva Modificación |");
		System.out.println("*--------------------------------------");
		System.out.println("| Alfil:                              |");
		System.out.println("| "+alfil.toString()+"     			  |");
		System.out.println("*-------------------------------------*");
	}

	private static void mostrarMenu() {     
		System.out.println("*---------*");
		System.out.println("|  Menú:  |");
		System.out.println("*---------*------------------------------------------------*");
		System.out.println("| 1- Crear alfil por defecto                               |");
		System.out.println("| 2- Crear alfil de un color ( blanco o negro)             |");
		System.out.println("| 3- Crear alfil de un color en una columna inicial válida |");
		System.out.println("| 4- Mover alfil                                           |");
		System.out.println("| 5- Salir                                                 |");
		System.out.println("*----------------------------------------------------------*");
	}

	private static int elegirOpcion() {
		int opcion;
		do {
			System.out.print(" Elige una opción: ");
			opcion= Entrada.entero();
		} while (opcion<0 || opcion>5);
		return opcion;
	}

}