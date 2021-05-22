package com.example.student.configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

	@Bean
	public DateFormat dateFormat() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df;
	}
	
}
