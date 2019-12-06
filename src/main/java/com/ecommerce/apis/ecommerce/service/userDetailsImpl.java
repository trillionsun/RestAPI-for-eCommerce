package com.ecommerce.apis.ecommerce.service;

import com.ecommerce.apis.ecommerce.entities.role;
import com.ecommerce.apis.ecommerce.entities.user;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class userDetailsImpl extends user implements UserDetails {
    public userDetailsImpl(user user) {
        super(user);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      return getRoles()
              .stream()
              .map(role-> new SimpleGrantedAuthority("ROLE_"+role.getName()))
              .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


}
