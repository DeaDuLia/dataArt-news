package com.dataart.javaschool.newsportal.model;

public enum Permission {
    USER_CREATE_ARTICLE("user:create_article"),
    ADMIN_DELETE_ARTICLE("admin:delete_article"),
    ADMIN_UPDATE_ARTICLE("admin:update");

    private final String permission;

    Permission (String permission) {
        this.permission = permission;
    }

    public String getPermission(){
        return permission;
    }
}
