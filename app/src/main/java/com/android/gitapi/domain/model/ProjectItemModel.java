package com.android.gitapi.domain.model;


public class ProjectItemModel {
    private int id;
    private String ownerUser;
    private String description;
    private String stars;
    private String avatarUrl;
    private String repositoryName;
    private String createdAt;
    private String language;
    private long forks;
    private String htmlUrl;
    private boolean isFavourite = false;

    public ProjectItemModel(int id, String ownerUser, String description, String stars, String avatarUrl, String repositoryName, String createdAt, String language, long forks, String htmlUrl) {
        this.id = id;
        this.ownerUser = ownerUser;
        this.description = description;
        this.stars = stars;
        this.avatarUrl = avatarUrl;
        this.repositoryName = repositoryName;
        this.createdAt = createdAt;
        this.language = language;
        this.forks = forks;
        this.htmlUrl = htmlUrl;
    }

    public ProjectItemModel() {
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
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

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ProjectItemModel{" +
                "id=" + id +
                ", ownerUser='" + ownerUser + '\'' +
                ", description='" + description + '\'' +
                ", stars='" + stars + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", repositoryName='" + repositoryName + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", language='" + language + '\'' +
                ", forks=" + forks +
                ", htmlUrl='" + htmlUrl + '\'' +
                ", isFavourite=" + isFavourite +
                '}';
    }
}

