package com.inkling.rijksmuseum.collectionfeature.repository;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RijksmuseumDataSource {

    @GET("/api/en/collection")
    Call<ArtObjectsResponse> getArtObjectsByMaker(@Query("key") String key, @Query("maker") String maker,
                                                  @Query("p") int page, @Query("ps") int resultsPerPage);


}
