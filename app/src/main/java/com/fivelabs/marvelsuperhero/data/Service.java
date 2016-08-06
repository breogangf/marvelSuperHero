package com.fivelabs.marvelsuperhero.data;

import com.fivelabs.marvelsuperhero.data.model.ComicsResponse;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by breogangf on 6/8/16.
 */
public interface Service {

  @GET("/v1/public/characters/{characterId}/comics")
  ComicsResponse getComicList(@Query("limit") int limit, @Path("characterId") int characterId);

  @GET("/v1/public/characters/{characterId}/comics")
  ComicsResponse getComicList(@Query("limit") int limit, @Query("offset") int offset,
                              @Path("characterId") int characterId);
}
