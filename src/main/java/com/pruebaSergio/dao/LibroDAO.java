package com.pruebaSergio.dao;

import java.util.List;
import java.util.logging.Logger;

import com.googlecode.objectify.ObjectifyService;
import com.pruebaSergio.model.Libro;

public class LibroDAO {

	
	private static final Logger LOGGER = Logger.getLogger(LibroDAO.class.getName());
	
	
	/**
	 * Devuelve la lista de todos los libros almacenados
	 * @return List<Libro>
	 */
	public List<Libro> list(){
		LOGGER.info("Devolviendo lista de libros");
		return ObjectifyService.ofy().load().type(Libro.class).order("id").list();
		}
	
	
	/**
	 * Devuelve un libro por la ID
	 * @param id
	 * @return Libro
	 */
	public Libro get(Long id) {
		LOGGER.info("Devolviendo libro con id " + id);
		return ObjectifyService.ofy().load().type(Libro.class).id(id).now();
	}
	
	 /**
	  * Guarda un libro
	  * @param libro
	  */
	public void save(Libro libro) {
		if(libro == null) {
			throw new IllegalArgumentException("null test object");
		}
		LOGGER.info("Guardando libro " + libro.getId());
		ObjectifyService.ofy().save().entity(libro).now();
	}
	
	/**
	 * Elimina un libro
	 * @param libro
	 */
	public void delete(Libro libro) {
		if(libro == null) {
			throw new IllegalArgumentException("null test object");
		}
		LOGGER.info("Borrando libro " + libro.getId());
		ObjectifyService.ofy().delete().entity(libro);
	}
	
}
