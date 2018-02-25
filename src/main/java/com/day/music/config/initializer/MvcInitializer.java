package com.day.music.config.initializer;

import com.day.music.config.WebConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * The class configure MVC DispatcherServlet
 */
public class MvcInitializer implements WebApplicationInitializer {
	/**
	 * property - set logger
	 */
	final static Logger logger = LoggerFactory.getLogger(MvcInitializer.class);
	/**
	 * property - set dispatcher
	 */
	private static final String DISPATCHER = "dispatcher";
	/**
	 * The method configure dispatcher servlet
	 */
	public void onStartup(ServletContext servletContext) throws ServletException {
		logger.info("Begin WebApplicationInitializer");

		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(WebConfig.class);
		servletContext.addListener(new ContextLoaderListener(webContext));
		webContext.setServletContext(servletContext);
		ServletRegistration.Dynamic servletRegistration = servletContext.addServlet(DISPATCHER, new DispatcherServlet(webContext));
		servletRegistration.addMapping("/");
		servletRegistration.setLoadOnStartup(1);

		logger.info("End WebApplicationInitializer");
	}
}