package com.tcs.app.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public OpenAPI usersMicroserviceOpenAPI() { 
		
		Server server=new Server();
		server.setUrl("http://localhost:8067");
		server.setDescription("Server URL in Development environment");
		
		Contact contact=new Contact();
		contact.setName("Md Mustafa");
		contact.setEmail("mdrmustafa1234@gmail.com");
		contact.setUrl("https://www.AppDomainName.in");
		
		License license=new License();
		license.setName("MIT License");
		license.setName("https://choosealicense.com/licenses/mit/");
		
		Info info=new Info();
		info.setTitle("Application_Name RESTful Web Service documentation");
		info.setVersion("1.0");
		info.contact(contact);
		info.setLicense(license);
		info.setDescription("This API exposes endpoints to manage AppName.");
		info.termsOfService("https://www.AppDomainName.com/terms");
		
		return new OpenAPI().info(info).servers(List.of(server));
		
	}

}
