package logica;

import modelo.DAO;

/**
 * 
 * @author Fernan
 *
 */

public class Logica {

	private DAO<?> dao;

	public Logica() {
		this.dao = new DAO<>();
	}

	/**
	 * Graba en el archivo que le pasemos el objeto
	 * 
	 * @param object
	 * @param ruta 
	 * @return true o false
	 */
	public boolean grabar(Object object, String ruta) {
		return new DAO<Object>().grabar(ruta, object, true);
	}

	/**
	 * Introduce una ruta por parametro y se la da al dao
	 * 
	 * @param ruta
	 * @return
	 */
	public Object dameRuta(String ruta) {
		dao = new DAO<Object>();
		return dao.leer(ruta);
	}

	/**
	 * Devuelve true o false segun si encuentra en el archivo el objeto que buscamos
	 * 
	 * @return true o false
	 */
	public Object obtener(Object object, String ruta) {
		dao = new DAO<Object>();
		Object dummy = null;
		boolean iguales = false;
		int contador = 0;
		do {
			dao.leer(ruta, contador);
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
