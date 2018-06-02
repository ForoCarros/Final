package modelo.acceso;

import java.util.Map.Entry;
import java.util.TreeMap;
/**
 * 
 * @author jose
 *	Version del 30 de mayo
 * @param <T>
 * @param <K>
 */
public class AlmacenIndice<T, K> {
	private String pathIndice;
	private String pathDatos;
	private TreeMap<K, Integer> indice;
	DAO<T> dao;

	public AlmacenIndice(String pathIndice, String pathDatos) {
		super();
		this.pathIndice = pathIndice;
		this.pathDatos = pathDatos;
		// invariantes de clase
		assert validate();
		this.indice = new TreeMap<>();
		dao = new DAO<>();
	}

	private boolean validate() {
		return this.pathIndice != null && this.pathDatos != null;
	}

	public T obtener(K k) {
		assert k != null;
		indice = (TreeMap<K, Integer>) dao.leer(pathIndice);
		if (indice == null) {
			indice = new TreeMap<>();
			new DAO<>().grabar(pathIndice, indice);
		}
		T retorno = null;
		Integer posicion = indice.get(k);
		if (posicion != null) {
			retorno = (T) dao.leer(pathDatos, posicion);
		}
		return retorno;
	}

	public boolean grabar(T t, K k) {
		assert k != null && t != null;
		boolean retorno = false;
		// miro el ultimo indice. siempre hay un mapa aqui
		Entry<K, Integer> lastEntry = indice.lastEntry();
		Integer value = 0;
		// si es el primer elemento lastentry sera null
		if (lastEntry != null) {
			value = lastEntry.getValue() + 1;
		}
		if (indice.put(k, value) == null) {
			if (dao.grabar(pathDatos, t, true)) {
				retorno = true;
				new DAO<>().grabar(pathIndice, indice);
			}else{
				//Si no se graba bien actualizamos el indice con la version grabada
				indice = (TreeMap<K, Integer>) dao.leer(pathIndice);
			}
		}
		return retorno;
	}
}
