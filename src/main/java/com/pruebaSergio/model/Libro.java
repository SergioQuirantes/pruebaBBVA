package com.pruebaSergio.model;

import java.util.Date;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.wordnik.swagger.annotations.ApiModel;

@Entity
@Cache
@ApiModel("Libro Object")
public class Libro {

	@Id
	private Long id;
	
	private String nombre;
	
	private String autor;
	
	private Date anoPublicacion;
	
	private String genero;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Date getAnoPublicacion() {
		return anoPublicacion;
	}

	public void setAnoPublicacion(Date anoPublicacion) {
		this.anoPublicacion = anoPublicacion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", autor=" + autor + ", anoPublicacion=" + anoPublicacion
				+ ", genero=" + genero + "]";
	}
	
	
	
}
