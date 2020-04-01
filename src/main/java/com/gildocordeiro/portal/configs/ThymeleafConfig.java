package com.gildocordeiro.portal.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.UrlTemplateResolver;

//Arquivo de configuração do Thymeleaf
@Configuration
public class ThymeleafConfig {

    private static final String VIEWS = "/WEB-INF/views/";
    
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
        return templateEngine;
	}
	
	@Bean
	public ITemplateResolver templateResolver() {
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
			
   		resolver.setPrefix(VIEWS);
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCharacterEncoding("UTF-8");
        resolver.setCacheable(false);
        return resolver;
	}

}
