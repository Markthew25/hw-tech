package com.tech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {
		"com.tech.controller"
})
//SPRING WEB CONFIGURATION
public class HWWebMVCConfig implements WebMvcConfigurer {

		
	@Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
            .addResourceHandler("/resources/**")
            .addResourceLocations("/resources/");
        
    }
	
    // RESOLVING 
 	//failed to lazily initialize a collection of role ERROR
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        OpenEntityManagerInViewInterceptor interceptor = new OpenEntityManagerInViewInterceptor();
//        interceptor.setEntityManagerFactory(emf);
//        registry.addWebRequestInterceptor(interceptor);
//    }
    
}
