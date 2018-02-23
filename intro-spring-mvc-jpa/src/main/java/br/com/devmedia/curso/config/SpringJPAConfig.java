package br.com.devmedia.curso.config;

import java.util.Properties;

import javax.persistence.*;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
public class SpringJPAConfig {
	 
	 // A anotação @Bean transforma o método dataSource em um Bean gerenciado pelo Spring. Sendo obrigatório, pois sem ele o spring não vai conseguir gerenciar a conexão
	 @Bean 
     public DataSource dataSource() {
	    DriverManagerDataSource ds = new DriverManagerDataSource();
	
	    ds.setDriverClassName("com.mysql.jdbc.Driver");
	    ds.setUrl("jdbc:mysql://localhost:3316/test");
	    ds.setUsername("root");
	    ds.setPassword("root");
	    
	    return ds;
	 }
	
	 @Bean
	 public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
	    
		 LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();                  
	    
	    factory.setDataSource(dataSource);
	    factory.setPackagesToScan("br.com.devmedia.curso.domain");
	    factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	    factory.setJpaProperties(jpaProperties());
	    factory.afterPropertiesSet();
	    
	    return factory.getObject();
	 }
	 
	 @Bean
	  public JpaTransactionManager transactionManager(EntityManagerFactory factory) {
	    
		JpaTransactionManager tx = new JpaTransactionManager();
	    
		tx.setEntityManagerFactory(factory);
	    tx.setJpaDialect(new HibernateJpaDialect());
	  
	  return tx;
	 }
	 
	 
	private Properties jpaProperties() {
		Properties props = new Properties();
		
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.format_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		
		return props;
	}	
	
}
