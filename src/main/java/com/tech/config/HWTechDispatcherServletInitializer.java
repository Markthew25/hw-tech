package com.tech.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
 * HWTechDispatcherServletInitializer will be automatically detected by Spring, 
 * because it's a subclass of AbstractAnnotationConfigDispatcherServletInitializer, 
 * which is an implementation of WebApplicationInitializer. And Spring Web will automatically be detected by the Servlet container, 
 * because Spring Web contains a service provider implementation of ServletContainerInitializer by default, which gets detected automatically. 
 * This implementation is called SpringServletContainerInitializer.
 */
public class HWTechDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {HWTechAppConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {HWWebMVCConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// Auto-generated method stub
		return new String[] {
				"/"
		};
	}
	
}
