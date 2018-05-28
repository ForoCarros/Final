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
public class Altas {

	private ParaUI paraui;
	private Logica logica;

	public Altas(ParaUI paraui) {
		super();
		this.paraui = paraui;
	}

	/**
	 * Crea el articulo en la lista y lo graba en el fichero especifico
	 * 
	 * @param idArticulo
	 * @param nombre
	 * @param descripcion
	 * @param precio
	 * @return
	 */
	public boolean crearArticulo(int idArticulo, String nombre, String descripcion, float precio) {
		Articulo articulo = new Articulo(idArticulo, nombre, descripcion, precio);
		logica = new Logica();
		ArrayList listaArticulo = (ArrayList) logica.dameRuta("articulo.txt");
		if (listaArticulo == null)
			listaArticulo = new ArrayList<>();
		if (!listaArticulo.contains(articulo)) {
			listaArticulo.add(articulo);
			return logica.grabar(listaArticulo);
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
	 * @return
	 */
	public boolean crearCliente(String razonSocial, String dni, String direccion, String telefono) {
		Cliente cliente = new Cliente(razonSocial, dni, direccion, telefono);
		logica = new Logica();
		ArrayList listacliente = (ArrayList) logica.dameRuta("cliente.txt");
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
	 * No se si esto tambien hay que guardarlo en una lista de pedidos....
	 * 
	 * @param cliente
	 * @param numeroPedido
	 * @return true o false
	 */
	public boolean crearPedido(int numeroPedido, Cliente cliente) {
		Pedido pedido = new Pedido(numeroPedido, cliente);
		logica = new Logica();
		return logica.grabar(pedido);
	}

}
