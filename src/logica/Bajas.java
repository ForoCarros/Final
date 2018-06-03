package logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import control.ParaUI;

/**
 * 
 * @author Adrian
 *
 */
public class Bajas {

	private ParaUI paraui;

	public Bajas(ParaUI paraui) {
		super();
		this.paraui = paraui;
	}

	/**
	 * Segun el nombre o el nif del cliente, borra la linea entera en la que se
	 * encuentra en el archivo
	 * 
	 * @param lineaCliente
	 *            String puede ser tanto el nombre como el nif o ambos
	 */

	public void borrarCliente(String lineaCliente) {
		File inputFile = new File("data\\clientes\\cliente.data");
		File temporal = new File("data\\clientes\\temporal.data");

		BufferedReader reader = null;
		BufferedWriter writer = null;
		String lineaBorrada = lineaCliente;
		String lineaActual = "";

		try {
			reader = new BufferedReader(new FileReader(inputFile));
			writer = new BufferedWriter(new FileWriter(temporal));

			while ((lineaActual = reader.readLine()) != null) {
				// trim newline al comparar con lineaBorrada
				String trimmedLine = lineaActual.trim();
				if (trimmedLine.equals(lineaBorrada))
					continue;
				writer.write(lineaActual + System.getProperty("line.separator"));

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			writer.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean borrado = inputFile.delete();
		boolean rename = temporal.renameTo(inputFile);

		System.out.println("renombrado: " + rename + ", borrado: " + borrado);
	}

}
