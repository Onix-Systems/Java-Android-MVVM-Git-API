package com.android.gitapi.domain.model;

import java.util.Objects;

public class ProjectItemModel {
    private long id;
    private String userName;
    private String description;
    private float stars;
    private String avatarUrl;

    public ProjectItemModel(long id, String userName, String description, float stars, String avatarUrl) {
        this.id = id;
        this.userName = userName;
        this.description = description;
        this.stars = stars;
        this.avatarUrl = avatarUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getStars() {
        return stars;
    }

    public void setStars(float stars) {
        this.stars = stars;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectItemModel that)) return false;
        return Float.compare(that.stars, stars) == 0 && Objects.equals(userName, that.userName) && Objects.equals(description, that.description) && Objects.equals(avatarUrl, that.avatarUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, description, stars, avatarUrl);
    }
}

