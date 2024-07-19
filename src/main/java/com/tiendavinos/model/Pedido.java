package com.tiendavinos.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Ordenes")
public class Pedido {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idPedido;
	private Date fecha;
	
	private double total;
	
	@ManyToOne
	private Usuario usuario;
	
	@OneToOne(mappedBy="pedido")
	private DetallePedido detallePedido;
	
	public Pedido() {
		// TODO Auto-generated constructor stub
	}

	
	public Pedido(Integer idPedido, Date fecha, double total, Usuario usuario, DetallePedido detallePedido) {
		super();
		this.idPedido = idPedido;
		this.fecha = fecha;
		this.total = total;
		this.usuario = usuario;
		this.detallePedido = detallePedido;
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
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

	public DetallePedido getDetallePedido() {
		return detallePedido;
	}

	public void setDetallePedido(DetallePedido detallePedido) {
		this.detallePedido = detallePedido;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", fecha=" + fecha + ", total=" + total + "]";
	}
	
	
	
}
