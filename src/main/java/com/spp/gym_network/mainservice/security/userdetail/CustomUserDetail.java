package com.spp.gym_network.mainservice.security.userdetail;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.spp.gym_network.mainservice.user.jpa.data.Role;
import com.spp.gym_network.mainservice.user.jpa.data.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class CustomUserDetail implements UserDetails {
    private UserEntity user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName().toString()));
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isAccountVerified();
    }


    @Override
    public boolean equals(Object o) {
        if (o instanceof CustomUserDetail) {
            return user.getEmail().equals(((CustomUserDetail) o).user.getEmail());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return user.getEmail().hashCode();
    }
}
