package com.tiendavinos.model;

import java.util.Date;

public class Pedido {
	private Integer idPedido;
	private Date fecha;
	private double total;
	
	public Pedido() {
		// TODO Auto-generated constructor stub
	}

	public Pedido(Integer idPedido, Date fecha, double total) {
		super();
		this.idPedido = idPedido;
		this.fecha = fecha;
		this.total = total;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", fecha=" + fecha + ", total=" + total + "]";
	}
	
	
	
}
