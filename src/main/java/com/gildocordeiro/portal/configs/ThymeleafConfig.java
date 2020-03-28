package com.gildocordeiro.portal.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

//Arquivo de configuração do Thymeleaf
//Sobre Beans: https://www.baeldung.com/spring-bean
@Configuration
public class ThymeleafConfig {

	//Injeção de dependencias atraves da anotação Autowired
	//Sobre Autowired: https://www.baeldung.com/?s=Autowired
	@Autowired
	private ApplicationContext applicationContext;
	
	@Bean
	public ViewResolver thymeleafViewResolver(ITemplateEngine springTemplateEngine) {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		
		viewResolver.setOrder(1);
		viewResolver.setTemplateEngine(springTemplateEngine);
		viewResolver.setCharacterEncoding("UTF-8");
		viewResolver.setViewNames(new String[] {"*html"});
		
		return viewResolver;
	}
	
	@Bean
	public ITemplateEngine sprinhTemplateEngine(ITemplateResolver templateResolver) {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		
		templateEngine.setTemplateResolver(templateResolver);
		templateEngine.setEnableSpringELCompiler(true);
		
		return templateEngine;
	}
	
	@Bean
	public ITemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		
		templateResolver.setApplicationContext(applicationContext);
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setPrefix("/WEB-INF/paginas");
		templateResolver.setCharacterEncoding("UTF-8");
		templateResolver.setCacheable(false);
		
		return templateResolver;
	}
}
