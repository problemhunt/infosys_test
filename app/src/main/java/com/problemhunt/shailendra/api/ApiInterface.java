package com.problemhunt.shailendra.api;

import com.problemhunt.shailendra.responseschema.FactResponseSchema;

import retrofit2.Call;
import retrofit2.http.GET;

interface ApiInterface {
    @GET("s/2iodh4vg0eortkl/facts.json")
    Call<FactResponseSchema> getFact();
}
