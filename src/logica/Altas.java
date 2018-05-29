package logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeMap;

import control.ParaUI;
import modelo.Articulo;
import modelo.Cliente;
import modelo.DAO;
import modelo.Linea;
import modelo.Pedido;

/**
 * 
 * @author Fernan
 *
 */
public class Altas {

	private ParaUI paraui;
	private Logica logica;

	public Altas(ParaUI paraui) {
		super();
		this.paraui = paraui;
		this.logica = new Logica();
	}

	/**
	 * Crea el articulo en la lista y lo graba en el fichero especifico
	 * 
	 * @param idArticulo
	 * @param nombre
	 * @param descripcion
	 * @param precio
	 * @return true o false segun si puede grabar el objeto en el fichero
	 */
	public boolean crearArticulo(int idArticulo, String nombre, String descripcion, float precio) {
		String ruta = "articulo.txt";
		Articulo articulo = new Articulo(idArticulo, nombre, descripcion, precio);
		ArrayList<Object> listaArticulo = (ArrayList<Object>) this.logica.dameRuta(ruta);
		if (listaArticulo == null)
			listaArticulo = new ArrayList<>();
		if (!listaArticulo.contains(articulo)) {
			listaArticulo.add(articulo);
			return this.logica.grabar(listaArticulo, ruta);
		}
		return false;
	}

	/**
	 * Crea el cliente en la lista y lo graba en el fichero especifico
	 * 
	 * @param razonSocial
	 * @param dni
	 * @param direccion
	 * @param telefono
	 * @return true o false segun si ha podido grabarlo o no
	 */
	public boolean crearCliente(String razonSocial, String dni, String direccion, String telefono) {
		DAO dao = new DAO();
		String ruta = "data/clientes/clientes.data";
		String rutaIndice = "data/clientes/indice.ind";
		this.logica.comprobarArchivoExistente(ruta);
		TreeMap<Integer, Cliente> clientes = (TreeMap<Integer, Cliente>) dao.leer(ruta);
		if(clientes.isEmpty() || clientes.size == 1) {
			clientes.put(key, value)
		}
		return false;
	}

	/**
	 * Crea el pedido sin necesidad de comprobar nada, los clientes hacen pedidos y
	 * nos da igual si son iguales, la cosa es que lo graba en un fichero de pedidos
	 * y punto
	 * 
	 * @param cliente
	 * @param numeroPedido
	 * @return true o false segun si ha podido grabar el pedido en el fichero
	 */
	public boolean crearPedido(int numeroPedido, Cliente cliente) {
		String ruta = "pedido.txt";
		Pedido pedido = new Pedido(numeroPedido, cliente);
		return this.logica.grabar(pedido, ruta);
	}

}
