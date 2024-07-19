package com.tiendavinos.model;

public class Usuario {
	private Integer idUsuario;
	private String nombre;
	private String rol;
	private String contraseña;
	private String tipo;
	private String password;
	
	public Usuario() {
		
	}	
	
	public Usuario(Integer idUsuario, String nombre, String rol, String contraseña, String tipo, String password) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.rol = rol;
		this.contraseña = contraseña;
		this.tipo = tipo;
		this.password = password;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", rol=" + rol + ", contraseña=" + contraseña
				+ ", tipo=" + tipo + ", password=" + password + "]";
	}
	
	
	
}
