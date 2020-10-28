package org.iesalandalus.programacion.alfilajedrez;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.fail;

import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import org.junit.BeforeClass;

public class AlfilTest {
	
	private static final String COLOR_NO_NULO = "Debería haber saltado una excepción indicando que el color no puede ser nulo.";
	private static final String DIRECCION_NO_NULA = "Debería haber saltado una excepción indicando que no se puede mover en una dirección nula.";
	private static final String PASOS_NO_POSTIVOS = "Debería haber saltado una excepción indicando que no se puede mover pasos no positivos.";
	private static final String CADENA_NO_ESPERADA = "La cadena devuelta no es la esperada.";
	private static final String COLOR_NO_ESPERADO = "El color no es el esperado.";
	private static final String POSICION_NO_ESPERADA = "La posición no es la esperada.";
	private static final String OBJETO_DEBERIA_SER_NULL = "No se debería haber creado el objeto alfil.";
	private static final String ERROR_COLOR_NULO = "ERROR: No se puede asignar un color nulo.";
	private static final String ERROR_MOVIMIENTO_NO_VALIDO = "ERROR: Movimiento no válido (se sale del tablero).";
	private static final String ERROR_DIRECCION_NULA = "ERROR: La dirección no puede ser nula.";
	private static final String ERROR_PASOS_NO_POSITIVOS = "ERROR: El número de pasos debe ser positivo.";
	private static final String ERROR_COLUMNA_NO_VALIDA = "ERROR: Columna no válida.";
	private static final String EXCEPCION_MENSAJE_ADECUADO = "Debería haber saltado una excepción con el mensaje adecuado.";
	private static final String EXCEPCION_MOVIMIENTO_NO_VALIDO = "Debería haber saltado una excepción indicando que el movimiento no es válido.";
	private static final String NO_EXCEPCION_MOVIMIENTO_VALIDO = "No debería saltar ninguna excepción ya que los movimientos son válidos.";
	private static final String NO_EXCEPCION = "No debería haber saltado este tipo de excepción.";
	
	private static Posicion posicionDefectoNegro;
	private static Posicion posicionDefectoBlanco;
	
	@BeforeClass
	public static void asignarValoresAtributos() {
		posicionDefectoNegro = new Posicion(8, 'f');
		posicionDefectoBlanco = new Posicion(1, 'f');
	}

	@Test
	public void constructorDefectoCreaAlfilNegroEnPosicion8f() {
		Alfil alfil = new Alfil();
		assertThat(COLOR_NO_ESPERADO, alfil.getColor(), is(Color.NEGRO));
		assertThat(POSICION_NO_ESPERADA, alfil.getPosicion(), is(posicionDefectoNegro));
	}
	
	@Test
	public void constructorColorBlancoCreaAlfilBlancoEnPosicion1f() {
		Alfil alfilBlanco = new Alfil(Color.BLANCO);
		assertThat(COLOR_NO_ESPERADO, alfilBlanco.getColor(), is(Color.BLANCO));
		assertThat(POSICION_NO_ESPERADA, alfilBlanco.getPosicion(), is(posicionDefectoBlanco));
	}
	
	@Test
	public void constructorColorNegroCreaAlfilNegroEnPosicion8f() {
		Alfil alfilNegro = new Alfil(Color.NEGRO);
		assertThat(COLOR_NO_ESPERADO, alfilNegro.getColor(), is(Color.NEGRO));
		assertThat(POSICION_NO_ESPERADA, alfilNegro.getPosicion(), is(posicionDefectoNegro));
	}
		
	@Test
	public void constructorColorNuloLanzaExcepcion() {
		Alfil alfil = null;
		try {
			alfil = new Alfil(null);
			fail(COLOR_NO_NULO);
		} catch (NullPointerException e) {
			assertThat(EXCEPCION_MENSAJE_ADECUADO, e.getMessage(), is(ERROR_COLOR_NULO));
			assertThat(OBJETO_DEBERIA_SER_NULL, alfil, is(nullValue()));
		}
	}
	
