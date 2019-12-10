package com.ecommerce.apis.ecommerce.entities;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;


@Entity
@Data
@Table(name = "roles")
public class role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column
    private RoleName name;

    public role() {
    }

    public role(RoleName name) {
        this.name = name;
    }
}
