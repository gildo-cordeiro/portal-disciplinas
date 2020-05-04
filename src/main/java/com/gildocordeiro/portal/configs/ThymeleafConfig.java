package com.gildocordeiro.portal.configs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.UrlTemplateResolver;

import nz.net.ultraq.thymeleaf.LayoutDialect;

//Arquivo de configuração do Thymeleaf
@Configuration
public class ThymeleafConfig {

    private static final String VIEWS = "/WEB-INF/views/";
    
    private ApplicationContext applicationContext;
    
	@Bean
	public ViewResolver thymeleafViewResolver(ITemplateEngine springTemplateEngine) {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		
		viewResolver.setTemplateEngine(springTemplateEngine);
		viewResolver.setCharacterEncoding("UTF-8");
		viewResolver.setViewNames(new String[] {"*html"});
		
		return viewResolver;
	}

	//Sobre Beans: https://www.baeldung.com/spring-bean	
	@Bean
	public SpringTemplateEngine sprinhTemplateEngine(ITemplateResolver templateResolver) {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.addTemplateResolver(new UrlTemplateResolver());
        templateEngine.addTemplateResolver(templateResolver());	
        
        //O sec so funciona com essas configurações abaixo 
        templateEngine.setEnableSpringELCompiler(true);
        templateEngine.addDialect(new SpringSecurityDialect());
        
        //O layout so funciona com essa config abaixo
        templateEngine.addDialect(new LayoutDialect());
        return templateEngine;
	}
	
	@Bean
	public ITemplateResolver templateResolver() {
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
			
   		resolver.setPrefix(VIEWS);
   		resolver.setApplicationContext(applicationContext);
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCharacterEncoding("UTF-8");
        resolver.setCacheable(false);
        return resolver;
	}

}
