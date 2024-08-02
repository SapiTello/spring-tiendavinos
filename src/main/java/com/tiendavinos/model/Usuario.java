package com.tiendavinos.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idUsuario;
	private String nombre;
	private String dirección;
	private String email;
	private String rol;
	private String contraseña;
	private String tipo;
	
	@OneToMany(mappedBy="usuario")
	private List<Producto> productos;
	
	@OneToMany(mappedBy="usuario")
	private List<Pedido> pedidos;
	
	public Usuario() {
		
	}
	public Usuario(Integer idUsuario, String nombre, String dirección, String email, String rol, String contraseña,
			String tipo, List<Producto> productos, List<Pedido> pedidos) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.dirección = dirección;
		this.email = email;
		this.rol = rol;
		this.contraseña = contraseña;
		this.tipo = tipo;
		this.productos = productos;
		this.pedidos = pedidos;
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





	public String getDirección() {
		return dirección;
	}





	public void setDirección(String dirección) {
		this.dirección = dirección;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
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





	public List<Producto> getProductos() {
		return productos;
	}





	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}





	public List<Pedido> getPedidos() {
		return pedidos;
	}





	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}





	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", dirección=" + dirección + ", email="
				+ email + ", rol=" + rol + ", contraseña=" + contraseña + ", tipo=" + tipo + ", productos=" + productos
				+ ", pedidos=" + pedidos + "]";
	}





	
}