	@Test
	public void constructorColorValidoColumnaValidaCreaAlfilCorrectamente() {
		Alfil alfilBlanco = new Alfil(Color.BLANCO, 'c');
		assertThat(COLOR_NO_ESPERADO, alfilBlanco.getColor(), is(Color.BLANCO));
		assertThat(POSICION_NO_ESPERADA, alfilBlanco.getPosicion(), is(new Posicion(1, 'c')));
		alfilBlanco = new Alfil(Color.BLANCO, 'f');
		assertThat(COLOR_NO_ESPERADO, alfilBlanco.getColor(), is(Color.BLANCO));
		assertThat(POSICION_NO_ESPERADA, alfilBlanco.getPosicion(), is(new Posicion(1, 'f')));
		Alfil alfilNegro = new Alfil(Color.NEGRO, 'c');
		assertThat(COLOR_NO_ESPERADO, alfilNegro.getColor(), is(Color.NEGRO));
		assertThat(POSICION_NO_ESPERADA, alfilNegro.getPosicion(), is(new Posicion(8, 'c')));
		alfilNegro = new Alfil(Color.NEGRO, 'f');
		assertThat(COLOR_NO_ESPERADO, alfilNegro.getColor(), is(Color.NEGRO));
		assertThat(POSICION_NO_ESPERADA, alfilNegro.getPosicion(), is(new Posicion(8, 'f')));
	}
	
	@Test
	public void constructorColorNuloColumnaValidaLanzaExcepcion() {
		Alfil alfil = null;
		try {
			alfil = new Alfil(null, 'g');
			fail(EXCEPCION_MENSAJE_ADECUADO);
		} catch (NullPointerException e) {
			assertThat(COLOR_NO_NULO, e.getMessage(), is(ERROR_COLOR_NULO));
			assertThat(OBJETO_DEBERIA_SER_NULL, alfil, is(nullValue()));
		}
	}
	
	@Test
	public void constructorColorValidoColumnaNoValidaLanzaExcepcion() {
		Alfil alfilColumnaNoValida = null;
		try {
			alfilColumnaNoValida = new Alfil(Color.BLANCO, '`');
			fail(EXCEPCION_MENSAJE_ADECUADO);
		} catch (IllegalArgumentException e) {
			assertThat(EXCEPCION_MENSAJE_ADECUADO, e.getMessage(), is(ERROR_COLUMNA_NO_VALIDA));
			assertThat(OBJETO_DEBERIA_SER_NULL, alfilColumnaNoValida, is(nullValue()));
		}
		try {
			alfilColumnaNoValida = new Alfil(Color.BLANCO, 'i');
			fail(EXCEPCION_MENSAJE_ADECUADO);
		} catch (IllegalArgumentException e) {
			assertThat(EXCEPCION_MENSAJE_ADECUADO, e.getMessage(), is(ERROR_COLUMNA_NO_VALIDA));
			assertThat(OBJETO_DEBERIA_SER_NULL, alfilColumnaNoValida, is(nullValue()));
		}
		try {
			alfilColumnaNoValida = new Alfil(Color.NEGRO, '`');
			fail(EXCEPCION_MENSAJE_ADECUADO);
		} catch (IllegalArgumentException e) {
			assertThat(EXCEPCION_MENSAJE_ADECUADO, e.getMessage(), is(ERROR_COLUMNA_NO_VALIDA));
			assertThat(OBJETO_DEBERIA_SER_NULL, alfilColumnaNoValida, is(nullValue()));
		}
		try {
			alfilColumnaNoValida = new Alfil(Color.NEGRO, 'i');
			fail(EXCEPCION_MENSAJE_ADECUADO);
		} catch (IllegalArgumentException e) {
			assertThat(EXCEPCION_MENSAJE_ADECUADO, e.getMessage(), is(ERROR_COLUMNA_NO_VALIDA));
			assertThat(OBJETO_DEBERIA_SER_NULL, alfilColumnaNoValida, is(nullValue()));
		}
	}
	
