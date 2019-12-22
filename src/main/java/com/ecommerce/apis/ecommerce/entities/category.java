package com.ecommerce.apis.ecommerce.entities;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "categories")
public class category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column
    private categoryName name;

    public category() {
    }

    public category(categoryName name) {
        this.name = name;
    }

    public category(String name) {
        this.name = categoryName.valueOf(name);
    }
}
