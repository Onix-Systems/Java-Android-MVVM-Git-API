package com.android.gitapi.domain.entity;

import com.google.gson.annotations.SerializedName;

public class RepositorySearchResponse {

    @SerializedName("id")
    int id;

    @SerializedName("description")
    String description;

    @SerializedName("owner")
    OwnerResponseEntity owner;

    @SerializedName("stargazers_count")
    int stargazersCount;

    @SerializedName("created_at")
    String createdAt;

    @SerializedName("language")
    String language;

    @SerializedName("forks")
    long forks;

    @SerializedName("html_url")
    String htmlUrl;

    @SerializedName("name")
    String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RepositorySearchResponse(int id, String description, OwnerResponseEntity owner, int stargazersCount, String createdAt, String language, long forks, String htmlUrl, String name) {
        this.id = id;
        this.description = description;
        this.owner = owner;
        this.stargazersCount = stargazersCount;
        this.createdAt = createdAt;
        this.language = language;
        this.forks = forks;
        this.htmlUrl = htmlUrl;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OwnerResponseEntity getOwner() {
        return owner;
    }

    public void setOwner(OwnerResponseEntity owner) {
        this.owner = owner;
    }

    public int getStargazersCount() {
        return stargazersCount;
    }

    public void setStargazersCount(int stargazersCount) {
        this.stargazersCount = stargazersCount;
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


    @Override
    public String toString() {
        return "RepositorySearchResponse{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", owner=" + owner +
                ", stargazersCount=" + stargazersCount +
                ", createdAt='" + createdAt + '\'' +
                ", language='" + language + '\'' +
                ", forks=" + forks +
                ", htmlUrl='" + htmlUrl + '\'' +
                '}';
    }
}
