package logica;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.TreeMap;

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

	/**
	 * graba en el fichero el cliente creado
	 * @param cliente
	 * @return
	 */
	public boolean crear(Cliente cliente) {
		return almacenCliente.grabar(cliente, cliente.getDniCif());
	}

	/**
	 * graba en el fichero el articulo creado
	 * @param articulo
	 * @return
	 */
	public boolean crear(Articulo articulo) {
		System.out.println("estoy en logica, voy almacen");
		return almacenArticulo.grabar(articulo, articulo.getIdArticulo(), articulo.getNombre());
	}

	/**
	 * graba en un fichero el pedido creado
	 * @param pedido
	 * @return
	 */
	public boolean crear(Pedido pedido) {
		return true;
	}
	
	/**
	 * obtiene el ultimo numero del indice en los articulos
	 * @return el ultimo numero
	 */
	public int dameUltimoNumero() {
		int numIndice = 0;
		TreeMap indice = (TreeMap) new AlmacenArticulo<>("./data/articulos").getIndice();
		Set clave = indice.keySet();
		numIndice=clave.size();
		return numIndice;
	}
}