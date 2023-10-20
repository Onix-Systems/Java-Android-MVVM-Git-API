package com.android.gitapi.domain.network.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RepositoryListResponse {

    @SerializedName("total_count")
    int totalCount;

    @SerializedName("items")
    List<RepositorySearchResponse> items;

    public RepositoryListResponse(int total_count, List<RepositorySearchResponse> items) {
        this.totalCount = total_count;
        this.items = items;
    }


    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<RepositorySearchResponse> getItems() {
        return items;
    }

    public void setItems(List<RepositorySearchResponse> items) {
        this.items = items;
    }
}
