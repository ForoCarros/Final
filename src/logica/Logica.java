package logica;

import java.util.Set;
import java.util.TreeMap;

import modelo.acceso.AlmacenArticulo;
import modelo.acceso.AlmacenCliente;
import modelo.acceso.AlmacenPedido;
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

	private AlmacenCliente almacenCliente;
	private AlmacenArticulo almacenArticulo;
	private Pedido temporal;

	public Logica() {
		this.almacenCliente = new AlmacenCliente("data/clientes");
		this.almacenArticulo = new AlmacenArticulo("data/articulos");
		this.temporal = null;
	}

	/**
	 * graba en el fichero el cliente creado
	 * 
	 * @param cliente
	 * @return
	 */
	public boolean crear(Cliente cliente) {
		return almacenCliente.grabar(cliente, cliente.getDniCif());
	}

	/**
	 * graba en el fichero el articulo creado
	 * 
	 * @param articulo
	 * @return
	 */
	public boolean crear(Articulo articulo) {
		System.out.println("estoy en logica, voy almacen");
		return almacenArticulo.grabar(articulo, articulo.getIdArticulo(), articulo.getNombre());
	}

	/**
	 * graba en un fichero el pedido creado
	 * 
	 * @param pedido
	 * @return
	 */
	public boolean crear(Pedido pedido) {
		return new AlmacenPedido().grabar(pedido);
	}

	public Articulo buscarArticulo(String nombre) {
		return (Articulo) this.almacenArticulo.leer(nombre);
	}

	public Cliente buscarCliente(String dni) {
		return (Cliente) this.almacenCliente.obtener(dni);
	}

	/**
	 * Retorna el número de pedido que corresponde.
	 * 
	 * @return el número de pedido que corresponde, el actual.
	 */
	public int dameUltimoNumeroPedido() {
		return new AlmacenPedido().leerNumero();
	}

	/**
	 * obtiene el ultimo numero del indice en los articulos
	 * 
	 * @return el ultimo numero
	 */
	public int dameUltimoNumero() {
		int numIndice = 0;
		TreeMap indice = (TreeMap) new AlmacenArticulo<>("./data/articulos").getIndice();
		Set clave = indice.keySet();
		numIndice = clave.size();
		return numIndice;
	}

	/**
	 * elimina el cliente seleccionado en el comboBox
	 * 
	 * @param selectedItem
	 * @return true o false
	 */
	public boolean eliminarCliente(Object cliente) {
		boolean retorno = false;
		TreeMap indice = (TreeMap) new AlmacenCliente<>("./data/clientes").getIndice();
		if (indice != null) {
			Set clave = indice.keySet();
			for (Object clienteClave : clave) {
				System.out.println(clienteClave);
				if (clienteClave.toString().equals(cliente)) {
					System.out.println("encontrado");
					return almacenCliente.borrar(clienteClave);
					// return true;
				}
			}
		}
		return retorno;
	}

	public Pedido getTemporal() {
		return this.temporal;
	}

	public void setTemporal(Pedido pedido) {
		this.temporal = pedido;
	}
}