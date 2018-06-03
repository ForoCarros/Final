package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import modelo.acceso.AlmacenCliente;
import modelo.data.Cliente;

class AlmacenClienteTest {

	AlmacenCliente instancia = new AlmacenCliente<>("./Test/testClientes/");
	Cliente cliente = new Cliente("00000000P", "pepito", "algo", "999999999");

	@Test
	void testGrabar() {
		assertTrue(instancia.grabar(cliente, cliente.getDniCif()));
	}
	
	
	@Ignore
	void testObtener() {
		assertEquals(cliente, instancia.obtener(cliente.getDniCif()));
	}


	@Ignore
	void testGetIndice() {
		fail("Not yet implemented");
	}

}
