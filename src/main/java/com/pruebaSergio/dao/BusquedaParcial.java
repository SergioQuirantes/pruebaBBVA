package com.pruebaSergio.dao;

import com.google.appengine.api.search.Document;
import com.google.appengine.api.search.Field;
import com.google.appengine.api.search.Index;
import com.google.appengine.api.search.IndexSpec;
import com.google.appengine.api.search.SearchServiceFactory;
import com.pruebaSergio.model.Libro;


/**
 * Clase para el tratamiento de los objetos en la busqueda de texto parcial
 * @author squirantes
 *
 */
public class BusquedaParcial {

	
	private Index index;
	
	/**
	 * Constructor que inicializa el indice
	 */
	public BusquedaParcial() {
		IndexSpec indexSpec = IndexSpec.newBuilder().setName("indiceLibros").build();
		index = SearchServiceFactory.getSearchService().getIndex(indexSpec);		
	}
	
	
	/**
	 * Añade un libro al indice
	 * @param libro
	 */
	public void indexar(Libro libro) {
		
		Document document = Document.newBuilder()
				.setId(libro.getId().toString())
				.addField(Field.newBuilder().setName("nombre").setText(desglosar(libro.getNombre())))
				.addField(Field.newBuilder().setName("autor").setText(desglosar(libro.getAutor())))
				.addField(Field.newBuilder().setName("anoPublicacion").setDate(libro.getAnoPublicacion()))
				.addField(Field.newBuilder().setName("genero").setText(libro.getGenero()))
				.build();
		
		index.put(document);
		
	}
	
	/**
	 * Borra un libro del indice
	 * @param libro
	 */
	public void desindexar(Libro libro) {
		index.delete(libro.getId().toString());
	}
	
	
	/**
	 * Devuelve un String con cada una de las palabras desglosadas en diferentes prefijos posibles
	 * para facilitarle a la API la búsqueda por  texto parcial, pues la API solo busca palabras completas
	 * 
	 * (la palabra "hola" se devolvería en "h" "ho" "hol" "hola" y así con todas)
	 * 
	 * @param texto
	 * @return String
	 */
	private String desglosar(String texto) {
		
		StringBuilder desglose = new StringBuilder();
		
		for(String palabra : texto.split(" ")) {
			
			int contador = 1;
			
			do {				
				desglose.append(palabra.substring(0, contador)).append(" ");
				contador++;
			}while(contador <= palabra.length());
			
		}
		
		return desglose.toString();
	}
	
}
