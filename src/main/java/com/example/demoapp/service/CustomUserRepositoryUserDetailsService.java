package com.example.demoapp.service;

import com.example.demoapp.domain.CustomUser;
import com.example.demoapp.repository.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@NoArgsConstructor
public class CustomUserRepositoryUserDetailsService implements UserDetailsService {


    private UserRepository userRepository;
    @Autowired
    public CustomUserRepositoryUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUser customUser = userRepository.findCustomUserByUsername(username);

        if (customUser == null) {
            throw new UsernameNotFoundException("username" + username + "is not found");
        }

        return new CustomUserDetails(customUser);
    }


    static final class CustomUserDetails extends CustomUser implements UserDetails {


        private static final List<GrantedAuthority> ROLE_USER = Collections
                .unmodifiableList(AuthorityUtils.createAuthorityList("ROLE_USER"));

        public CustomUserDetails(CustomUser customUser) {
            super(customUser.getId(), customUser.getUsername(), customUser.getUsername(), customUser.isAccountNonExpired(), customUser.isAccountNonLocked(), customUser.isCredentialsNonExpired(), customUser.isEnabled(),customUser.getAuthorities());
        }


        @Override
        public Collection<GrantedAuthority> getAuthorities() {
            return ROLE_USER;
        }

        @Override
        public String getUsername() {
            return super.getUsername();
        }

        @Override
        public String getPassword() {
            return super.getPassword();
        }

        @Override
        public boolean isAccountNonExpired() {
            return super.isAccountNonExpired();
        }

        @Override
        public boolean isAccountNonLocked() {
            return super.isAccountNonLocked();
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return super.isCredentialsNonExpired();
        }

        @Override
        public boolean isEnabled() {
            return super.isEnabled();
        }
    }
}
