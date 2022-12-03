package com.example.geodeclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;

@SpringBootApplication
@ClientCacheApplication(name = "SpringBootApacheGeodeCacheClientApplication", locators = {
		@ClientCacheApplication.Locator(host = "localhost" , port = 10334)
})
public class GeodeClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeodeClientApplication.class, args);
	}

}
