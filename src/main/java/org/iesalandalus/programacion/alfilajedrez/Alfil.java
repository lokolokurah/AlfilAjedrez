package org.iesalandalus.programacion.alfilajedrez;

import javax.naming.OperationNotSupportedException;

public class Alfil {

	private Color color;
	private Posicion posicion;

	public Alfil() {
		setColor(Color.NEGRO);
		setPosicion(new Posicion(8, 'f'));
	}

	public Alfil(Color color) {
		setColor(color);
		switch(color)
		{
		case BLANCO:
			setPosicion(new Posicion(1,'f'));
			setColor(color.BLANCO);
			break;
		case NEGRO:
			setPosicion(new Posicion(8,'f'));
			setColor(color.NEGRO);
			break;
		}
	}

	public Alfil(Color color, char columnaInicial) {
		setColor(color);	
		if (color==Color.BLANCO)
		{
			setPosicion(new Posicion(1, columnaInicial));
			setColor(color.BLANCO);
		}
		if (color==Color.NEGRO) 
		{
			setPosicion(new Posicion(8, columnaInicial));
			setColor(color.NEGRO);
		}
	}

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

	public void mover(Direccion direccion, int cantidadDePasos) throws OperationNotSupportedException { 
		if (direccion == null) 
		{
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		}
		if (cantidadDePasos<=0)
		{
			throw new IllegalArgumentException("ERROR: El número de pasos debe ser positivo.");
		}
		switch (direccion) {
		case ARRIBA_DERECHA:
			try 
			{
				if (direccion == Direccion.ARRIBA_DERECHA) 
				{
					setPosicion(new Posicion(posicion.getFila()+cantidadDePasos,
							(char) (posicion.getColumna()+cantidadDePasos)));
				} 			
			}catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
			}
			break;	
		case ABAJO_DERECHA:
			try 
			{
				if (direccion == Direccion.ABAJO_DERECHA) 
				{
					setPosicion(new Posicion(posicion.getFila()-cantidadDePasos,
							(char) (posicion.getColumna()+cantidadDePasos)));
				} 			
			}catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
			}
			break;	
		case ABAJO_IZQUIERDA:
			try 
			{
				if (direccion == Direccion.ABAJO_IZQUIERDA) 
				{
					setPosicion(new Posicion(posicion.getFila()-cantidadDePasos,
							(char) (posicion.getColumna()-cantidadDePasos)));
				} 			
			}catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
			}
			break;	
		case ARRIBA_IZQUIERDA:
			try 
			{
				if (direccion == Direccion.ARRIBA_IZQUIERDA) 
				{
					setPosicion(new Posicion(posicion.getFila()+cantidadDePasos,
							(char) (posicion.getColumna()-cantidadDePasos)));
				} 			
			}catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
			}
			break;	
		}
	}

}
