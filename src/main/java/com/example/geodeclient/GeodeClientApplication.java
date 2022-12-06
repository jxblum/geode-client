package com.example.geodeclient;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import com.example.geodeclient.regions.Customer;

import org.apache.geode.cache.DataPolicy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.gemfire.GemfireTemplate;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;

@SpringBootApplication
@ClientCacheApplication(
	name = "SpringBootApacheGeodeCacheClientApplication",
	locators = { @ClientCacheApplication.Locator }
)
public class GeodeClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeodeClientApplication.class, args);
	}

	@Bean
	ApplicationRunner runner(@Qualifier("customersTemplate") GemfireTemplate customersTemplate) {

		return args -> {

			assertThat(customersTemplate).isNotNull();
			assertThat(customersTemplate.getRegion()).isNotNull();
			assertThat(customersTemplate.getRegion().getName()).isEqualTo("Customers");
			assertThat(customersTemplate.getRegion().getAttributes()).isNotNull();
			assertThat(customersTemplate.getRegion().getAttributes().getDataPolicy()).isEqualTo(DataPolicy.EMPTY);

			Customer jonDoe = Customer.as("Jon Doe").identifiedBy(UUID.randomUUID().toString());

			customersTemplate.put(jonDoe.getId(), jonDoe);

			System.err.printf("Saved Customer [%s]!!%n", jonDoe);
		};
	}
}
