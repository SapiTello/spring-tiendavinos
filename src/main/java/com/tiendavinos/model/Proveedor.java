package com.tiendavinos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Proveedor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idProveedor;
	private String nombre;
	private String email;
	private String telefono;
	
	public Proveedor() {
		// TODO Auto-generated constructor stub
	}

	public Proveedor(Integer idProveedor, String nombre, String email, String telefono) {
		super();
		this.idProveedor = idProveedor;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
	}

	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Proveedor [idProveedor=" + idProveedor + ", nombre=" + nombre + ", email=" + email + ", telefono="
				+ telefono + "]";
	}
	
	

}
