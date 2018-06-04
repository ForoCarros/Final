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
		comprobarExistente(ruta);
		assert validate();
		this.indice = new TreeMap<>();
		dao = new DAO<>();
	}

	private void comprobarExistente(String path) {
		File ruta = new File(path);
		File datos = new File(this.pathDatos);
		File indices = new File(this.pathIndice);
		if (!ruta.exists()) {
			ruta.mkdirs();
		}
		if (!datos.exists()) {
			try {
				datos.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (!indices.exists()) {
			try {
				indices.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private boolean validate() {
		return this.pathIndice != null && this.pathDatos != null;
	}

	
	public T obtener(K k) {
		indice = (TreeMap<K, Integer>) dao.leer(pathIndice);
		if (indice == null) {
			indice = new TreeMap<>();
			dao.grabar(pathIndice, indice);
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
		// miro el ultimo indice. siempre hay un mapa aqui
		Entry<K, Integer> lastEntry = indice.lastEntry();
		Integer value = 0;
		// si es el primer elemento lastentry sera null
		if (lastEntry != null)
			value = lastEntry.getValue() + 1;
		// si al meterlo el valor es null es que NO esta repetido
		if (indice.put(k, value) == null) {
			// si se almacena bien en el archivo de datos
			if (dao.grabar(pathDatos, t, true)) {
				retorno = true;
				dao.grabar(pathIndice, indice);
			} else {
				//Si no se graba bien actualizamos el indice con la version grabada
				indice = (TreeMap<K, Integer>) dao.leer(pathIndice);
			}
		}
		return retorno;
	}
	
//	public T obtener(K k) {
//		assert k != null;
//		T retorno = null;
//		indice = (TreeMap<K, Integer>) new DAO().leer(pathIndice);
//		Integer posicion = indice.get(k);
//		if (posicion != null) {
//			retorno = (T) new DAO().leer(pathDatos, posicion);
//		}
//		return retorno;
//	}
//
//	public boolean grabar(T t, K k) {
//		assert k != null && t != null;
//		boolean retorno = false;
//		Entry<K, Integer> lastEntry = indice.lastEntry();
//		Integer value = 0;
//		if (lastEntry != null) {
//			value = lastEntry.getValue() + 1;
//		}
//		System.out.println(k);
//		System.out.println(value);
//		if (indice.put(k, value) == null) {
//			if (new DAO<>().grabar(pathDatos, t, true)) {
//				retorno = true;
//				new DAO<>().grabar(pathIndice, indice);
//			} 
////			else {
////				//Si no se graba bien actualizamos el indice con la version grabada
////				indice = (TreeMap<K, Integer>) new DAO<>().leer(pathIndice);
////				// nose si esto tiene que grabar si o si!
////				//new DAO<>().grabar(pathIndice, indice);
////			}
//			System.out.println(indice);
//		}
//		return retorno;
//	}

	/**
	 * devuelve el indice del paquete
	 * 
	 * @return
	 */
	public Object getIndice() {
		return (TreeMap) new DAO<>().leer(pathIndice);
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
