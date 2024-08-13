package org.openproject;

import retrofit2.Call;
import retrofit2.http.*;

/**
 * https://www.openproject.org/docs/api/endpoints/users/
 */
public interface Users {

    @GET("users")
    Call<String> listUsers();

    @POST("users")
    @Headers({"Content-Type: application/json"})
    Call<String> createUser(@Body String user);
}
