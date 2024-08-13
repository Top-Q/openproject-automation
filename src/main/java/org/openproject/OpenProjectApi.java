package org.openproject;

import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import org.interceptor.BasicAuthInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.net.URL;

public class OpenProjectApi {

    public final Projects projects;

    public final WorkPackages workPackages;

    public final Users users;

    @SneakyThrows
    public OpenProjectApi(String baseUrl, String accessToken) {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder().addInterceptor(
                new BasicAuthInterceptor("apikey", accessToken));
////                addInterceptor(logging);
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(new URL(baseUrl))
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(okHttpClientBuilder.build())
                .build();
        this.projects = retrofit.create(Projects.class);
        this.workPackages = retrofit.create(WorkPackages.class);
        this.users = retrofit.create(Users.class);
    }



}
