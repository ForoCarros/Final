package Test;



import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import utiles.Validador;

/**
 * 
 * @author Camacho
 *
 */
class ValidadorTest {
Validador instancia = new Validador();
	
	@Test
	void testComprobarVacio() {
		String[] vacio = {"","H"};
		assertTrue(instancia.comprobarVacio(vacio[0]));
		assertFalse(instancia.comprobarVacio(vacio[1]));
	}

	@Test
	void testComprobarTelefono() {
		String[] telefonos = {"696849236","8387923","69684H236","696 49236"};
		for (int i = 0; i < telefonos.length; i++) {
			if (i==0) {
				assertTrue(instancia.comprobarTelefono(telefonos[i]));
			}else {
				assertFalse(instancia.comprobarTelefono(telefonos[i]));
			}
		}
	}

	@Test
	void testComprobarNif() {
		String[] nifs = {"45969672D","459672D","4596967HD","4596/672D"};
		for (int i = 0; i < nifs.length; i++) {
			if (i==0) {
				assertTrue(instancia.comprobarNif(nifs[i]));
			}else {
				assertFalse(instancia.comprobarNif(nifs[i]));
			}
		}
	}

}
