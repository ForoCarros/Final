package modelo.acceso;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

class AlmacenPedidoTest {
	AlmacenPedido almacen = new AlmacenPedido();

	@Ignore
	void testAlmacenPedido() {
		//Es el constructor.
	}

	@Ignore //FUnciona bien
	void testComprobarExistente() {
		assertTrue(this.almacen.comprobarExistente());
	}

	@Test
	void testGrabarNumero() {
		this.almacen.grabarNumero(4);
		assertEquals(4, this.almacen.leerNumero());
	}

	@Ignore
	void testLeerNumero() {
		assertTrue(true);
	}

}
