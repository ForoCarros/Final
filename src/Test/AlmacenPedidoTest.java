package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import modelo.acceso.AlmacenPedido;

class AlmacenPedidoTest {
	AlmacenPedido almacen = new AlmacenPedido();

	@Test //FUnciona bien
	void testComprobarExistente() {
		assertTrue(this.almacen.comprobarExistente());
	}

	@Test
	void testGrabarNumero() {
		this.almacen.grabarNumero(4);
		assertEquals(4, this.almacen.leerNumero());
		this.almacen.grabarNumero(585);
		assertEquals(585, this.almacen.leerNumero());
	}

	@Ignore
	void testLeerNumero() {
		//Ya ha sido probado indirectamente con grabarNumero.
	}
}
