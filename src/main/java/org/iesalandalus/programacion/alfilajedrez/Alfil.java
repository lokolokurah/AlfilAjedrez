package org.iesalandalus.programacion.alfilajedrez;

public class Alfil {

	private Color color;
	private Posicion posicion;
	
	public void setPosicion(Posicion posicion) {
		if (posicion==null) 
		{
			throw new NullPointerException("La posición no es la esperada.");
		} 
		else if (posicion.getFila()<1 || posicion.getFila()>8)
		{
			throw new IllegalArgumentException("ERROR: Fila no válida.");
		} 
		else if (posicion.getColumna()<'a' || posicion.getColumna()>'h') 
		{
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		} 
		else 
		{
			this.posicion=posicion;
		}
	}
	
	public Posicion getPosicion() {
		return posicion;
	}
	
	public void setColor(Color color) {
		if (color==null) 
		{
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		} 
		else if (color!=color.BLANCO && color!=color.NEGRO) 
		{
			throw new IllegalArgumentException("El color no es el esperado.");
		} 
		else 
		{
			this.color=color;
		}
	}
	
	public Color getColor() {
		return color;
	}
	
	
}
