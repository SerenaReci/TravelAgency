package com.sda.TravelAgency.security;


import com.sda.TravelAgency.entity.Role;
import com.sda.TravelAgency.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class MyUserDetails implements UserDetails {

    private User userEntity;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> userRoles = userEntity.getRoles();
        List<SimpleGrantedAuthority> listToAddAllTheAuthorizations = new ArrayList<>();
        for (Role role : userRoles) {
            listToAddAllTheAuthorizations.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return listToAddAllTheAuthorizations;
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();}
    @Override
    public String getUsername() {
        return userEntity.getEmail();
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
        return true;
    }
}
