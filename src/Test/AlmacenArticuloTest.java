package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Ignore;
//import org.junit.jupiter.api.Test;
import org.junit.Test;

import modelo.acceso.AlmacenArticulo;
import modelo.data.Articulo;

class AlmacenArticuloTest {

	AlmacenArticulo instancia = new AlmacenArticulo<>("./Test/testArticulo");
	Articulo articuloUno = new Articulo(1, "taza", "porcelana", 50);
	Articulo articuloDos = new Articulo(2, "cafe", "mezcla", 10);

	@Test
	void testGrabar() {
		assertTrue(instancia.grabar(articuloUno, articuloUno.getIdArticulo(), articuloUno.getNombre()));
		assertTrue(instancia.grabar(articuloDos, articuloDos.getIdArticulo(), articuloDos.getNombre()));
		assertNotEquals(articuloUno, articuloDos);

	}

	@Ignore
	void testLeer() {
		assertEquals(articuloUno, instancia.leer(articuloUno.getNombre()));
		assertEquals(articuloDos, instancia.leer(articuloDos.getNombre()));
	}

}
