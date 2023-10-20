package com.android.gitapi.domain.model;

public class ProjectRequestModel {
    String query;
    String page;

    public ProjectRequestModel(String query, String page) {
        this.query = query;
        this.page = page;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
