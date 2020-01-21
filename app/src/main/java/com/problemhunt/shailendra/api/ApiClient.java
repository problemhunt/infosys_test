package com.problemhunt.shailendra.api;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



class ApiClient {
    private static final String BASE_URL = "https://dl.dropboxusercontent.com/";
    private static Retrofit retrofit = null;



    static Retrofit getClient() {
        if (retrofit == null) {
            final OkHttpClient.Builder builder = new OkHttpClient.Builder();
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                    .client(builder.build())
                    .build();
        }
        return retrofit;
    }
}
