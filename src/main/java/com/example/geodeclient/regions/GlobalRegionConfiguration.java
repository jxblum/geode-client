package com.example.geodeclient.regions;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.RegionShortcut;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.GemfireTemplate;
import org.springframework.data.gemfire.config.annotation.EnableClusterConfiguration;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.config.annotation.EnablePdx;

@Configuration
@EnablePdx
@EnableEntityDefinedRegions(basePackageClasses = Customer.class)
@EnableClusterConfiguration(useHttp = true, requireHttps = false, serverRegionShortcut = RegionShortcut.REPLICATE)
public class GlobalRegionConfiguration {

	// TODO: Use either the (explicit) Java-based "Customers" Region bean definition declared below
	//  or the @EnableEntityDefinedRegions annotation as declared above.
	/*
    @Bean("Customers")
	ReplicatedRegionFactoryBean customersReplicatedRegion(GemFireCache cache) {

        ReplicatedRegionFactoryBean region = new ReplicatedRegionFactoryBean();
        region.setCache(cache);
        region.setScope(Scope.GLOBAL);
        return region;
    }
	*/

	@Bean
	GemfireTemplate customersTemplate(@Qualifier("Customers") Region<?, ?> customers) {
		return new GemfireTemplate(customers);
	}
}
