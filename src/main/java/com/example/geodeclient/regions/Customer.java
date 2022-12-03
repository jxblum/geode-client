package com.example.geodeclient.regions;

import org.apache.geode.cache.Scope;
import org.springframework.data.gemfire.ScopeType;
import org.springframework.data.gemfire.mapping.annotation.Region;
import org.springframework.data.gemfire.mapping.annotation.ReplicateRegion;

@ReplicateRegion(name = "Customers", scope = ScopeType.GLOBAL)
public class Customer {
    String id;
    String value;
}
