package com.android.gitapi.domain.entity;

import com.google.gson.annotations.SerializedName;

public class OwnerResponseEntity {

    @SerializedName("login")
    String login;

    @SerializedName("avatar_url")
    String avatarUrl;

    public OwnerResponseEntity(String login, String avatar_url) {
        this.login = login;
        this.avatarUrl = avatar_url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public String toString() {
        return "OwnerResponseEntity{" +
                "login='" + login + '\'' +
                ", avatar_url='" + avatarUrl + '\'' +
                '}';
    }
}
