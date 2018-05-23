package logica;

import modelo.DAO;

/**
 * 
 * @author Fernan
 *
 */

public class Logica {

	private DAO dao;

	/**
	 * nose que mas cosas tiene el DAO....lo digo para meter ya el constructor
	 * 
	 * @param object
	 * @return
	 */

	/**
	 * Esto deberia de controlar si graba el objeto que le pasamos o no
	 * 
	 * @param object
	 * @return
	 */
	public boolean grabar(Object object) {
		return true;
	}

	/**
	 * Aqui nos devuelve el objeto que le pidamos
	 * 
	 * @return
	 */
	public Object obtener() {
		// seria algo asi mas o menos...
		// dao = new DAO();
		// return dao.leer(ruta....);
		return true;
	}

	/**
	 * esto que hace??? si ya comparamos los objetos dentro de cada una de sus
	 * clases no???
	 */
	public void comprobarDuplicado() {

	}

}
