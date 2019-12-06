package com.ecommerce.apis.ecommerce.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class role {
    public role(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    private long id;
    private String name;



}
