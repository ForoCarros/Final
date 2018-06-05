package modelo.acceso;

import java.io.File;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.TreeMap;

import modelo.data.Keyable;

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
		//comprobarExistente(ruta);
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
			if(posicion!=null){
				retorno=dao.borrarElemento(pathDatos,posicion);
				if(!retorno){
					leerIndice();
				}else{
					recargaIndice();
					dao.grabar(pathIndice, (T) indice);
				}
			}
		}
		return retorno;
	}
	
	
	
	private void recargaIndice() {
		indice=new TreeMap<>();
		int posicion=0;
		T t=(T) dao.leer(pathDatos, posicion);
		while (t!=null){
			Keyable<K> elemento=(Keyable<K>) t;
			K k=elemento.getKey();
			indice.put(k, posicion);
			posicion++;
			t=(T) dao.leer(pathDatos, posicion);
		}
		
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
