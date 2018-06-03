package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import java.util.TreeMap;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import logica.Logica;
import modelo.acceso.AlmacenArticulo;
import modelo.data.Articulo;
import modelo.data.Cliente;

class LogicaTest {
	
	Logica instancia = new Logica();

	@Test
	void testCrearCliente() {
		Cliente cliente = new Cliente("12345678U", "prueba", "calle falsa123", "000000000");
		assertTrue(instancia.crear(cliente));
	}

	@Test
	void testCrearArticulo() {
		Articulo articulo = new Articulo(25, "westworld", "juego ios", 10.4f);
		assertTrue(instancia.crear(articulo));
	}

	@Ignore
	void testCrearPedido() {
		fail("Not yet implemented");
	}

	@Test
	void testDameUltimoNumero() {
		TreeMap indice = (TreeMap) new AlmacenArticulo<>("./data/articulos").getIndice();
		Set clave = indice.keySet();
		int totalArticulos=instancia.dameUltimoNumero();
		assertEquals(totalArticulos, clave.size());
	}

}
