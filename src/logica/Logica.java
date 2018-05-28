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
	 * nose que mas cosas tiene el DAO....lo digo para meter constructor
	 * 
	 * @param object
	 * @return
	 */

	/**
	 * Graba en el archivo que le pasemos el objeto
	 * 
	 * @param object
	 * @return true o false
	 */
	public boolean grabar(Object object) {
		return dao.grabar("ruta", object);
		// return new DAO().grabar("ruta", object, true);
	}

	/**
	 * Introduce una ruta por parametro y se la da al dao
	 * 
	 * @param ruta
	 * @return
	 */
	public Object dameRuta(String ruta) {
		dao = new DAO();
		return dao.leer(ruta);
	}

	/**
	 * Devuelve true o false segun si encuentra en el archivo el objeto que buscamos
	 * 
	 * @return true o false
	 */
	public Object obtener(Object object) {
		dao = new DAO();
		Object dummy = null;
		boolean iguales = false;
		int contador = 0;
		do {
			dao.leer("ruta", contador);
			iguales = comprobarDuplicado(dummy, object);
			contador++;
		} while (iguales = false && dummy != null);
		return iguales;
	}

	/**
	 * Comprueba entre dos objetos si son el mismo
	 * 
	 * @param object
	 * @param object2
	 * @return true o false
	 */
	public boolean comprobarDuplicado(Object object, Object object2) {
		return object.equals(object2);
	}

}
