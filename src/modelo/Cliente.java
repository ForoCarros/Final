package modelo;

public class Cliente {
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

}
