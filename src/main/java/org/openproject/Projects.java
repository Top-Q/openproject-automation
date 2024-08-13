package org.openproject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * https://docs.openproject.org/api/endpoints/projects/
 */
public interface Projects {

    @GET("projects")
    Call<String> viewProject();

    @GET("projects/{id}")
    Call<String> viewProject(@Path("id") String id);

}
