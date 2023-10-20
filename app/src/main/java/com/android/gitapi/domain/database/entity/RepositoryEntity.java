package com.android.gitapi.domain.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "repository_table")
public class RepositoryEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String ownerUser;
    private String description;
    private String stars;
    private String avatarUrl;
    private String repositoryName;
    private String language;
    private long forks;
    private String createdAt;
    private String htmlUrl;


    public RepositoryEntity(int id, String ownerUser, String description, String stars, String avatarUrl, String repositoryName, String language, long forks, String createdAt, String htmlUrl) {
        this.id = id;
        this.ownerUser = ownerUser;
        this.description = description;
        this.stars = stars;
        this.avatarUrl = avatarUrl;
        this.repositoryName = repositoryName;
        this.language = language;
        this.forks = forks;
        this.createdAt = createdAt;
        this.htmlUrl = htmlUrl;
    }

    public RepositoryEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwnerUser() {
        return ownerUser;
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

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public long getForks() {
        return forks;
    }

    public void setForks(long forks) {
        this.forks = forks;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    @Override
    public String toString() {
        return "RepositoryEntity{" +
                "id=" + id +
                ", ownerUser='" + ownerUser + '\'' +
                ", description='" + description + '\'' +
                ", stars='" + stars + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", repositoryName='" + repositoryName + '\'' +
                ", language='" + language + '\'' +
                ", forks=" + forks +
                ", createdAt='" + createdAt + '\'' +
                ", htmlUrl='" + htmlUrl + '\'' +
                '}';
    }
}
