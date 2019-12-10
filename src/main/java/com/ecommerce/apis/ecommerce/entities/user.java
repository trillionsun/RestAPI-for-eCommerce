package com.ecommerce.apis.ecommerce.entities;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class user {
    public user() {
    }

    public user(String username, String password, String email) {
        this();
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public user(user user)
    {
        this();
        this.username = user.username;
        this.password = user.password;
        this.email = user.email;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @NaturalId
    private String email;

    @Column
    private int active;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn,
            inverseJoinColumns = @JoinColumn
    )
    private Set<role> roles = new HashSet<>();

}
