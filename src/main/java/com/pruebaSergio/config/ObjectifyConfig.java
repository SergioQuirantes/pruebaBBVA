package com.pruebaSergio.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.impl.translate.opt.joda.DateTimeZoneTranslatorFactory;
import com.googlecode.objectify.impl.translate.opt.joda.LocalDateTimeTranslatorFactory;
import com.googlecode.objectify.impl.translate.opt.joda.LocalDateTranslatorFactory;
import com.googlecode.objectify.impl.translate.opt.joda.ReadableInstantTranslatorFactory;
import com.pruebaSergio.model.Libro;



public class ObjectifyConfig implements ServletContextListener {
	
	
	static {
		ObjectifyService.factory().getTranslators().add(new ReadableInstantTranslatorFactory());
		ObjectifyService.factory().getTranslators().add(new LocalDateTranslatorFactory());
		ObjectifyService.factory().getTranslators().add(new LocalDateTimeTranslatorFactory());
		ObjectifyService.factory().getTranslators().add(new DateTimeZoneTranslatorFactory());
		
		ObjectifyService.register(Libro.class);
	}
	

	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