	@Test
	public void moverDireccionValidaPasosValidosCambiaPosicionCorrectamente() {
		Alfil alfilBlanco = new Alfil(Color.BLANCO);
		Alfil alfilNegro = new Alfil(Color.NEGRO);
		try {
			alfilBlanco.mover(Direccion.ARRIBA_DERECHA, 2);
			assertThat(POSICION_NO_ESPERADA, alfilBlanco.getPosicion(), is(new Posicion(3, 'h')));
			alfilBlanco.mover(Direccion.ARRIBA_IZQUIERDA, 5);
			assertThat(POSICION_NO_ESPERADA, alfilBlanco.getPosicion(), is(new Posicion(8, 'c')));
			alfilBlanco.mover(Direccion.ABAJO_IZQUIERDA, 2);
			assertThat(POSICION_NO_ESPERADA, alfilBlanco.getPosicion(), is(new Posicion(6, 'a')));
			alfilBlanco.mover(Direccion.ABAJO_DERECHA, 5);
			assertThat(POSICION_NO_ESPERADA, alfilBlanco.getPosicion(), is(new Posicion(1, 'f')));
			alfilNegro.mover(Direccion.ABAJO_DERECHA, 2);
			assertThat(POSICION_NO_ESPERADA, alfilNegro.getPosicion(), is(new Posicion(6, 'h')));
			alfilNegro.mover(Direccion.ABAJO_IZQUIERDA, 5);
			assertThat(POSICION_NO_ESPERADA, alfilNegro.getPosicion(), is(new Posicion(1, 'c')));
			alfilNegro.mover(Direccion.ARRIBA_IZQUIERDA, 2);
			assertThat(POSICION_NO_ESPERADA, alfilNegro.getPosicion(), is(new Posicion(3, 'a')));
			alfilNegro.mover(Direccion.ARRIBA_DERECHA, 5);
			assertThat(POSICION_NO_ESPERADA, alfilNegro.getPosicion(), is(new Posicion(8, 'f')));
		} catch (OperationNotSupportedException e) {
			fail(NO_EXCEPCION_MOVIMIENTO_VALIDO);
		}
	}
	
	@Test
	public void moverDireccionNulaPasosValidosLanzaExcepcionYNoMueveAlfil() {
		Alfil alfil = new Alfil();
		try {
			alfil.mover(null, 1);
			fail(EXCEPCION_MOVIMIENTO_NO_VALIDO);
		} catch (NullPointerException e) {
			assertThat(DIRECCION_NO_NULA, e.getMessage(), is(ERROR_DIRECCION_NULA));
			assertThat(POSICION_NO_ESPERADA, alfil.getPosicion(), is(posicionDefectoNegro));
		} catch (OperationNotSupportedException e) {
			fail(NO_EXCEPCION);
		}
	}
	@Test
	public void moverDireccionValidaPasosNoValidosLanzaExcepcionYNoMueveAlfil() {
		Alfil alfil = new Alfil();
		try {
			alfil.mover(Direccion.ARRIBA_DERECHA, 0);
			fail(EXCEPCION_MOVIMIENTO_NO_VALIDO);
		} catch (IllegalArgumentException e) {
			assertThat(PASOS_NO_POSTIVOS, e.getMessage(), is(ERROR_PASOS_NO_POSITIVOS));
			assertThat(POSICION_NO_ESPERADA, alfil.getPosicion(), is(posicionDefectoNegro));
		} catch (OperationNotSupportedException e) {
			fail(NO_EXCEPCION);
		}
		try {
			alfil.mover(Direccion.ARRIBA_DERECHA, -1);
			fail(EXCEPCION_MOVIMIENTO_NO_VALIDO);
		} catch (IllegalArgumentException e) {
			assertThat(PASOS_NO_POSTIVOS, e.getMessage(), is(ERROR_PASOS_NO_POSITIVOS));
			assertThat(POSICION_NO_ESPERADA, alfil.getPosicion(), is(posicionDefectoNegro));
		} catch (OperationNotSupportedException e) {
			fail(NO_EXCEPCION);
		}
	}
	
	@Test
	public void moverMovimientoNoValidoLanzaExcepcionYNoMueveAlfil() {
		Alfil alfil = new Alfil();
		try {
			alfil.mover(Direccion.ARRIBA_DERECHA, 3);
			fail(EXCEPCION_MOVIMIENTO_NO_VALIDO);
		} catch (OperationNotSupportedException e) {
			assertThat(EXCEPCION_MENSAJE_ADECUADO, e.getMessage(), is(ERROR_MOVIMIENTO_NO_VALIDO));
			assertThat(POSICION_NO_ESPERADA, alfil.getPosicion(), is(posicionDefectoNegro));
		}
	}
	
	@Test
	public void toStringTest() {
		Alfil Alfil = new Alfil();
		assertThat(CADENA_NO_ESPERADA, Alfil.toString(), is("fila=8, columna=f, color=NEGRO"));
	}

}
