package com.tiendavinos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class DetallePedido {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idDetallePedido;
	private String nombre;
	private String cantidad;
	private double precio;
	private double total;
	
	@OneToOne
	private Pedido pedido;
	
	@ManyToOne
	private Producto producto;
	
	public DetallePedido() {
		// TODO Auto-generated constructor stub
	}

	

	public DetallePedido(Integer idDetallePedido, String nombre, String cantidad, double precio, double total,
			Pedido pedido, Producto producto) {
		super();
		this.idDetallePedido = idDetallePedido;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.total = total;
		this.pedido = pedido;
		this.producto = producto;
	}

	public Integer getIdDetallePedido() {
		return idDetallePedido;
	}

	public void setIdDetallePedido(Integer idDetallePedido) {
		this.idDetallePedido = idDetallePedido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "DetallePedido [idDetallePedido=" + idDetallePedido + ", nombre=" + nombre + ", cantidad=" + cantidad
				+ ", precio=" + precio + ", total=" + total + "]";
	}
	
	

}
