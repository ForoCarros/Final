package modelo.acceso;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AlmacenPedido {
	private DAO dao;
	private String pathNUP = "numeroUltimoPedido.data";
	private String pathPedidos = "./data/pedidos";

	public AlmacenPedido() {
		super();
		this.dao = new DAO<>();
	}

	/**
	 * Comprueba si el directorio data/pedidos existe y si no, lo crea. Igual con el
	 * archivo ultimoNumeroPedido.data.
	 */
	public void comprobarExistente() {
		File ultimo = new File(pathNUP);
		File carpetaPedidos = new File(pathPedidos);
		if (!ultimo.exists()) {
			try {
				ultimo.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (!carpetaPedidos.exists()) {
			carpetaPedidos.mkdir();
		}
	}

	/**
	 * Graba el número en el archivo de último número de pedido.
	 * 
	 * @param valor
	 *            el valor a guardar.
	 */
	private void grabarNumero(int valor) {
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
			conversorR.readInt();
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
