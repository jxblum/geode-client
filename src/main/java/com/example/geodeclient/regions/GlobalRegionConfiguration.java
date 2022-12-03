package com.example.geodeclient.regions;

import org.apache.geode.cache.GemFireCache;
import org.apache.geode.cache.Scope;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.ReplicatedRegionFactoryBean;
import org.springframework.data.gemfire.config.annotation.EnableClusterConfiguration;
import org.springframework.data.gemfire.mapping.annotation.ClientRegion;

@EnableClusterConfiguration(useHttp = true)
@Configuration
@ClientRegion(shortcut = ClientRegionShortcut.PROXY)
public class GlobalRegionConfiguration {

//    @Bean("Customers")
//    ReplicatedRegionFactoryBean customersReplicatedRegion(GemFireCache cache) {
//
//        ReplicatedRegionFactoryBean region = new ReplicatedRegionFactoryBean();
//        region.setCache(cache);
//        region.setScope(Scope.GLOBAL);
//        return region;
//    }
}
