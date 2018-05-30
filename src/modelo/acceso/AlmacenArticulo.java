package modelo.acceso;

import java.io.File;
import java.io.IOException;
import java.util.TreeMap;

public class AlmacenArticulo<T, K> {

	private String pathIndice;
	private StringBuilder pathDatos;
	private TreeMap<K, Integer> indice;
	private DAO<T> dao;

	public AlmacenArticulo(String ruta) {
		super();
		this.pathIndice = ruta + "articulo.data";
		this.pathDatos = new StringBuilder(ruta);
		comprobarExistente(ruta);
		assert validate();
		this.indice = new TreeMap<>();
		dao = new DAO<>();
	}

	private boolean validate() {
		return this.pathIndice != null && this.pathDatos != null;
	}

	private void comprobarExistente(String path) {
		File ruta = new File(path);
		File datos = new File(this.pathDatos.toString());
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

	public T leer(String nombre) {
		T retorno = null;
		comprobarExistente(pathIndice);
		indice = (TreeMap<K, Integer>) dao.leer(pathIndice);
		Integer posicion = indice.get(nombre);
		if (posicion != null) {
			pathDatos.append(posicion + ".art");
			retorno = (T) dao.leer(pathDatos.toString());
		}
		return retorno;
	}

	public boolean grabar(T t, Integer numero, String nombre) {
		boolean retorno = false;
		this.pathDatos.append(numero + ".art");
		comprobarExistente(pathIndice);
		if (indice.put((K) nombre, numero) == null) {
			if (dao.grabar(pathDatos.toString(), t)) {
				new DAO<>().grabar(pathIndice, this.indice);
				retorno = true;
			} else {
				indice = (TreeMap<K, Integer>) dao.leer(pathIndice);
			}
		}
		return retorno;
	}

}
