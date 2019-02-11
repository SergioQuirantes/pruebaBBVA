package com.pruebaSergio.rest;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.pruebaSergio.dao.LibroDAO;
import com.pruebaSergio.model.Libro;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Path("/libro")
@Produces("application/json;charset=utuf-8")
@Api(value = "Libro", description = "Servicio de Libro")
public class LibroResource {
	
	private LibroDAO libroDAO;
	
	public LibroResource() {
		this.libroDAO = new LibroDAO();
	}
	
	
	@GET
	@ApiOperation("Muestra la lista de todos los Libros")
	public Response list() {
		return Response.ok(libroDAO.list()).build();
	}
	
	@GET
	@Path("/{id}")
	@ApiOperation("Recupera un libro por la ID")
	public Response get(@PathParam("id") Long id) {
		Libro libro = libroDAO.get(id);
		
		if(libro == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(libro).build();
	}
	
	@POST
	@Consumes("application/json;charset=utf-8")
	@ApiOperation("Guarda un libro")
	public Response save(Libro libro) {
		libroDAO.save(libro);
		return Response.ok().build();
	}
	
	
	@DELETE
	@Path("/{id}")
	@ApiOperation("Borra un libro por la ID")
	public Response delete(@PathParam("id") Long id) {
		Libro libro = libroDAO.get(id);
		
		if(libro == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		return Response.ok().build();
		
	}
	
	@DELETE
	@Path("/search/{text}")
	@ApiOperation("Busca uno o varios libros que coincidan con el texto")
	public Response search(@PathParam("text") String text) {
		Collection<Libro> listaLibros = libroDAO.search(text);
		
		if(listaLibros.isEmpty()) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(listaLibros).build();
		
	}
	
}
