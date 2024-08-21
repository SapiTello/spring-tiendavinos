package com.tiendavinos.model;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Resena {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idResena;
	private String nombre;
	private String comentario;
	private LocalDateTime fecha;	
	
	public Resena() {
	
	}

	public Resena(Integer idResena, String nombre, String comentario, LocalDateTime fecha) {
		super();
		this.idResena = idResena;
		this.nombre = nombre;
		this.comentario = comentario;
		this.fecha = fecha;
	}



	public Integer getIdResena() {
		return idResena;
	}



	public void setIdResena(Integer idResena) {
		this.idResena = idResena;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getComentario() {
		return comentario;
	}



	public void setComentario(String comentario) {
		this.comentario = comentario;
	}



	public LocalDateTime getFecha() {
		return fecha;
	}



	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	

}
