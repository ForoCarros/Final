package logica;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.TreeMap;

import modelo.acceso.AlmacenArticulo;
import modelo.acceso.AlmacenCliente;
import modelo.acceso.AlmacenPedido;
import modelo.acceso.DAO;
import modelo.data.Articulo;
import modelo.data.Cliente;
import modelo.data.Pedido;
import utiles.Rutas;

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
	private AlmacenPedido almacenPedido;
	private Pedido temporal;

	public Logica() {
		this.dao = new DAO<>();
		this.almacenArticulo = new AlmacenArticulo("data/articulos");
		this.almacenPedido = new AlmacenPedido();
		this.almacenCliente = new AlmacenCliente("data/clientes");
		this.temporal = null;
	}

	/**	
	-	 * graba en el fichero el cliente creado	
	-	 * 	
	-	 * @param cliente	
	-	 * @return	
	-	 */
	public boolean crear(Cliente cliente) {
		return almacenCliente.grabar(cliente, cliente.getDniCif());
	}

	/**	
	-	 * graba en el fichero el articulo creado	
	-	 * 	
	-	 * @param articulo	
	-	 * @return	
	-	 */
	public boolean crear(Articulo articulo) {
		System.out.println("estoy en logica, voy almacen");
		return almacenArticulo.grabar(articulo, articulo.getIdArticulo(), articulo.getNombre());
	}

	/**	
	-	 * graba en un fichero el pedido creado	
	-	 * 	
	-	 * @param pedido	
	-	 * @return	
	-	 */
	public boolean crear(Pedido pedido) {
		if (this.almacenPedido.comprobarExistente() && this.almacenPedido.grabar(pedido)) {
			this.temporal = null;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Retorna el n�mero de pedido que corresponde.
	 * 
	 * @return el n�mero de pedido que corresponde, el actual.
	 */
	public int dameUltimoNumeroPedido() {
		new AlmacenPedido().comprobarExistente();
		return new AlmacenPedido().leerNumero();
	}
	
	public Articulo buscarArticulo(String nombreArticulo) {
		return (Articulo) almacenArticulo.leer(nombreArticulo);
	}
	
	public Cliente buscarCliente(String razonSocial) {
		return (Cliente) almacenCliente.obtener(razonSocial);
	}
	
	
	/**
	 * obtiene el ultimo numero del indice en los articulos
	 * @return el ultimo numero
	 */
	public int dameUltimoNumero() {
		int numIndice = 0;
		TreeMap indice = (TreeMap) new AlmacenArticulo<>("./data/articulos").getIndice();
		Set clave = indice.keySet();
		numIndice=(clave.size())+1;
		return numIndice;
	}
	
	public boolean eliminarCliente(Object selectedItem) {
	
		// esto es un royo...buscas cliente en datos? y lo eliminas? y eliminas su
		// referencia en el map? y en el archivo indice?
	
	return false;
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
	
	public Pedido getTemporal() {
		return this.temporal;
	}

	public void setTemporal(Pedido pedido) {
		this.temporal = pedido;
	}

}