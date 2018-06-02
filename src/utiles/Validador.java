package utiles;

import java.util.regex.Pattern;

public class Validador {
	// Devuelve true si esta vacio y false si no.
	public boolean comprobarVacio(String campo) {
		if (campo.isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean comprobarTelefono(String telefono) {
		String telefonoRegexp = "[0-9]{9}$";
		return comprobacionRegular(telefonoRegexp, telefono);
	}

	public boolean comprobarNif(String dni) {
		String dniRegexp = "\\d{8}[A-HJ-NP-TV-Z]";
		return comprobacionRegular(dniRegexp, dni);
	}

	private boolean comprobacionRegular(String expresionRegular, String input) {
		if (Pattern.matches(expresionRegular, input)) {
			return true;
		}
		return false;
	}

	public boolean comprobarDigitos(String text) {
		char caracter;
		for (int i = 0; i < text.length(); i++) {
			caracter = text.charAt(i);
			if (!Character.isDigit(caracter)) {
				return false;
			}
		}
		return true;
	}
}
