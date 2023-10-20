package com.android.gitapi.domain.network;

import com.android.gitapi.domain.network.entity.RepositoryListResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface NetworkApiService {
    @GET("search/repositories")
    Observable<RepositoryListResponse> searchRepositories(
            @Query("q") String query,
            @Query("page") String page,
            @Header("Authorization") String token
    );
}

