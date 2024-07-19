package com.tiendavinos;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
public class TiendavinosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendavinosApplication.class, args);
	}

}
