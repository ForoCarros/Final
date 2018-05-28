package logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import control.ParaUI;
import modelo.Articulo;
import modelo.Cliente;
import modelo.Linea;
import modelo.Pedido;

/**
 * 
 * @author Fernan
 *
 */
public class Altas{

	private ParaUI paraui;

	public Altas(ParaUI paraui) {
		super();
		this.paraui = paraui;
	}

	/**
	 * 
	 * @param id
	 * @param nombre
	 * @param descripcion
	 * @param la
	 *            serie historica va aqui tambien?? o deberia ser un boolean para
	 *            ver si esta o no??
	 * @return
	 */

	public boolean crearArticulo(int idArticulo, String nombre, String descripcion, float precio) {
		Articulo articulo = new Articulo(idArticulo, nombre, descripcion, precio);
		Logica logica = new Logica();
		ArrayList listaArticulo = (ArrayList) logica.obtener();
		if (listaArticulo == null)
			listaArticulo = new ArrayList<>();
		if (!listaArticulo.contains(articulo)) {
			listaArticulo.add(articulo);
			return logica.grabar(listaArticulo);
		}
		return false;
	}

	/**
	 * Crea el cliente en la lista y lo graba en el fichero
	 * 
	 * @param razonSocial
	 * @param dni
	 * @param direccion
	 * @param telefono
	 * @return
	 */
	public boolean crearCliente(String razonSocial, String dni, String direccion, String telefono) {
		Cliente cliente = new Cliente(razonSocial, dni, direccion, telefono);
		Logica logica = new Logica();
		ArrayList listacliente = (ArrayList) logica.obtener();
		if (listacliente == null)
			listacliente = new ArrayList();
		if (!listacliente.contains(cliente)) {
			listacliente.add(cliente);
			return logica.grabar(listacliente);
		}
		return false;
	}

	/**
	 * Crea el pedido sin necesidad de comprobar nada, los clientes hacen pedidos y
	 * nos da igual si son iguales
	 * 
	 * @param cliente
	 * @param numeroPedido
	 * @return true o false
	 */
	public boolean crearPedido(int numeroPedido, Cliente cliente) {
		Pedido pedido = new Pedido(numeroPedido, cliente);
		Logica logica = new Logica();
		return logica.grabar(pedido);
	}

}
