package logica;

import java.io.File;
import java.io.IOException;

import modelo.acceso.AlmacenArticulo;
import modelo.acceso.AlmacenCliente;
import modelo.acceso.DAO;
import modelo.data.Articulo;
import modelo.data.Cliente;
import modelo.data.Pedido;

/**
 * 
 * @author Fernan
 * @param <T>
 * @param <T>
 * @param <K>
 *
 */

public class Logica {

	private DAO dao;
	private AlmacenCliente almacenCliente;
	private AlmacenArticulo almacenArticulo;

	public Logica() {
		this.dao = new DAO<>();
		this.almacenCliente = new AlmacenCliente("data/clientes");
		this.almacenArticulo = new AlmacenArticulo("data/articulos");
	}

	public boolean crear(Cliente cliente) {
		return almacenCliente.grabar(cliente, cliente.getDniCif());
	}

	public boolean crear(Articulo articulo) {
		System.out.println("estoy en logica, voy almacen");
		return almacenArticulo.grabar(articulo, articulo.getIdArticulo(), articulo.getNombre());
	}

	public boolean crear(Pedido pedido) {
		return true;
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

	public void comprobarArchivoExistente(String ruta) {
		File f = new File(ruta);
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
