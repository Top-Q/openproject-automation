package org.openproject;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * https://www.openproject.org/docs/api/endpoints/work-packages/
 */
public interface WorkPackages {

    @GET("work_packages")
    Call<String> listWorkPackages();
}
