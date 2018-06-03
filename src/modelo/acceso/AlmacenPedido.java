package modelo.acceso;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import utiles.Rutas;

public class AlmacenPedido {
	private String pathNUP = Rutas.pathNUPTest;
	private String pathPedidos = Rutas.pathPedidosTest;

	public AlmacenPedido() {
		super();
	}

	/**
	 * Comprueba si el directorio data/pedidos existe y si no, lo crea. Igual con el
	 * archivo ultimoNumeroPedido.data.
	 */
	public boolean comprobarExistente() {
		File ultimo = new File(this.pathNUP);
		File carpetaPedidos = new File(this.pathPedidos);
		if (!carpetaPedidos.exists()) {
			carpetaPedidos.mkdirs();
		}
		if (!ultimo.exists()) {
			try {
				if (ultimo.createNewFile()) {
					System.out.println("NUP creado.");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return carpetaPedidos.exists() && ultimo.exists();
	}

	/**
	 * Graba el número en el archivo de último número de pedido.
	 * 
	 * @param valor
	 *            el valor a guardar.
	 */
	public void grabarNumero(int valor) {
		File archivo = new File(pathNUP);
		FileOutputStream flujoW = null;
		DataOutputStream conversorW = null;
		try {
			flujoW = new FileOutputStream(archivo);
			conversorW = new DataOutputStream(flujoW);
			conversorW.writeInt(valor);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			flujoW.close();
			conversorW.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Lee el número del archivo que corresponde con el último número de pedido.
	 * 
	 * @return el número leido o -1 si ha ocurrido algún error.
	 */
	public int leerNumero() {
		File archivo = new File(pathNUP);
		FileInputStream flujoR = null;
		DataInputStream conversorR = null;
		int valor = -1;
		try {
			flujoR = new FileInputStream(archivo);
			conversorR = new DataInputStream(flujoR);
			valor = conversorR.readInt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			flujoR.close();
			conversorR.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valor;
	}
}
