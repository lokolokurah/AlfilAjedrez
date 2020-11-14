package org.iesalandalus.programacion.alfilajedrez;

import javax.naming.OperationNotSupportedException;

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
		System.out.println("*----------*");
		System.out.println("|   Menú   |");
		System.out.println("*----------*------------------------------------------------*");
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
	
	private static void crearAlfilDefecto() {
		alfil = new Alfil();
		mostrarAlfil();
	}
	
	private static void crearAlfilColor() {
		Color color;
		color=elegirColor();
		try {
			alfil = new Alfil (color);
		} catch (Exception e) { System.out.println(e.getMessage());
		}
		mostrarAlfil();
	}
	
	private static Color elegirColor() {
		int seleccion;
		Color color=Color.BLANCO;

		do {
			System.out.println("*--------------------*");
			System.out.println("| Selecione un color |");
			System.out.println("|--------------------|");
			System.out.println("| 1- Negro           |");
			System.out.println("| 2- Blanco          |");
			System.out.println("*--------------------*");
			seleccion=Entrada.entero();
		} while (seleccion<1 || seleccion>2);
		switch (seleccion)
		{
		case 1:
			color=Color.NEGRO;
			break;
		case 2:
			color=Color.BLANCO;
			break;                
		}
		return color;
	}

	public static void crearAlfilColorColumna() {
		Color color;
		char columna;
		color= elegirColor();
		columna=elegirColumnaInicial();
		try {
			alfil = new Alfil (color,columna);
		} catch (IllegalArgumentException e) { 
			System.out.println(" ERROR: No se ha creado el alfil. ");
			System.out.println(e.getMessage());       
		}
		mostrarAlfil();
	}
	
	public static char elegirColumnaInicial() {
		char columna;
		do {
			System.out.println("*---------------------------------------------------*");
			System.out.println("| Introduce la columna de partida deseada [c] o [f] |");
			System.out.println("*---------------------------------------------------*");
			System.out.print("Columna de partida: ");
			columna=Entrada.caracter();
		} while (columna !='c' && columna !='f');
		return columna;
	}
	
	private static void mover() throws OperationNotSupportedException {
		int pasos;
		mostrarMenuDirecciones();
		try {
			switch (elegirDireccion()) {
			case 1: 
				System.out.println("¿Cuantas casillas deseas moverte?");
				pasos = Entrada.entero();
				alfil.mover(Direccion.ARRIBA_DERECHA, pasos);
				mover();
				break;
			case 2: 
				System.out.println("¿Cuantas casillas deseas moverte?");
				pasos = Entrada.entero();
				alfil.mover(Direccion.ARRIBA_IZQUIERDA, pasos);
				mover();
				break;
			case 3: 
				System.out.println("¿Cuantas casillas deseas moverte?");
				pasos = Entrada.entero();
				alfil.mover(Direccion.ABAJO_DERECHA, pasos);
				mover();
				break;
			case 4: 
				System.out.println("¿Cuantas casillas deseas moverte?");
				pasos = Entrada.entero();
				alfil.mover(Direccion.ABAJO_IZQUIERDA, pasos);
				mover();
				break;
			}
		} catch (OperationNotSupportedException e) {
			System.out.println("Esta operación no es posible.");
		}
	}
	
	public static void mostrarMenuDirecciones() {
		System.out.println(" *------------------------------------*");
		System.out.println(" | Elige donde deseas mover el alfil |");
		System.out.println(" *-----------------------------------*");
		System.out.println(" | 1. Arriba y Derecha               |");
		System.out.println(" | 2. Arriba e Izquierda             |");
		System.out.println(" | 3. Abajo y Derecha                |");
		System.out.println(" | 4. Abajo e Izquierda              |");
		System.out.println(" | 5. Volver                         |");
		System.out.println(" *-----------------------------------*");
	}     	
	
	private static int elegirDireccion() {
		int direccion;
		do {
			System.out.print(" Elige una opción: ");
			direccion=Entrada.entero();
		}while(direccion<1 || direccion>5);
		return direccion;
	}
	
}