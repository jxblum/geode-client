package com.example.geodeclient.regions;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.geode.config.annotation.EnableClusterAware;

@Configuration
@EnableClusterAware
@EnableEntityDefinedRegions(basePackageClasses = Customer.class)
public class GlobalRegionConfiguration {

}
