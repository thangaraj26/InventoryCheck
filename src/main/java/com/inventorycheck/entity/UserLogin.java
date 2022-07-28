package com.inventorycheck.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_login")
public class UserLogin implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String mobileNo;

    private String password;

    private String branch;

    @Enumerated(EnumType.STRING)
    private com.inventorycheck.constant.UserLoginRole UserLoginRole;

    private Boolean locked = false;
    private Boolean enabled = true;

    public UserLogin( String mobileNo, String password,
                     String branch, com.inventorycheck.constant.UserLoginRole userLoginRole) {
        this.mobileNo = mobileNo;
        this.password = password;
        this.branch = branch;
        this.UserLoginRole = userLoginRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(UserLoginRole.name());
        return Collections.singletonList(authority);
    }

    public String getMobileNo() {
        return mobileNo;
    }

    @Override
    public String getUsername() {
        return mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public String getBranch() {
        return branch;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
