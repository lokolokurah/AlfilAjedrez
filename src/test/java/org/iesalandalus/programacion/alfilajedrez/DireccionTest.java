package org.iesalandalus.programacion.alfilajedrez;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DireccionTest {
	
	private static final String ERROR_DIRECCION_NO_VALIDA = "ERROR: La dirección no es válida.";

	@Test
	public void nombresValidosDireccionesCreanDireccionesValidas() {
		Direccion direccion;
		direccion = Direccion.ARRIBA_DERECHA;
		assertThat(ERROR_DIRECCION_NO_VALIDA, direccion, is(Direccion.ARRIBA_DERECHA));
		direccion = Direccion.ABAJO_DERECHA;
		assertThat(ERROR_DIRECCION_NO_VALIDA, direccion, is(Direccion.ABAJO_DERECHA));
		direccion = Direccion.ABAJO_IZQUIERDA;
		assertThat(ERROR_DIRECCION_NO_VALIDA, direccion, is(Direccion.ABAJO_IZQUIERDA));
		direccion = Direccion.ARRIBA_IZQUIERDA;
		assertThat(ERROR_DIRECCION_NO_VALIDA, direccion, is(Direccion.ARRIBA_IZQUIERDA));
	}

}
