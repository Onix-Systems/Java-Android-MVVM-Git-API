package com.android.gitapi.domain.model;

import java.util.Objects;

public class ProjectItemModel {
    private long id;
    private String ownerUser;
    private String description;
    private String stars;
    private String avatarUrl;
    private String repositoryName;

    public ProjectItemModel(long id, String userName, String description, String stars, String avatarUrl, String repositoryName) {
        this.id = id;
        this.ownerUser = userName;
        this.description = description;
        this.stars = stars;
        this.avatarUrl = avatarUrl;
        this.repositoryName = repositoryName;
    }

    public String getOwnerUser() {
        return ownerUser;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public void setOwnerUser(String ownerUser) {
        this.ownerUser = ownerUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
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
        return id == that.id && Objects.equals(ownerUser, that.ownerUser) && Objects.equals(description, that.description) && Objects.equals(stars, that.stars) && Objects.equals(avatarUrl, that.avatarUrl) && Objects.equals(repositoryName, that.repositoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ownerUser, description, stars, avatarUrl, repositoryName);
    }
}

