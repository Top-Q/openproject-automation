package org.openproject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * https://docs.openproject.org/api/endpoints/projects/
 */
public interface Projects {

    @GET("projects")
    Call<String> projects();

    @GET("projects/{id}")
    Call<String> projects(@Path("id") String id);

}
