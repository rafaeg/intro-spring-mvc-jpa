package br.com.devmedia.curso.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

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
	
	 	
	
}
