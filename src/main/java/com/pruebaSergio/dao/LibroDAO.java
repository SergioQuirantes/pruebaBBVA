package com.pruebaSergio.dao;

import java.util.List;
import java.util.logging.Logger;

import com.googlecode.objectify.ObjectifyService;
import com.pruebaSergio.model.Libro;

public class LibroDAO {

	
	private static final Logger LOGGER = Logger.getLogger(LibroDAO.class.getName());
	
	
	/**
	 * 
	 * @return lista de libros
	 */
	public List<Libro> list(){
		LOGGER.info("Devolviendo lista de libros");
		return ObjectifyService.ofy().load().type(Libro.class).order("id").list();
		}
	
	
	/**
	 * 
	 * @param id
	 * @return Libro correspondiente a la ID
	 */
	public Libro get(Long id) {
		LOGGER.info("Devolviendo libro con id " + id);
		return ObjectifyService.ofy().load().type(Libro.class).id(id).now();
	}
	
	
}
