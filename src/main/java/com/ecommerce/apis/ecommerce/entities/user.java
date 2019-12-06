package com.ecommerce.apis.ecommerce.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class user {
    public user(String userName, String passWord, List<role> roles) {
        this.userName = userName;
        this.passWord = passWord;
        this.roles = roles;
    }
    public user(user user)
    {
        this.userName = user.userName;
        this.passWord = user.passWord;
        this.roles = user.getRoles();
    }
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String passWord;
    private String email;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<role> roles;


}
