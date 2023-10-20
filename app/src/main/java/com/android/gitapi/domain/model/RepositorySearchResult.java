package com.android.gitapi.domain.model;

import java.util.List;
public class RepositorySearchResult {
    private int totalCount;
    private List<ProjectItemModel> items;

    public RepositorySearchResult(int totalCount, List<ProjectItemModel> items) {
        this.totalCount = totalCount;
        this.items = items;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public List<ProjectItemModel> getItems() {
        return items;
    }
}
