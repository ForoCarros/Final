package logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import control.ParaUI;

public class Bajas {
	
	private ParaUI paraui;

	public Bajas(ParaUI paraui) {
		super();
		this.paraui = paraui;
	}
	
	public void borrarCliente(String nombreCliente) {
		File inputFile = new File("data\\clientes\\cliente.data");
		File temporal = new File("data\\clientes\\temporal.data");

		BufferedReader reader = null;
		BufferedWriter writer = null;
		String lineaBorrada = nombreCliente;
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
		
		System.out.println("renombrado: "+rename + ", borrado: " + borrado);
	}

}
