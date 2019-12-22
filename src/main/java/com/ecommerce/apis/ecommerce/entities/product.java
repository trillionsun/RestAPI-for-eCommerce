package com.ecommerce.apis.ecommerce.entities;



import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class product {
    @Id
    private Long id;
    private String name;
    private float price;

    private String image;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private category category;

    private long quantity;

    public product() {
    }

    public product(long id, String name, float price, String image, category category, long quantity) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.category = category;
        this.quantity = quantity;
    }

    public product(long id, String name, float price, String image, category category) {
        super();
        this.name = name;
        this.price = price;
        this.image = image;
        this.category = category;
        this.quantity = 100;
    }
}
