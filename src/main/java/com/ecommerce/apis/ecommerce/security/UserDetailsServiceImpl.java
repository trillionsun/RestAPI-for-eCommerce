package com.ecommerce.apis.ecommerce.security;

import com.ecommerce.apis.ecommerce.entities.user;
import com.ecommerce.apis.ecommerce.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private userRepository userRepo;

    public UserDetailsServiceImpl(userRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        user u = userRepo.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).orElseThrow(
                () -> new UsernameNotFoundException("not found that email or userName:" + usernameOrEmail)

        );
        return UserPrincipal.create(u);
    }

    // used by JWTAuthenticationFilter

    public UserDetails loadUserById(Long id) {
        user user = userRepo.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("not found with ID: " + id)
        );
        return UserPrincipal.create(user);
    }

}
