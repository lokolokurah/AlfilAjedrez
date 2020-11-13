package org.iesalandalus.programacion.alfilajedrez;

import java.util.Objects;

public class Posicion {
	
	private int fila;
	private char columna;
	
	public Posicion(int fila, char columna) {
		setFila(fila);
		setColumna(columna);    
	}

	public Posicion(Posicion copiaPosicion)
	{
		if (copiaPosicion == null) 
		{
			throw new NullPointerException("ERROR: No es posible copiar una posición nula.");
		} 
		else 
		{
			setFila(copiaPosicion.getFila());
			setColumna(copiaPosicion.getColumna());
		}
	}
	
	private void setFila(int fila) {
		if (fila>0 && fila<9)
		{
			this.fila=fila;
		}
		else 
		{
			throw new IllegalArgumentException("ERROR: Fila no válida.");
		}
	}
	
	public int getFila() {
		return fila;
	}
	
	private void setColumna(char columna) {
		if (columna == 'a' || columna == 'b' || columna == 'c' || columna == 'd' || columna == 'e' || columna == 'f' || columna == 'g' || columna == 'h')
		{
			this.columna = columna;
		}
		else
		{
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		}  
	}
	
	public char getColumna() {
		return columna;
	}

	@Override
	public int hashCode() {
		return Objects.hash(columna, fila);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Posicion)) {
			return false;
		}
		Posicion other = (Posicion) obj;
		return columna == other.columna && fila == other.fila;
	}
	
}
