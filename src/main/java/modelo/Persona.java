package modelo;

import java.util.Date;

public class Persona {
	private String Rut, Nombre, Apellido, Telefono;
	private Date FechaIngreso;
	public String getRut() {
		return Rut;
	}
	
	
	
	
	public Persona(String rut, String nombre, String apellido, String telefono, Date fechaIngreso) {
		super();
		Rut = rut;
		Nombre = nombre;
		Apellido = apellido;
		Telefono = telefono;
		FechaIngreso = fechaIngreso;
	}




	public void setRut(String rut) {
		Rut = rut;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public Date getFechaIngreso() {
		return FechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		FechaIngreso = fechaIngreso;
	}
	
	

}
