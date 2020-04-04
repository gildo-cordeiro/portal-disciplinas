package com.gildocordeiro.portal.configs;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.gildocordeiro.portal.PortalDisciplinasApplication;

@EnableJpaRepositories(basePackageClasses = PortalDisciplinasApplication.class)
@EnableTransactionManagement
@Configuration
public class JpaConfig {

	//Configuração manual do bean para para o JPA
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
		Properties properties = new Properties();		
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);
		properties.put("hibernate.use_sql_comments", true);
		properties.put("javax.persistence.schema-generation.database.action", "update");//create-drop
		
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource);
		bean.setJpaVendorAdapter(jpaVendorAdapter);		
		bean.setPackagesToScan(PortalDisciplinasApplication.class.getPackage().getName());		
		bean.setPersistenceUnitName("portal");
		bean.setJpaProperties(properties);
		
		return bean;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter bean = new HibernateJpaVendorAdapter();
		
		bean.setDatabase(Database.POSTGRESQL);
		bean.setGenerateDdl(true);
		bean.setShowSql(false);
		
		return bean;
	}
	
	//Link: https://www.baeldung.com/spring-boot-configure-data-source-programmatic
	@Bean
	public DataSource getDataSource() {
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create(); 
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/portal?charSet=LATIN1");
	    dataSourceBuilder.username("postgres"); 
	    dataSourceBuilder.password("postgres"); 
	    return dataSourceBuilder.build(); 
	}
}