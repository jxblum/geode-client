package com.example.geodeclient.regions;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.annotation.Region;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString(of = "name")
@EqualsAndHashCode
@RequiredArgsConstructor(staticName = "as")
@Region("Customers")
public class Customer implements Serializable {

    @Id
    @Setter
    private String id;

    @lombok.NonNull
    private final String name;

    public Customer identifiedBy(String id) {
        setId(id);
        return this;
    }
}
