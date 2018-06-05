package modelo.acceso;

import java.io.File;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 
 * @author Pablo
 *
 * @param <T>
 * @param <K>
 */
public class AlmacenCliente<T, K> {
	private String pathIndice;
	private String pathDatos;
	private TreeMap<K, Integer> indice;
	private DAO<T> dao;

	public AlmacenCliente(String ruta) {
		super();
		this.pathIndice = ruta + "/clientes.index";
		this.pathDatos = ruta + "/clientes.data";
		assert validate();
		this.indice = new TreeMap<>();
		dao = new DAO<>();
	}

	private boolean validate() {
		return this.pathIndice != null && this.pathDatos != null;
	}

	public T obtener(K k) {
		leerIndice();
		if (indice == null) {
			indice = new TreeMap<>();
			dao.grabar(pathIndice, (T) indice);
		}
		T retorno = null;
		Integer posicion = indice.get(k);
		if (posicion != null) {
			retorno = (T) dao.leer(pathDatos, posicion);
		}
		return retorno;
	}

	/**
	 * Almacen el elemnto de clase T con Clave K, hay que pasarla
	 * 
	 * @param t
	 *            el objeto a grabar
	 * @param k
	 *            la propiedad clave o indice del objeto t
	 * @return true si ha almacenado y false en caso contrario
	 */
	public boolean grabar(T t, K k) {
		boolean retorno = false;
		leerIndice();
		if (indice == null) {
			indice = new TreeMap<>();
			dao.grabar(pathIndice, (T) indice);
		}
		Integer value = indice.size();
		if (indice.put(k, value) == null) {
			// si se almacena bien en el archivo de datos
			if (dao.grabar(pathDatos, t, true)) {
				retorno = true;
				dao.grabar(pathIndice, (T) indice);
			} else {
				// Si no se graba bien actualizamos el indice con la version grabada
				leerIndice();
			}
		}
		return retorno;
	}

	/**
	 * lee el indice del path
	 */
	private void leerIndice() {
		indice = (TreeMap<K, Integer>) dao.leer(pathIndice);
	}

	/**
	 * Borra el objeto pasado y lo busca en el path
	 * @param k
	 * @return
	 */
	public boolean borrar(K k) {
		leerIndice();
		boolean retorno = false;
		if (indice.containsKey(k)) {
			Integer posicion = indice.remove(k);
			if (posicion != null) {
				if (dao.grabar(pathIndice, (T) indice)) {
					retorno = true;
				}
				// para que no elimine los datos, solo el indice, quitamos la linea de abajo
				// retorno=dao.borrarElemtento(pathDatos,posicion);
				if (!retorno) {
					leerIndice();
				}
			}
		}
		return retorno;
	}

	/**
	 * devuelve el indice del paquete
	 * 
	 * @return
	 */
	public Object getIndice() {
		return (TreeMap) new DAO<>().leer(pathIndice);
	}
	/**
	 * devuelve el indice del paquete
	 * 
	 * @return
	 */
	public Object getMap() {
		return (TreeMap) new DAO<T>().leer(pathIndice);
	}

	/**
	 * comprueba si existe el paquete con la ruta dada
	 * 
	 * @param ruta
	 * @return
	 */
	private boolean comprobarExiste(String ruta) {
		File archivo = new File(ruta);
		return archivo.exists();
	}
}
