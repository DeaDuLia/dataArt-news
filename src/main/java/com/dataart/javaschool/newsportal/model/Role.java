package com.dataart.javaschool.newsportal.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    USER(Set.of(Permission.USER_CREATE_ARTICLE)),
    ADMIN(Set.of(Permission.USER_CREATE_ARTICLE, Permission.ADMIN_DELETE_ARTICLE, Permission.ADMIN_UPDATE_ARTICLE));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions () {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities () {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }

}
