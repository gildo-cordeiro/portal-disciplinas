package com.gildocordeiro.portal;

import javax.servlet.Filter;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.gildocordeiro.portal.configs.WebConfig;

public class PortalDisciplinasApplication extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
	
	@Override
    protected FrameworkServlet createDispatcherServlet(WebApplicationContext servletAppContext ) {
		DispatcherServlet dispatcher = (DispatcherServlet) super.createDispatcherServlet(servletAppContext);
        dispatcher.setThrowExceptionIfNoHandlerFound(true);
        return dispatcher;
    }
	
	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] {characterEncodingFilter()};
	}
	
	private CharacterEncodingFilter characterEncodingFilter() {
       CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
       
       characterEncodingFilter.setEncoding("UTF-8");
       characterEncodingFilter.setForceEncoding(true);
       
       return characterEncodingFilter;
   }
	
	
	
//	@Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
//        
//        applicationContext.scan(PortalDisciplinasApplication.class.getPackage().getName());
//                
//        servletContext.addListener(new ContextLoaderListener(applicationContext));
//        servletContext.addListener(new RequestContextListener());
//        
//        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", dispatcherServlet(applicationContext));
//        dispatcher.setAsyncSupported(true);
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/");
//        
//        
//        FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("characterEncodingFilter", characterEncodingFilter());
//        characterEncodingFilter.setAsyncSupported(true);
//        characterEncodingFilter.addMappingForServletNames(dispatcherTypes(true), false, "dispatcher");
//    }
//    
//    private DispatcherServlet dispatcherServlet(WebApplicationContext applicationContext) {
//        return new DispatcherServlet(applicationContext);
//    }
//    
//    private CharacterEncodingFilter characterEncodingFilter() {
//        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//        
//        characterEncodingFilter.setEncoding("UTF-8");
//        characterEncodingFilter.setForceEncoding(true);
//        
//        return characterEncodingFilter;
//    }
//    
//    private EnumSet<DispatcherType> dispatcherTypes(boolean asyncSupported) {
//        return (asyncSupported ?
//                EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE, DispatcherType.ASYNC) :
//                EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE));
//    }
//    public static void main(String[] args) {
//		SpringApplication.run(PortalDisciplinasApplication.class, args);
//	}
}
