package modelo;

import java.io.Serializable;
/**
 * 
 * @author Fernan
 *
 */
public class Cliente implements Comparable<Cliente>, Serializable {
	
	private String razonSocial, dni, direccion, telefono;

	public Cliente(String razonSocial, String dni, String direccion, String telefono) {
		super();
		this.razonSocial = razonSocial;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public String getDni() {
		return dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	@Override
	public int compareTo(Cliente o) {
		return this.dni.compareTo(o.getDni());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Cliente) {
			return this.dni.equals(((Cliente) obj).getDni());
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hasCode = 1;
		hasCode = 31 * hasCode + dni.hashCode();
		return hasCode;
	}

	@Override
	public String toString() {
		return "Nombre:" + razonSocial + " | " + "Nif:" + dni;
	}

}
