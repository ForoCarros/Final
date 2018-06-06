package modelo.acceso;

import java.io.File;
import java.io.IOException;
import java.util.TreeMap;

import modelo.data.Articulo;
import utiles.Rutas;

/**
 * 
 * @author Fernan
 *
 * @param <T>
 * @param <K>
 */
public class AlmacenArticulo<T, K> {

	private String pathIndice;
	private String pathDatos;
	private TreeMap<K, Integer> indice;
	private DAO<T> dao;

	public AlmacenArticulo(String ruta) {
		super();
		this.pathIndice = ruta + "/articulo.data";
		this.pathDatos = ruta;
		File file = new File(pathDatos);
		if (!file.exists()) {
			file.mkdirs();
		}
		this.indice = new TreeMap<>();

	}

	/**
	 * comprueba si el fichero con la ruta del indice existe
	 * 
	 * @param ruta
	 * @return
	 */
	private boolean comprobarExiste(String ruta) {
		File archivo = new File(ruta);
		return archivo.exists();
	}

	private boolean validate() {
		return this.pathIndice != null && this.pathDatos != null;
	}

	/**
	 * devuelve el indice
	 * 
	 * @return
	 */
	public Object getIndice() {
		if (comprobarExiste(pathIndice)) {
			return (TreeMap) new DAO<>().leer(pathIndice);
		} else {
			return null;
		}
	}

	public T leer(String nombre) {
		System.out.println("estoy en almacen leer");
		T retorno = null;
		if (comprobarExiste(pathIndice)) {
			indice = (TreeMap<K, Integer>) new DAO().leer(pathIndice);
			Integer posicion = indice.get(nombre);
			if (posicion != null) {
				retorno = (T) new DAO().leer(this.pathDatos + "/" + posicion + ".art");
			}
		}
		return retorno;
	}

	public boolean grabar(T t, Integer numero, String nombre) {
		System.out.println("estoy en almacen grabar");
		boolean retorno = false;
		if (comprobarExiste(pathIndice)) {
			indice = (TreeMap<K, Integer>) new DAO().leer(pathIndice);
		}
		boolean grabar = new DAO<>().grabar(this.pathDatos + "/" + numero + ".art", t);
		if (grabar) {
			indice.put((K) nombre, numero);
			retorno = new DAO<>().grabar(this.pathIndice, this.indice);
		}
		return retorno;
	}

}
