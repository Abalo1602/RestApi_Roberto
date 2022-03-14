package com.example.restapi_roberto;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface Interface {
    @GET("random")
    Call<Model> nuevo();
}
