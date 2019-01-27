package com.pruebaSergio.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Libro {

	@Id
	private Long id;
	
	private String nombre;
	
	private String autor;
	
	
	
	
}
